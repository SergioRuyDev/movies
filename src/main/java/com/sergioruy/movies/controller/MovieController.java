package com.sergioruy.movies.controller;

import com.sergioruy.movies.model.Movie;
import com.sergioruy.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/{code}")
    public ResponseEntity<Movie> listMovie(@PathVariable Long code) {

        if (code < 0) {
            return ResponseEntity.badRequest().build();
        }

        Movie movie = this.movieService.getMovie(code);

        if (movie == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(movie);
    }

}
