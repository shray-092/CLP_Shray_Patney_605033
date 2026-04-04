package com.example.movieapp.service;

import java.util.List;

import com.example.movieapp.entity.Movie;

public interface MovieService {
    Movie addMovie(Movie movie);
    List<Movie> getAllMovies();
    List<Movie> getMoviesByGenre(String genre);
    void deleteMovie(Integer id);
    Movie getMovieById(Integer id);
    Movie updateMovie(Integer id, Movie movie);
}