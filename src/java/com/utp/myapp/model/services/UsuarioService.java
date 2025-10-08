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

public class UsuarioService {

    private final UsuarioDAO usuarioDAO;
    private final ProfesionalDAO profesionalDAO;
    // NOTA: Para registrar un profesional, también necesitarás ProfesionalCategoriasDAO y ProfesionalHabilidadesDAO

    public UsuarioService() {
        this.usuarioDAO = new UsuarioDAO();
        this.profesionalDAO = new ProfesionalDAO();
    }

    public UsuarioResponseDTO login(String correo, String contrasena) {
        Usuario usuario = usuarioDAO.findByCorreo(correo);

        // IMPORTANTE: Aquí se debe comparar la contraseña hasheada, no en texto plano.
        // Ejemplo: if (usuario != null && BCrypt.checkpw(contrasena, usuario.getContrasenaHash())) { ... }
        if (usuario != null && usuario.getContrasenaHash().equals(contrasena)) { // Simplificado para el ejemplo
            return null; //UsuarioMapper.toResponse(usuario);
        }
        return null;
    }

    public UsuarioResponseDTO registrarCliente(RegistroClienteRequestDTO request) {
        if (usuarioDAO.existsByCorreo(request.getCorreo())) {
            throw new IllegalArgumentException("El correo ya está registrado.");
        }
        
        Usuario nuevoUsuario = UsuarioMapper.fromClienteRequest(request);
        
        // IMPORTANTE: Hashear la contraseña antes de guardarla.
        // String hashedPassword = BCrypt.hashpw(request.getContrasena(), BCrypt.gensalt());
        // nuevoUsuario.setContrasenaHash(hashedPassword);

        usuarioDAO.insert(nuevoUsuario);
        
        // Devolvemos el usuario recién creado para obtener su ID
        Usuario usuarioRegistrado = usuarioDAO.findByCorreo(request.getCorreo());
        return null; //UsuarioMapper.toResponse(usuarioRegistrado);
    }

    public UsuarioResponseDTO registrarProfesional(RegistroProfesionalRequestDTO request) {
        // --- INICIO DE TRANSACCIÓN ---
        // Esta operación debe ser transaccional. Si algo falla, todo debe revertirse.
        if (usuarioDAO.existsByCorreo(request.getCorreo())) {
            throw new IllegalArgumentException("El correo ya está registrado.");
        }

        // 1. Crear el Usuario base
        Usuario nuevoUsuario = UsuarioMapper.fromProfesionalRequestToUsuario(request);
        // Hashear contraseña...
        usuarioDAO.insert(nuevoUsuario);
        
        Usuario usuarioRegistrado = usuarioDAO.findByCorreo(request.getCorreo());
        int nuevoUsuarioId = usuarioRegistrado.getUsuarioId();

        // 2. Crear el Perfil Profesional
        Profesional nuevoProfesional = ProfesionalMapper.fromProfesionalRequest(request);
        nuevoProfesional.setUsuarioId(nuevoUsuarioId);
        profesionalDAO.insert(nuevoProfesional);

        // 3. Vincular Categorías y Habilidades (usando sus respectivos DAOs)
        // profesionalCategoriasDAO.link(nuevoUsuarioId, request.getCategoriaPrincipalId());
        // for (Integer habilidadId : request.getHabilidadesIds()) {
        //     profesionalHabilidadesDAO.link(nuevoUsuarioId, habilidadId);
        // }

        // --- FIN DE TRANSACCIÓN ---
        return null; //UsuarioMapper.toResponse(usuarioRegistrado);
    }
}