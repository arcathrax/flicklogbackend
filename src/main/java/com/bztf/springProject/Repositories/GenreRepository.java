package com.bztf.springProject.Repositories;

import com.bztf.springProject.Models.Genre;
import com.bztf.springProject.Models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}