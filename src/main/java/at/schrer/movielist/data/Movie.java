package at.schrer.movielist.data;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private String title;
    @Builder.Default
    private Boolean watched = false;
    private String imdbId;
}
