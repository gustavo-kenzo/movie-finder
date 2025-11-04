package br.com.gustavokenzo.movieFinder.application;

import br.com.gustavokenzo.movieFinder.domain.model.Movie;
import br.com.gustavokenzo.movieFinder.domain.services.MovieService;
import br.com.gustavokenzo.movieFinder.infra.dto.MovieResponseDTO;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        String apiKey = "a53d6a8dbb471a5ae5fd39991fb0c3fe";
        String url = "https://api.themoviedb.org/3/movie/popular?api_key=" + apiKey;

        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest
                    .newBuilder(URI.create(url))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            MovieResponseDTO movieDto = MovieService.jsonToMovieDTO(response.body());
            List<Movie> movies = MovieService.dtoToMovie(movieDto);

            System.out.println("Quantidade de filmes: " + movies.size());
            movies.forEach(movie -> System.out.println(movie.getTitle() + " " + movie.getPosterPath()));

        } catch (InterruptedException | IOException e) {
            System.out.println("Erro na busca! " + e.getMessage());
            e.printStackTrace();
        }
    }
}
