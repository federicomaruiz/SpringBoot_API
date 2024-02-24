package com.utad.Favoritos.repository;

import com.utad.Favoritos.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ActorRepository extends JpaRepository<Actor, Long> {

}
