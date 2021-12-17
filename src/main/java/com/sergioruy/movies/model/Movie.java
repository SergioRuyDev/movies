package com.sergioruy.movies.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Movie {

    private Long code;
    private String title;
    private String description;

}
