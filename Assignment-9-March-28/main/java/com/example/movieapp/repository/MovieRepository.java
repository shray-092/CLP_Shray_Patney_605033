package com.example.movieapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.movieapp.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findByGenre(String genre);
}