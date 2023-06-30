package org.ejemplo.servicios;

import org.ejemplo.exceptions.UserAuthenticationException;
import org.ejemplo.modelos.Login;
import org.ejemplo.modelos.Usuario;
import org.ejemplo.repository.UsuarioRepository;
import org.ejemplo.validations.UserValidations;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UsuarioRepository usuarioRepository;
    private final UserValidations userValidations;

    public UsersService(UsuarioRepository usuarioRepository, UserValidations userValidations) {
        this.usuarioRepository = usuarioRepository;
        this.userValidations = userValidations;
    }

    public void registrarUsuario(Usuario usuario) {
        userValidations.validateExistingUser(usuario.getUser());
        userValidations.validateRole(usuario.getRole());

        usuarioRepository.save(usuario);
    }

    private boolean autenticarUsuario(Login login) {
        Usuario usuarioDB = usuarioRepository.findByUser(login.getUser())
                .orElseThrow(() -> new UserAuthenticationException("Usuario no encontrado"));

        return usuarioDB.getPassword().equals(login.getPassword());
    }

    public String login(Login login) {
        if (autenticarUsuario(login)) {
            Usuario usuarioDB = usuarioRepository.findByUser(login.getUser())
                    .orElseThrow(() -> new UserAuthenticationException("Usuario no encontrado"));

            return usuarioDB.getRole();
        } else {
            throw new UserAuthenticationException("Usuario o contraseña incorrectos");
        }
    }
}

