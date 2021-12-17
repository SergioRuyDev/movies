package com.sergioruy.movies.service;

import com.sergioruy.movies.model.Movie;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    public Movie getMovie(Long code) {

        if (code > 100) {
            return null;
        }

        return new Movie(
                code,
                "The Godfather",
                "The Godfather is a 1972 American crime film directed by Francis Ford Coppola."
        );
    }
}
