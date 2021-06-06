package com.example.rentalservice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rental")
public class RentalController {
    private final RentalService rentalservice;

    public RentalController(RentalService rentalservice){
        this.rentalservice = rentalservice;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id){
        return ResponseEntity.ok(rentalservice.findMovieById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> returnMovie(@PathVariable Long id) {
        rentalservice.returnMovie(id);
        return ResponseEntity.noContent().build();
    }
}
