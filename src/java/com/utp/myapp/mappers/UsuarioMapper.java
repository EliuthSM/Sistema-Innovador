package com.utp.myapp.mappers;

import com.utp.myapp.dtos.RegistroClienteRequestDTO;
import com.utp.myapp.dtos.RegistroProfesionalRequestDTO;
import com.utp.myapp.dtos.UsuarioResponseDTO;
import com.utp.myapp.model.entities.Usuario;

public class UsuarioMapper {

    // --- De DTO Request a Entidad ---
    public static Usuario fromClienteRequest(RegistroClienteRequestDTO request) {
        if (request == null) {
            return null;
        }

        // Aquí iría el hash de la contraseña
        // String hashedPassword = SecurityUtil.hashPassword(request.getContrasena());
        return new Usuario.Builder()
                .nombreCompleto(request.getNombreCompleto())
                .correoElectronico(request.getCorreo())
                .contrasenaHash(request.getContrasena()) // Temporalmente en texto plano
                .rol("Cliente")
                .build();
    }

    public static Usuario fromProfesionalRequestToUsuario(RegistroProfesionalRequestDTO request) {
        if (request == null) {
            return null;
        }

        return new Usuario.Builder()
                .nombreCompleto(request.getNombreCompleto())
                .correoElectronico(request.getCorreo())
                .contrasenaHash(request.getContrasena()) // Temporalmente en texto plano
                .rol("Profesional")
                .build();
    }

    // --- De Entidad a DTO Response ---
    public static UsuarioResponseDTO toResponse(Usuario usuario) {
        if (usuario == null) {
            return null;
        }
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setUsuarioId(usuario.getUsuarioId());
        dto.setNombreCompleto(usuario.getNombreCompleto());
        dto.setCorreo(usuario.getCorreoElectronico());
        dto.setRol(usuario.getRol());
        dto.setFechaRegistro(usuario.getFechaRegistro());
        return dto;

    }

}
