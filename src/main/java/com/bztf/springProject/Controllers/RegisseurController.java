package com.bztf.springProject.Controllers;

import com.bztf.springProject.Exception.RegisseurNotFoundException;
import com.bztf.springProject.Models.Regisseur;
import com.bztf.springProject.Repositories.RegisseurRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RegisseurController {
    private final RegisseurRepository repository;

    public RegisseurController(RegisseurRepository repository){
        this.repository = repository;
    }

    // get all directors
    @CrossOrigin
    @GetMapping("/directors")
    List<Regisseur> all(){
        return  repository.findAll();
    }

    // get single item
    @CrossOrigin
    @GetMapping("/directors/{id}")
    Regisseur one(@PathVariable Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RegisseurNotFoundException(id));
    }

    // put single item
    @CrossOrigin
    @PutMapping("/directors/{id}")
    Regisseur replaceRegisseur(@RequestBody Regisseur newRegisseur, @PathVariable Long id){
        return repository.findById(id)
                .map(regisseur -> {
                    regisseur.setFirstName(newRegisseur.getFirstName());
                    regisseur.setLastName(newRegisseur.getLastName());
                    return repository.save(regisseur);
                })
                .orElseGet(() ->
                {
                    return repository.save(newRegisseur);
                });
    }

    // delete single item
    @CrossOrigin
    @DeleteMapping("/directors/{id}")
    void deleteMovie(@PathVariable Long id){
        repository.deleteById(id);
    }
}
