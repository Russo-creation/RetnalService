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
        String movieResourceUrl = ("http://localhost:8080/movie/available_true/" + id);
        restTemplate.put(movieResourceUrl, null);
    }

    public void rentMovie(Long id) {
        String movieResourceUrl = ("http://localhost:8080/movie/available_false/" + id);
        restTemplate.put(movieResourceUrl, null);
    }
}
