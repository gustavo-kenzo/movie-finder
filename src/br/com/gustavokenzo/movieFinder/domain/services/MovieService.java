package br.com.gustavokenzo.movieFinder.domain.services;

import br.com.gustavokenzo.movieFinder.domain.model.Movie;
import br.com.gustavokenzo.movieFinder.infra.dto.MovieResponseDTO;
import com.google.gson.Gson;

import java.util.List;

public class MovieService {
    private static Gson gson = new Gson();

    public static MovieResponseDTO jsonToMovieDTO(String json) {
        MovieResponseDTO movieDto = gson.fromJson(json, MovieResponseDTO.class);
        return movieDto;
    }

    public static List<Movie> dtoToMovie(MovieResponseDTO movieDto) {
        List<Movie> movies = movieDto.results().stream()
                .map(movie -> new Movie(movie.isAdult(),
                        movie.getId(),
                        movie.getOriginalTitle(),
                        movie.getOverview(),
                        movie.getPosterPath(),
                        movie.getReleaseDate(),
                        movie.getTitle()
                )).toList();

        return movies;
    }

}
