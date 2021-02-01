package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class MovieManager {
    private int countMov;



    public MovieManager(int countMov) {
        this.countMov = countMov;
    }

    private Movie[] movies = new Movie[0];

    public void add(Movie movie){
        int length = movies.length + 1;
        Movie[] tmp = new Movie[length];

        System.arraycopy(movies, 0, tmp, 0, movies.length);

        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;

    }

    public Movie[] getAll() {
        Movie[] result = new Movie[movies.length];

        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public Movie[] getLastMovies() {
        Movie[] movie = new Movie[movies.length];
        if (movies.length <= countMov) {
            for (int i = 0; i < movies.length; i++) {
                int index = movies.length - i - 1;
                movie[i] = movies[index];
            }
            return movie;
        } else {
            Movie[] movies1 = new Movie[countMov];
            for (int i = 0; i < countMov; i++) {
                int index = movies.length - i - 1;
                movies1[i] = movies[index];
            }

            return movies1;

        }
    }
}
