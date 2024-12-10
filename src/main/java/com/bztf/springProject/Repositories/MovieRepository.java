package com.bztf.springProject.Repositories;

import com.bztf.springProject.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}