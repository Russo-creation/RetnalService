package com.example.rentalservice.nbp;

import com.example.rentalservice.Movie;
import org.springframework.stereotype.Service;

@Service
public class NbpService {


    public Movie findMovieById(Long id){
        Movie movie = restTemplate.getForEntity("http://localhost:8080/movie/"+ id, Movie.class).getBody();
        return movie;
    }

}
