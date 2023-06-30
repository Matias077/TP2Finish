package org.ejemplo.modelos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "username")
    private String user;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private String role;
}
