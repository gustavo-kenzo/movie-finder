package br.com.gustavokenzo.movieFinder.domain.model;

import com.google.gson.annotations.SerializedName;

public class Movie {
    private boolean adult;
    private int id;

    @SerializedName("original_title")
    private String originalTitle;
    private String overview;

    @SerializedName("poster_path")
    private String posterPath;

    @SerializedName("release_date")
    private String releaseDate;
    private String title;

    public Movie(boolean adult, int id, String originalTitle, String overview, String posterPath, String releaseDate, String title) {
        this.adult = adult;
        this.id = id;
        this.originalTitle = originalTitle;
        this.overview = overview;
        this.posterPath = "https://image.tmdb.org/t/p/original" + posterPath;
        this.releaseDate = releaseDate;
        this.title = title;
    }

    public boolean isAdult() {
        return adult;
    }

    public int getId() {
        return id;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "MOVIE " +
                "| adult (" + adult +
                ") | id (" + id +
                ") | originalTitle (" + originalTitle +
                ") | posterPath (" + posterPath +
                ") | releaseDate (" + releaseDate +
                ") | title (" + title +
                ") | overview (" + overview +
                ")\n";
    }
}
