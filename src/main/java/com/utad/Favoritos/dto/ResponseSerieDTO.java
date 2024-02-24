package com.utad.Favoritos.dto;

import com.utad.Favoritos.model.Actor;
import com.utad.Favoritos.model.Productor;

import java.util.Set;

public class ResponseSerieDTO {

    private Long idPlato;

    private String nameSerie;

    private Set<Actor> actores;

    private Productor productor;

}
