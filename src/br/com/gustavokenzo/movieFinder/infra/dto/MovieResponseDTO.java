package br.com.gustavokenzo.movieFinder.infra.dto;

import br.com.gustavokenzo.movieFinder.domain.model.Movie;

import java.util.List;

public record MovieResponseDTO(int page, List<Movie> results) {
}
