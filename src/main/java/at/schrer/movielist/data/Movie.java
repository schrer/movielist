package at.schrer.movielist.data;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private String title;
    private String imdbId;
    private Integer year;
    private String language;
    private Float imdbRating;
    private String plot;
}
