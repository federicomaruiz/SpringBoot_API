package com.utad.Favoritos.repository;

import com.utad.Favoritos.model.Productor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductorRepository extends JpaRepository<Productor,Long> {
    
}
