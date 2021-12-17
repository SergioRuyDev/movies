package com.sergioruy.movies.controller;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest
public class MovieControllerTest {

    @Autowired
    private MovieController movieController;

    // This method is for show to Spring only my movie controller will be test. Just in case if I have many controllers
    // I have to show which controller I will test.
    @BeforeEach
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(this.movieController);
    }

    @Test
    public void shouldReturnSuccess_WhenGetMovie() {

    }
}
