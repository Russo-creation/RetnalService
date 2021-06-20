package com.example.rentalservice;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rental")
public class RentalController {
    private final RentalService rentalservice;

    public RentalController(RentalService rentalservice){
        this.rentalservice = rentalservice;
    }

    @ApiOperation(value = "Get movie for given Id",
        response = Movie.class,
        notes = "this method will return movie id or HTTP 404 if not found")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Movie not found"),
            @ApiResponse(code = 500, message = "Unexpected Error"),
    })
    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovie(
            @ApiParam(name ="id",
            type="long",
            value= "100",
            example = "1",
            required = true)
            @PathVariable Long id){
        return ResponseEntity.ok(rentalservice.findMovieById(id));
    }


    @ApiOperation(value = "Put method which change availability true for given Movie Id",
            response = Movie.class,
            notes = "this method will will return 200 movie availability or HTTP 404 if not found")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Movie not found"),
            @ApiResponse(code = 500, message = "Unexpected Error"),
    })
    @PutMapping("/movie_available_true/{id}")
    public ResponseEntity setIsAvailableTrue(@ApiParam(name ="id",
            type="long",
            value= "100",
            example = "1",
            required = true) @PathVariable Long id) {
        rentalservice.returnMovie(id);
        return ResponseEntity.noContent().build();
    }

    @ApiOperation(value = "Put method which change availability false for given Movie Id",
            response = Movie.class,
            notes = "this method will 200 or HTTP 404 if not found")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Movie not found"),
            @ApiResponse(code = 500, message = "Unexpected Error"),
    })
    @PutMapping("/movie_available_false/{id}")
    public ResponseEntity setIsAvailableFalse(@PathVariable Long id) {
        rentalservice.rentMovie(id);
        return ResponseEntity.noContent().build();
    }

}
