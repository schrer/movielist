package at.schrer.movielist.clients;

import at.schrer.inject.annotations.ByName;
import at.schrer.inject.annotations.Component;
import com.fasterxml.jackson.databind.json.JsonMapper;

@Component
public class OMDBClient {
    private static final String BASE_URL = "http://www.omdbapi.com/";
    private final String searchByIdURL;
    private final JsonMapper jsonMapper;

    public OMDBClient(@ByName("omdbApiKey") String apiKey, JsonMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
        this.searchByIdURL = BASE_URL + "?" + "apikey=" + apiKey + "&i=";
    }
}
