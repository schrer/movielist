package at.schrer.movielist.storage;

import at.schrer.inject.annotations.ByName;
import at.schrer.inject.annotations.Component;
import at.schrer.movielist.data.Movie;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Stores movie information in memory
 */
@Component
public class MovieRepository {
    private final Map<String, Movie> movies = new HashMap<>();

    public MovieRepository(@ByName("defaultMovies") List<Movie> defaultMovies) {
        defaultMovies.forEach(it -> movies.put(it.getImdbId(), it));
    }

    public void addMovie(Movie movie) {
        movies.put(movie.getImdbId(), movie);
    }

    public Movie getMovie(String imdbId) {
        return movies.get(imdbId);
    }

    public boolean removeMovie(String imdbId) {
        return movies.remove(imdbId) != null;
    }

    public List<Movie> getAllMovies() {
        return movies.values().stream().toList();
    }
}
