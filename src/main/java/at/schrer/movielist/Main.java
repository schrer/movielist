package at.schrer.movielist;

import at.schrer.inject.ContextBuilder;
import at.schrer.movielist.handlers.HomeHandler;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class Main {
    public static void main(String[] args) {
        var contextBuilder = ContextBuilder.getContextInstance("at.schrer.movielist");
        Javalin.create(/*config*/)
                .get("/", contextBuilder.getComponent(HomeHandler.class))
                .get("/movie", contextBuilder.getComponent("getMoviesHandler", Handler.class))
                .post("/movie", contextBuilder.getComponent("postMovieHandler", Handler.class))
                .delete("/movie", contextBuilder.getComponent("deleteMovieHandler", Handler.class))
                .start(7070);
    }
}