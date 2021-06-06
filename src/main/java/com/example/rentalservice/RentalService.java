package com.example.rentalservice;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RentalService {
    private final RestTemplate restTemplate;

    public RentalService(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    public Movie findMovieById(Long id){
        Movie movie = restTemplate.getForEntity("http://localhost:8080/movie/"+ id, Movie.class).getBody();
        return movie;
    }

    public void returnMovie(Long id) {
        String movieResourceUrl = String.format("http://localhost:8080/movie/available/" + id, Void.class);
        restTemplate.put(movieResourceUrl, null);
    }
}
