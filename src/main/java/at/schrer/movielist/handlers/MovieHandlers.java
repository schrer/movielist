package at.schrer.movielist.handlers;

import at.schrer.inject.annotations.BeanSource;
import at.schrer.inject.annotations.Component;
import at.schrer.movielist.MovieService;
import at.schrer.movielist.data.MovieId;
import io.javalin.http.Handler;

@BeanSource
public class MovieHandlers {
    private MovieHandlers(){}

    @Component(name = "getMoviesHandler")
    public static Handler getMoviesHandler(MovieService movieService){
        return ctx -> {
            var imdbId = ctx.queryParam("id");
            if (imdbId != null && !imdbId.isBlank()) {
                var movie = movieService.getMovie(imdbId);
                if (movie != null) {
                    ctx.json(movie);
                } else {
                    ctx.status(404);
                }
            } else {
                ctx.json(movieService.getAllMovies());
            }
        };
    }

    @Component(name = "postMovieHandler")
    public static Handler postMovieHandler(MovieService movieService){
        return ctx -> {
            var movie = ctx.bodyAsClass(MovieId.class);
            if (!movieService.addMovie(movie.imdbId())) {
                ctx.status(409);
            }
        };
    }

    @Component(name = "deleteMovieHandler")
    public static Handler deleteMoviesHandler(MovieService movieService){
        return ctx -> {
            var imdbId = ctx.queryParam("id");
            if (imdbId == null || imdbId.isBlank()) {
                ctx.status(400);
                return;
            }
            if (movieService.removeMovie(imdbId)) {
                ctx.status(204);
            } else {
                ctx.status(404);
            }
        };
    }
}
