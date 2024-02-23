package com.utad.Favoritos.service;

import com.utad.Favoritos.model.Serie;
import com.utad.Favoritos.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerieService {

    @Autowired
    SerieRepository serieRepository;

    public List<Serie> getSeries(){
        return serieRepository.findAll();
    }

    public Optional<Serie> getSerie(Long id){
        return serieRepository.findById(id);
    }
    public Serie saveOrUpdate(Serie serie){
        return serieRepository.save(serie);
    }

    public void delete(Long id){
        serieRepository.deleteById(id);
    }

    public List<Serie> searchByName(String name){
        return serieRepository.findByNameContainingIgnoreCase(name);
    }

    public Serie save(Serie serie){
        return serieRepository.save(serie);
    }

    public List<Serie> getByYearRange(Integer startYear, Integer endYear) {
        return serieRepository.findByYearBetween(startYear, endYear);
    }

    public List<Serie> getTopRated() {
        return serieRepository.findTop10ByOrderByRankingAsc();
    }

    public List<Serie> getByGenre(String genre) {
        return serieRepository.findByGenre(genre);
    }

}
