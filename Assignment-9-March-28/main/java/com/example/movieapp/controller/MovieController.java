package com.example.movieapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import com.example.movieapp.entity.Movie;
import com.example.movieapp.service.MovieService;

@Controller
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    // ✅ Show Add Movie Form
    @GetMapping("/add")
    public ModelAndView showAddForm() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("add-movie");
        mv.addObject("movie", new Movie());
        return mv;
    }

    // ✅ Save Movie
    @PostMapping("/save")
    public ModelAndView saveMovie(@ModelAttribute Movie movie) {
        service.addMovie(movie);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/movies/all");
        return mv;
    }

    // ✅ View All Movies
    @GetMapping("/all")
    public ModelAndView getAllMovies() {
        List<Movie> movies = service.getAllMovies();

        ModelAndView mv = new ModelAndView();
        mv.setViewName("view-movies");
        mv.addObject("movies", movies);

        return mv;
    }

    // ✅ Show Search Page
    @GetMapping("/search")
    public ModelAndView searchPage() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("search");
        return mv;
    }

    // ✅ Search by Genre
    @GetMapping("/genre")
    public ModelAndView getByGenre(@RequestParam String genre) {
        List<Movie> movies = service.getMoviesByGenre(genre);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("view-movies");
        mv.addObject("movies", movies);

        return mv;
    }

    // ✅ Delete Movie
    @GetMapping("/delete/{id}")
    public ModelAndView deleteMovie(@PathVariable Integer id) {
        service.deleteMovie(id);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/movies/all");
        return mv;
    }

    // ✅ Show Update Form
    @GetMapping("/edit/{id}")
    public ModelAndView editMovie(@PathVariable Integer id) {
        Movie movie = service.getMovieById(id);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("update-movie");
        mv.addObject("movie", movie);

        return mv;
    }

    // ✅ Update Movie
    @PostMapping("/update/{id}")
    public ModelAndView updateMovie(@PathVariable Integer id,
                                   @ModelAttribute Movie movie) {

        service.updateMovie(id, movie);

        ModelAndView mv = new ModelAndView();
        mv.setViewName("redirect:/movies/all");
        return mv;
    }
}