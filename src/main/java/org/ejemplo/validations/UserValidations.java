package org.ejemplo.validations;

import org.ejemplo.exceptions.UserRegistrationException;
import org.ejemplo.repository.UsuarioRepository;

public class UserValidations {
    private final UsuarioRepository usuarioRepository;

    public UserValidations(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void validateExistingUser(String username) {
        if (usuarioRepository.findByUser(username).isPresent()) {
            throw new UserRegistrationException("El nombre de usuario ya está registrado");
        }
    }

    public void validateRole(String role) {
        if (!role.equals("administrador") && !role.equals("vendedor")) {
            throw new UserRegistrationException("El rol del usuario es inválido");
        }
    }
}


