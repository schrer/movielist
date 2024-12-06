package at.schrer.movielist.handlers;

import at.schrer.inject.annotations.Component;
import io.javalin.http.Context;
import io.javalin.http.Handler;
import org.jetbrains.annotations.NotNull;

@Component
public class HomeHandler implements Handler {
    @Override
    public void handle(@NotNull Context context) {
        context.result("Hello. This is the movielist.");
    }
}
