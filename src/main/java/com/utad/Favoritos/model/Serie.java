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
    @JoinColumn(name = "productor_id")
    private Productor productor;

    // Método setter para el nombre
    public void setNombre(String nombre) {
        this.name = nombre;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Long getIdSerie() {
        return idSerie;
    }

    public String getGenre() {
        return genre;
    }

    public Integer getYear() {
        return year;
    }

    public Integer getRanking() {
        return ranking;
    }

    public Set<Actor> getActores() {
        return actores;
    }

    public Productor getProductor() {
        return productor;
    }

    public String getName() {
        return name;
    }


    public void setIdSerie(Long idSerie) {
        this.idSerie = idSerie;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public void setActores(Set<Actor> actores) {
        this.actores = actores;
    }

    public void setProductor(Productor productor) {
        this.productor = productor;
    }

}
