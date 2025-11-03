package br.com.gustavokenzo.movieFinder.application;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

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
            System.out.println(response.body());
        } catch (InterruptedException | IOException e) {
            System.out.println("Erro na busca! " + e.getMessage());
            e.printStackTrace();
        }
    }
}
