package com.example.rentalservice.nbp;

import com.example.rentalservice.RentalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/nbp")
public class NbpController {

    private final NbpService nbpService;

    public NbpController(NbpService nbpService){
        this.nbpService = nbpService;
    }

    //GET: localhost:8081/nbp/GBP?days=10
    @GetMapping("/{currency}")
    public ResponseEntity<String> getMovie(@PathVariable String currency, @RequestParam Integer days){
        return ResponseEntity.ok("nice");
    }

}
