package com.bztf.springProject.Controllers;

import com.bztf.springProject.Exception.GenreNotFoundException;
import com.bztf.springProject.Models.Genre;
import com.bztf.springProject.Models.Regisseur;
import com.bztf.springProject.Repositories.GenreRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GenreController {
    private final GenreRepository repository;

    public GenreController(GenreRepository repository){
        this.repository = repository;
    }

    // get all genres
    @CrossOrigin
    @GetMapping("/genres")
    List<Genre> all(){
        return repository.findAll();
    }

    // get single item
    @CrossOrigin
    @GetMapping("/genres/{id}")
    Genre one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new GenreNotFoundException(id));
    }

    // put single item
    @CrossOrigin
    @PutMapping("/genres/{id}")
    Genre replaceGenre(@RequestBody Genre newGenre, @PathVariable Long id){
        return repository.findById(id)
                .map( genre -> {
                    genre.setName(newGenre.getName());
                    return repository.save(genre);
                })
                .orElseGet(() -> {
                   return repository.save(newGenre);
                });
    }
}
