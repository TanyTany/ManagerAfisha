package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MovieManagerTest {
    MovieManager manager = new MovieManager(10);
    Movie first = new Movie(1, "http1", "FilmName1", "Drama");
    Movie second = new Movie(2, "http2", "FilmName2", "Musical");
    Movie third = new Movie(3, "http3", "FilmName3", "Comedy");
    Movie fourth = new Movie(4, "http4", "FilmName4", "Drama");
    Movie fifth = new Movie(5, "http5", "FilmName5", "Drama");
    Movie sixth = new Movie(6, "http6", "FilmName6", "Musical");
    Movie seventh = new Movie(7, "http7", "FilmName7", "Comedy");
    Movie eighth = new Movie(8, "http8", "FilmName8", "Drama");
    Movie ninth = new Movie(9, "http9", "FilmName9", "Comedy");
    Movie tenth = new Movie(10, "http10", "FilmName10", "Drama");


    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);

    }

    @Test
    public void shouldGetAllMovies() {

        Movie[] actual = manager.GetLastMovies();
        Movie[] expected = new Movie[] {tenth, ninth, eighth, seventh, sixth,
                fifth, fourth, third, second, first};
        assertArrayEquals(actual, expected);
    }

    @Test
    public void shouldGetFirstMovies() {
        MovieManager manager = new MovieManager(4);
        Movie first = new Movie(1, "http1", "FilmName1", "Drama");
        Movie second = new Movie(2, "http2", "FilmName2", "Musical");
        Movie third = new Movie(3, "http3", "FilmName3", "Comedy");

        manager.add(first);
        manager.add(second);
        manager.add(third);

        Movie[] actual = manager.GetLastMovies();
        Movie[] expected = new Movie[] {third, second, first};
        assertArrayEquals(actual, expected);


    }
}