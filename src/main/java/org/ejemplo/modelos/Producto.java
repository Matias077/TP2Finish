package org.ejemplo.modelos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "productos")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Producto {
    @Id
    @Column(name = "codigo")
    private String codigo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha_creacion")
    private Date fechaActualizacion;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "precio")
    private Double precio;

    @PrePersist
    public void prePersist() {
        fechaActualizacion = new Date();
    }
}
