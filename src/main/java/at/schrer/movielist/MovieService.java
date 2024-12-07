package at.schrer.movielist;

import at.schrer.inject.annotations.Component;
import at.schrer.movielist.clients.OMDBClient;
import at.schrer.movielist.data.Movie;
import at.schrer.movielist.storage.MovieRepository;

import java.util.List;

@Component
public class MovieService {
    private final OMDBClient omdbClient;
    private final MovieRepository movieRepository;

    public MovieService(OMDBClient omdbClient, MovieRepository movieRepository) {
        this.omdbClient = omdbClient;
        this.movieRepository = movieRepository;
    }

    public boolean addMovie(String imdbId) {
        if (movieRepository.getMovie(imdbId) != null) {
            return false;
        }
        // TODO fetch information from API
        var movie = Movie.builder().imdbId(imdbId).build();
        movieRepository.addMovie(movie);
        return true;
    }

    public Movie getMovie(String imdbId) {
        return movieRepository.getMovie(imdbId);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    public boolean removeMovie(String imdbId) {
        return movieRepository.removeMovie(imdbId);
    }
}
