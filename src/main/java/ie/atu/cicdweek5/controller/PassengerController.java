package ie.atu.cicdweek5.controller;


import ie.atu.cicdweek5.model.Passenger;
import ie.atu.cicdweek5.service.PassengerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/passengers")
public class PassengerController {

    private final PassengerService service; //constructor DI

    public PassengerController(PassengerService service){ this.service = service; }

    @GetMapping
    public ResponseEntity<List<Passenger>> getAll(){ return ResponseEntity.ok(service.findAll()) }

    @GetMapping("/{id}")
    public ResponseEntity<Passenger> getOne(@PathVariable String id){
        Optional<Passenger> maybe = service.findById(id);
        if (maybe.isPresent()) {
            return ResponseEntity.ok(maybe.get());
        } else {
            return ResponseEntity.notFound().build();
        } }

    @PostMapping
    public ResponseEntity<Passenger> create(@RequestBody Passenger p){
        Passenger created = service.create(p);
        return ResponseEnitity
                .created(URI.create("api/passengers/" + created.getPassengerId()))
                .body(created)
    }

}
