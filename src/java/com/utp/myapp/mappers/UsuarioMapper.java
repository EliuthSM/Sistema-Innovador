package com.utp.myapp.mappers;

import com.utp.myapp.dtos.RegistroClienteRequestDTO;
import com.utp.myapp.dtos.RegistroProfesionalRequestDTO;
import com.utp.myapp.dtos.UsuarioResponseDTO;
import com.utp.myapp.model.entities.Usuario;

public class UsuarioMapper {

// --- De DTO Request a Entidad ---
    /**
     * Convierte un RegistroClienteRequestDTO a una entidad Usuario. La
     * contraseñaHash se asigna posteriormente en el Service.
     */
    public static Usuario fromClienteRequest(RegistroClienteRequestDTO request) {
        if (request == null) {
            return null;
        }

        // NOTA: La contraseña no se setea aquí, se setea como HASH en el Service.
        return new Usuario.Builder()
                .nombreCompleto(request.getNombreCompleto())
                .correoElectronico(request.getCorreo())
                // .contrasenaHash(request.getContrasena()) <--- ELIMINADO: Se maneja en el Service
                .rol("Cliente") // Establece el rol automáticamente
                .build();
    }

    /**
     * Convierte un RegistroProfesionalRequestDTO a la entidad Usuario base. La
     * contraseñaHash se asigna posteriormente en el Service.
     */
    public static Usuario fromProfesionalRequestToUsuario(RegistroProfesionalRequestDTO request) {
        if (request == null) {
            return null;
        }

        // NOTA: La contraseña no se setea aquí, se setea como HASH en el Service.
        return new Usuario.Builder()
                .nombreCompleto(request.getNombreCompleto())
                .correoElectronico(request.getCorreo())
                // .contrasenaHash(request.getContrasena()) <--- ELIMINADO: Se maneja en el Service
                .rol("Profesional") // Establece el rol automáticamente
                .build();
    }

// --- De Entidad a DTO Response ---

    /*public static UsuarioResponseDTO toResponse(Usuario usuario) {
        if (usuario == null) return null;
        
        return new UsuarioResponseDTO(
                usuario.getUsuarioId(),
                usuario.getNombreCompleto(),
                usuario.getCorreoElectronico(),
                usuario.getRol()
        );
    }*/
}
