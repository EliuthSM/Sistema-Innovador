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

    public UsuarioResponseDTO login(String correo, String contrasena) {
        Usuario usuario = usuarioDAO.findByCorreo(correo);

        // IMPORTANTE: Aquí se debe encriptar la contraseña de entrada para compararla con el hash en la BD
        String contrasenaEncriptada = EncriptarClave.encriptar(contrasena);

        if (usuario != null && usuario.getContrasenaHash().equals(contrasenaEncriptada)) { // Contrasena ya está encriptada
            return null; //UsuarioMapper.toResponse(usuario); // Retorna el DTO de respuesta
        }
        return null; // Login fallido
    }

    public UsuarioResponseDTO registrarCliente(RegistroClienteRequestDTO request) throws IllegalArgumentException {
        // 1. Validación de unicidad de correo
        if (usuarioDAO.existsByCorreo(request.getCorreo())) {
            throw new IllegalArgumentException("El correo '" + request.getCorreo() + "' ya está registrado.");
        }

        // 2. Mapear DTO a Entidad Usuario
        Usuario nuevoUsuario = UsuarioMapper.fromClienteRequest(request);
        
        // 3. Encriptación de Contraseña (USANDO SHA-256)
        String hashedPassword = EncriptarClave.encriptar(request.getContrasena());
        nuevoUsuario.setContrasenaHash(hashedPassword);
        
        // 4. Inserción en la base de datos
        if (usuarioDAO.insert(nuevoUsuario)) {
             // 5. Opcional: obtener el usuario recién creado para el DTO de respuesta (necesita el ID)
             Usuario usuarioRegistrado = usuarioDAO.findByCorreo(request.getCorreo());
             return null; //UsuarioMapper.toResponse(usuarioRegistrado);
        } else {
             throw new RuntimeException("Fallo desconocido al insertar el usuario en la BD.");
        }
    }

 public UsuarioResponseDTO registrarProfesional(RegistroProfesionalRequestDTO request) {
        // --- INICIO DE TRANSACCIÓN --- (Idealmente manejado en una capa de transacción)
        if (usuarioDAO.existsByCorreo(request.getCorreo())) {
            throw new IllegalArgumentException("El correo ya está registrado.");
        }

        // 1. Crear el Usuario base (Hashear clave y establecer Rol='Profesional')
        Usuario nuevoUsuario = UsuarioMapper.fromProfesionalRequestToUsuario(request);
        
        // 2. Encriptación de Contraseña (USANDO SHA-256)
        String hashedPassword = EncriptarClave.encriptar(request.getContrasena());
        nuevoUsuario.setContrasenaHash(hashedPassword);
        
        // Insertar usuario y obtener el ID generado
        usuarioDAO.insert(nuevoUsuario);
        
        Usuario usuarioRegistrado = usuarioDAO.findByCorreo(request.getCorreo());
        int nuevoUsuarioId = usuarioRegistrado.getUsuarioId(); // Se asume que Usuario.java tiene un campo 'usuarioId'

        // 3. Crear el Perfil Profesional
        Profesional nuevoProfesional = ProfesionalMapper.fromProfesionalRequest(request);
        nuevoProfesional.setUsuarioId(nuevoUsuarioId);
        profesionalDAO.insert(nuevoProfesional);

        // 4. Vincular Categorías y Habilidades (usando sus respectivos DAOs)
        // Lógica pendiente...

        // --- FIN DE TRANSACCIÓN ---
        return null; //UsuarioMapper.toResponse(usuarioRegistrado);
    }
}
