package com.example.movieapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movieapp.entity.Movie;
import com.example.movieapp.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository repo;

    public Movie addMovie(Movie movie) {
        return repo.save(movie);
    }

    public List<Movie> getAllMovies() {
        return repo.findAll();
    }

    public List<Movie> getMoviesByGenre(String genre) {
        return repo.findByGenre(genre);
    }

    public void deleteMovie(Integer id) {
        repo.deleteById(id);
    }

    public Movie getMovieById(Integer id) {
        return repo.findById(id).orElseThrow();
    }

    public Movie updateMovie(Integer id, Movie newMovie) {
        Movie movie = getMovieById(id);
        movie.setMovieName(newMovie.getMovieName());
        movie.setGenre(newMovie.getGenre());
        movie.setRating(newMovie.getRating());
        return repo.save(movie);
    }
}