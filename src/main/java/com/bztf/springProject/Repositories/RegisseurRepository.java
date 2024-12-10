package com.bztf.springProject.Repositories;

import com.bztf.springProject.Models.Movie;
import com.bztf.springProject.Models.Regisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisseurRepository extends JpaRepository<Regisseur, Long> {
}
