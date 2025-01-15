package org.example.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoviesTest {
    Movies movie = new Movies(100, "Parasite", "Thriller", 141);

    @Test
    void getIdMovie() {
        assertEquals(100, movie.GetIdMovie());
    }

    @Test
    void getTitle() {
        assertEquals("Parasite", movie.GetTitle());
    }

    @Test
    void getGenre() {
        assertEquals("Thriller", movie.GetGenre());
    }

    @Test
    void getDuration() {
        assertEquals(141, movie.GetDuration());
    }

    @Test
    void setIdMovie() {
        movie.SetIdMovie(101);
    }

    @Test
    void setTitle() {
        movie.SetTitle("Gladiator");
    }

    @Test
    void setGenre() {
        movie.SetGenre("Historic");
    }

    @Test
    void setDuration() {
        movie.SetDuration(138);
    }
}