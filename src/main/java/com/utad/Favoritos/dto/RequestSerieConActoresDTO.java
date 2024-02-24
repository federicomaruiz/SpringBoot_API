package com.utad.Favoritos.dto;

import java.util.HashSet;
import java.util.Set;

public class RequestSerieConActoresDTO {


    private String name;

    private Set<Long> actorList = new HashSet<>();

    private Long productor;

    public void setName(String name) {
        this.name = name;
    }

    public void setActorList(Set<Long> actorList) {
        this.actorList = actorList;
    }

    public void setProductor(Long productor) {
        this.productor = productor;
    }



    public String getName() {
        return name;
    }

    public Set<Long> getActorList() {
        return actorList;
    }

    public Long getProductor() {
        return productor;
    }





}
