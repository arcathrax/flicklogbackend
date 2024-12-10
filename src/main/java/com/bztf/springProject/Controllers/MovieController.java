package com.bztf.springProject.Controllers;

import com.bztf.springProject.Exception.MovieNotFoundException;
import com.bztf.springProject.Exception.RegisseurNotFoundException;
import com.bztf.springProject.Exception.GenreNotFoundException;
import com.bztf.springProject.Models.Movie;
import com.bztf.springProject.Models.Regisseur;
import com.bztf.springProject.Models.Genre;
import com.bztf.springProject.Repositories.MovieRepository;
import com.bztf.springProject.Repositories.RegisseurRepository;
import com.bztf.springProject.Repositories.GenreRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    private final MovieRepository movieRepository;
    private final RegisseurRepository regisseurRepository;
    private final GenreRepository genreRepository;

    public MovieController(MovieRepository movieRepository,
                           RegisseurRepository regisseurRepository,
                           GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.regisseurRepository = regisseurRepository;
        this.genreRepository = genreRepository;
    }

    @CrossOrigin
    @GetMapping("/movies")
    List<Movie> all() {
        return movieRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/movies/{id}")
    Movie one(@PathVariable Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    @CrossOrigin
    @PostMapping("/movies")
    Movie newMovie(@RequestBody Movie newMovie) {
        // Validierung des Regisseurs
        Regisseur regisseur = regisseurRepository.findById(newMovie.getRegisseur().getId())
                .orElseThrow(() -> new RegisseurNotFoundException(newMovie.getRegisseur().getId()));

        // Validierung des Genres
        Genre genre = genreRepository.findById(newMovie.getGenre().getId())
                .orElseThrow(() -> new GenreNotFoundException(newMovie.getGenre().getId()));

        // Verknüpfen der Entitäten
        newMovie.setRegisseur(regisseur);
        newMovie.setGenre(genre);

        return movieRepository.save(newMovie);
    }

    @CrossOrigin
    @PutMapping("/movies/{id}")
    Movie replaceMovie(@RequestBody Movie newMovie, @PathVariable Long id) {
        // Validierung des Regisseurs
        Regisseur regisseur = regisseurRepository.findById(newMovie.getRegisseur().getId())
                .orElseThrow(() -> new RegisseurNotFoundException(newMovie.getRegisseur().getId()));

        // Validierung des Genres
        Genre genre = genreRepository.findById(newMovie.getGenre().getId())
                .orElseThrow(() -> new GenreNotFoundException(newMovie.getGenre().getId()));

        return movieRepository.findById(id)
                .map(movie -> {
                    movie.setTitle(newMovie.getTitle());
                    movie.setReleaseYear(newMovie.getReleaseYear());
                    movie.setDescription(newMovie.getDescription());
                    movie.setWatched(newMovie.isWatched());
                    movie.setRegisseur(regisseur);
                    movie.setGenre(genre);
                    return movieRepository.save(movie);
                })
                .orElseGet(() -> {
                    newMovie.setRegisseur(regisseur);
                    newMovie.setGenre(genre);
                    return movieRepository.save(newMovie);
                });
    }

    @CrossOrigin
    @DeleteMapping("/movies/{id}")
    void deleteMovie(@PathVariable Long id) {
        movieRepository.deleteById(id);
    }
}
