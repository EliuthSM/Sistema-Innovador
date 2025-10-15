package com.utp.myapp.model.services;

import com.utp.myapp.dtos.RegistroClienteRequestDTO;
import com.utp.myapp.dtos.RegistroProfesionalRequestDTO;
import com.utp.myapp.dtos.UsuarioResponseDTO;
import com.utp.myapp.mappers.ProfesionalMapper;
import com.utp.myapp.mappers.UsuarioMapper;
import com.utp.myapp.model.dao.ProfesionalDAO;
import com.utp.myapp.model.dao.UsuarioDAO;
import com.utp.myapp.model.entities.Profesional;
import com.utp.myapp.model.entities.Usuario;
import com.utp.myapp.security.EncriptarClave;

public class UsuarioService {

    private final UsuarioDAO usuarioDAO;
    private final ProfesionalDAO profesionalDAO;
    // NOTA: Para registrar un profesional, también necesitarás ProfesionalCategoriasDAO y ProfesionalHabilidadesDAO

    public UsuarioService() {
        this.usuarioDAO = new UsuarioDAO();
        this.profesionalDAO = new ProfesionalDAO();
    }

    // LOGIN
    public UsuarioResponseDTO login(String correo, String contrasena) {
        Usuario usuario = usuarioDAO.buscarPorCorreo(correo);
        // IMPORTANTE: Aquí se debe comparar la contraseña hasheada, no en texto plano.  
        // Ejemplo: if (usuario != null && BCrypt.checkpw(contrasena, usuario.getContrasenaHash())) { ... }
        if (usuario != null && EncriptarClave.verificar(contrasena, usuario.getContrasenaHash())) {

            // Convertimos el entity a DTO para enviarlo al AuthController
            UsuarioResponseDTO dto = new UsuarioResponseDTO();
            dto.setUsuarioId(usuario.getUsuarioId());
            dto.setNombreCompleto(usuario.getNombreCompleto());
            dto.setCorreo(usuario.getCorreoElectronico());
            dto.setRol(usuario.getRol());
            dto.setFechaRegistro(usuario.getFechaRegistro());
            return UsuarioMapper.toResponse(usuario);
        }
        return null; // credenciales incorrectas
    }

    public UsuarioResponseDTO registrarCliente(RegistroClienteRequestDTO request) {
        if (usuarioDAO.existsByCorreo(request.getCorreo())) {
            throw new IllegalArgumentException("El correo ya está registrado.");
        }
        Usuario nuevoUsuario = UsuarioMapper.fromClienteRequest(request);

        // IMPORTANTE: Hashear la contraseña antes de guardarla.
        String hashedPassword = EncriptarClave.encriptar(request.getContrasena());
        nuevoUsuario.setContrasenaHash(hashedPassword);
        // Insertamos el usuario
        usuarioDAO.insert(nuevoUsuario);

        // Devolvemos el usuario recién creado para obtener su ID
        Usuario usuarioRegistrado = usuarioDAO.buscarPorCorreo(request.getCorreo());
        return UsuarioMapper.toResponse(usuarioRegistrado);
    }

    // REGISTRAR PROFESIONAL
    public UsuarioResponseDTO registrarProfesional(RegistroProfesionalRequestDTO request) {
        // --- INICIO DE TRANSACCIÓN ---
        // Esta operación debe ser transaccional. Si algo falla, todo debe revertirse.
        if (usuarioDAO.existsByCorreo(request.getCorreo())) {
            throw new IllegalArgumentException("El correo ya está registrado.");
        }
        // Crear el Usuario base
        Usuario nuevoUsuario = UsuarioMapper.fromProfesionalRequestToUsuario(request);
        
        // Hashear la contraseña antes de guardar
        String hashedPassword = EncriptarClave.encriptar(request.getContrasena());
        nuevoUsuario.setContrasenaHash(hashedPassword);
        
        // Guardar el usuario en la BD
        usuarioDAO.insert(nuevoUsuario);
        
        // Obtener ID del usuario registrado
        Usuario usuarioRegistrado = usuarioDAO.buscarPorCorreo(request.getCorreo());
        int nuevoUsuarioId = usuarioRegistrado.getUsuarioId();

        // Crear el Perfil Profesional
        Profesional nuevoProfesional = ProfesionalMapper.fromProfesionalRequest(request);
        nuevoProfesional.setUsuarioId(nuevoUsuarioId);
        profesionalDAO.insert(nuevoProfesional);

        // 3. Vincular Categorías y Habilidades (usando sus respectivos DAOs)
        // profesionalCategoriasDAO.link(nuevoUsuarioId, request.getCategoriaPrincipalId());
        // for (Integer habilidadId : request.getHabilidadesIds()) {
        //     profesionalHabilidadesDAO.link(nuevoUsuarioId, habilidadId);
        // TODO: Vincular categorías y habilidades usando sus DAOs
        // }
        // --- FIN DE TRANSACCIÓN ---
        return UsuarioMapper.toResponse(usuarioRegistrado);
    }
}
