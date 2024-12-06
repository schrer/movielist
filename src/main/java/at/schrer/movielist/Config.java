package at.schrer.movielist;

import at.schrer.inject.annotations.BeanSource;
import at.schrer.inject.annotations.Component;
import at.schrer.movielist.data.Movie;

import java.util.List;

@BeanSource
public class Config {
    private Config() {}

    @Component(name = "defaultMovies")
    public static List<Movie> defaultMovies() {
        var exampleMovie = Movie.builder()
                .imdbId("tt0133093")
                .title("The Matrix")
                .build();
        var anotherExampleMovie = Movie.builder()
                .imdbId("tt0172495")
                .title("Gladiator")
                .build();
        return List.of(exampleMovie, anotherExampleMovie);
    }
}
