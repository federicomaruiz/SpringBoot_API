package com.utad.Favoritos.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "fav_serie")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSerie;
    @Column(nullable = false)
    private String name;
    private String genre;
    private Integer year;
    private Integer ranking;

    @ManyToMany
    @JoinTable(name = "serie_actor", joinColumns = @JoinColumn(name = "serie_id"), inverseJoinColumns = @JoinColumn(name =
            "actor_id"))
    private Set<Actor> actores = new HashSet<>();


    @ManyToOne
    @JoinColumn( name = "productor_id")
    private Productor productor;


}
