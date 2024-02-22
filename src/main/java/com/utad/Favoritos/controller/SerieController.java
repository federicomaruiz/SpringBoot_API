package com.utad.Favoritos.controller;

import com.utad.Favoritos.model.Serie;
import com.utad.Favoritos.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/series")
public class SerieController {  // Respuestas

    private final SerieService serieService; // Logica de negocio  el servicio

    @Autowired // Inyeccion de dependencia
    public SerieController(SerieService serieService) {
        this.serieService = serieService;
    }

    @PostMapping
    public ResponseEntity<Serie> save(@RequestBody Serie serie) {
        Serie serieNew = serieService.saveOrUpdate(serie);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(serieNew);
    }

    @GetMapping
    public ResponseEntity<List<Serie>> getAll() {
        List<Serie> series = serieService.getSeries();
        return ResponseEntity.ok(series);
    }

    @GetMapping("/{idSerie}")
    public ResponseEntity<Optional<Serie>> getById(@PathVariable Long idSerie) {
        Optional<Serie> serie = serieService.getSerie(idSerie);

        if (serie.isPresent()) {
            return ResponseEntity.ok(serie);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<Serie>> searchMovies(@RequestParam String name) {
        List<Serie> series = serieService.searchByName(name);
        return ResponseEntity.ok(series);
    }


    @DeleteMapping("/{idSerie}")
    public ResponseEntity<Optional<Serie>> delete(@PathVariable Long idSerie) {
        serieService.delete(idSerie);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{idSerie}/name")
    public ResponseEntity<Serie> actualizarNombre(@PathVariable Long idSerie, @RequestBody String name) {
        Optional<Serie> serieOptional = serieService.getSerie(idSerie);

        if (serieOptional.isPresent()) {
            Serie serie = serieOptional.get();
            serie.setName(name);
            Serie serieActualizada = serieService.saveOrUpdate(serie);
            return ResponseEntity.ok(serieActualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{idSerie}")
    public ResponseEntity<Serie> actualizarSerie(@PathVariable Long idSerie, @RequestBody Serie serieActualizada) {
        Optional<Serie> serieOptional = serieService.getSerie(idSerie);

        if (serieOptional.isPresent()) {
            Serie serie = serieOptional.get();

            // Actualizar campos si se proporcionan en el cuerpo de la solicitud
            if (serieActualizada.getName() != null) {
                serie.setName(serieActualizada.getName());
            }
            if (serieActualizada.getGenre() != null) {
                serie.setGenre(serieActualizada.getGenre());
            }
            if (serieActualizada.getYear() != null) {
                serie.setYear(serieActualizada.getYear());
            }
            if (serieActualizada.getRanking() != null) {
                serie.setRanking(serieActualizada.getRanking());
            }

            // Guardar la serie actualizada en la base de datos
            Serie serieActualizadaEnBD = serieService.saveOrUpdate(serie);
            return ResponseEntity.ok(serieActualizadaEnBD);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}


