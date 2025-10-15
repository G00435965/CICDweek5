package ie.atu.cicdweek5.service;
import org.springframework.stereotype.Service;

import ie.atu.cicdweek5.model.Passenger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PassengerService {
    private final List<Passenger> store = new ArrayList<>();

    public List<Passenger> findAll() {
        return new ArrayList<>(store); //defensive copy
    }

    public Optional<Passenger> findById(String id) {
        for (Passenger p : store) {
            if (p.getPassengerId().equals(id)) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    public Passenger create(Passenger p){
        if (findById(p.getPassengerId()).isPresent()) {
            throw new IllegalStateException("PassengerId already exists");
        }
        store.add(p);
        return p;
    }
}
