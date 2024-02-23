package com.utad.Favoritos.repository;

import com.utad.Favoritos.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends JpaRepository<Serie,Long> {

    List <Serie> findByNameContainingIgnoreCase(String name);
    List<Serie> findByGenre(String genre);
    List<Serie> findByYearBetween(Integer startYear, Integer endYear);
    List<Serie> findTop10ByOrderByRankingAsc(); // Cambio aquí: Orden ascendente
}
