package at.schrer.movielist;

import at.schrer.inject.annotations.BeanSource;
import at.schrer.inject.annotations.Component;
import at.schrer.movielist.data.Movie;
import com.fasterxml.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

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

    @Component(name = "omdbApiKey")
    public static String omdbApiKey() throws IOException {
        // Read api key from movielist.properties and return it
        Properties prop = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream("movielist.properties");
        prop.load(stream);
        return prop.getProperty("omdb.api.key");
    }

    @Component
    public static JsonMapper jsonMapper(){
        return JsonMapper.builder().build();
    }
}
