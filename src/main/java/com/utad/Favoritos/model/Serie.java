package com.utad.Favoritos.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="fav_serie")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSerie;
    @Column(nullable = false)
    private String name;
    private String genre;
    private Integer year;
    private Integer ranking;

    // Método setter para el nombre
    public void setNombre(String nombre) {
        this.name = nombre;
    }


}
