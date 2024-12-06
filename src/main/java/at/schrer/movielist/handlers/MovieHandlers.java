package at.schrer.movielist.handlers;

import at.schrer.inject.annotations.BeanSource;
import at.schrer.inject.annotations.Component;
import at.schrer.movielist.data.Movie;
import at.schrer.movielist.storage.MovieRepository;
import io.javalin.http.Handler;

@BeanSource
public class MovieHandlers {
    private MovieHandlers(){}

    @Component(name = "getMoviesHandler")
    public static Handler getMoviesHandler(MovieRepository movieRepository){
        return ctx -> {
            var imdbId = ctx.queryParam("id");
            if (imdbId != null) {
                var movie = movieRepository.getMovie(imdbId);
                if (movie != null) {
                    ctx.json(movie);
                } else {
                    ctx.status(404);
                }
            } else {
                ctx.json(movieRepository.getAllMovies());
            }
        };
    }

    @Component(name = "postMovieHandler")
    public static Handler postMovieHandler(MovieRepository movieRepository){
        return ctx -> {
            var movie = ctx.bodyAsClass(Movie.class);
            if (movieRepository.getMovie(movie.getImdbId()) != null) {
                ctx.status(409);
                return;
            }
            movieRepository.addMovie(movie);
        };
    }

    @Component(name = "deleteMovieHandler")
    public static Handler deleteMoviesHandler(MovieRepository movieRepository){
        return ctx -> {
            var imdbId = ctx.queryParam("id");
            if (imdbId == null) {
                ctx.status(400);
                return;
            }
            if (movieRepository.removeMovie(imdbId)) {
                ctx.status(204);
            } else {
                ctx.status(404);
            }
        };
    }
}
