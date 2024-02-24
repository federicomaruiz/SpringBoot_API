package com.utad.Favoritos.service;

import com.utad.Favoritos.dto.RequestSerieConActoresDTO;
import com.utad.Favoritos.model.Actor;
import com.utad.Favoritos.model.Productor;
import com.utad.Favoritos.model.Serie;
import com.utad.Favoritos.repository.ActorRepository;
import com.utad.Favoritos.repository.ProductorRepository;
import com.utad.Favoritos.repository.SerieRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class SerieService {

    private final ProductorRepository productorRepository;
    private final ActorRepository actorRepository;
    private final SerieRepository serieRepository;

    @Autowired
    public SerieService(ProductorRepository productorRepository, ActorRepository actorRepository, SerieRepository serieRepository){
        this.productorRepository = productorRepository;
        this.actorRepository = actorRepository;
        this.serieRepository = serieRepository;
    }

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


    // Si sale algun error hace RollBack vuelve todoo para atras (transactional)
    @Transactional
    public void addSerieWithActoresAndProductor(RequestSerieConActoresDTO serieDTO){

        // Crear serie nueva
        Serie serie = new Serie();
        serie.setName(serieDTO.getName());

        // Con los ID que nos llegan buscarlos
        List<Actor> actores = actorRepository.findAllById(serieDTO.getActorList());

        // Meter los actores en el objeto serie
        serie.setActores(new HashSet<>(actores));

        // Buscamos al productor por ID y lo añadimos
        Productor productor = productorRepository.findById(serieDTO.getProductor()).orElseThrow( () -> new RuntimeException("Autor no encontrado"));
        serie.setProductor(productor);

        // Guardamos la serie en la BD
        serieRepository.save(serie);
    }

}
