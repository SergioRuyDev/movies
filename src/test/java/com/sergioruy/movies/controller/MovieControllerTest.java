package com.sergioruy.movies.controller;

import com.sergioruy.movies.model.Movie;
import com.sergioruy.movies.service.MovieService;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.*;
import static org.mockito.Mockito.*;

@WebMvcTest
public class MovieControllerTest {

    @Autowired
    private MovieController movieController;

    @MockBean
    private MovieService movieService;

    // This method is for show to Spring only my movie controller will be test. Just in case if I have many controllers
    // I have to show which controller I will test.
    @BeforeEach
    public void setup() {
        standaloneSetup(this.movieController);
    }

    @Test
    public void shouldReturnSuccess_WhenGetMovie() {

        when(this.movieService.getMovie(1L))
                .thenReturn(new Movie(1L, "The Godfather", "No description"));

        given()
                .accept(ContentType.JSON)
        .when()
                .get("/movies/{code}", 1L)
        .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void shouldReturnNotFound_WhenGetMovie() {

        when(this.movieService.getMovie(5L))
                .thenReturn(null);
        given()
                .accept(ContentType.JSON)
        .when()
                .get("/movies/{code}", 5L)
        .then()
                .statusCode(HttpStatus.SC_NOT_FOUND);

    }

    @Test
    public void shouldReturnBadRequest_WhenGetMovie() {

        given()
                .accept(ContentType.JSON)
        .when()
                .get("/movies/{code}", -1L)
        .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);

        verify(this.movieService, never()).getMovie(-1L);
    }
}
