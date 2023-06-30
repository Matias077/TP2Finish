package org.ejemplo.controladores;

import org.ejemplo.exceptions.UserAuthenticationException;
import org.ejemplo.exceptions.UserRegistrationException;
import org.ejemplo.modelos.Login;
import org.ejemplo.modelos.Usuario;
import org.ejemplo.servicios.UsersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsuarioController {
    private final UsersService usersService;

    public UsuarioController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/registry")
    public ResponseEntity<String> registryUser(@RequestBody Usuario usuario) {
        try {
            usersService.registrarUsuario(usuario);
            return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado correctamente");
        } catch (UserRegistrationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login login) {
        try {
            String role = usersService.login(login);
            return ResponseEntity.ok(role);
        } catch (UserAuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
}

