package ie.atu.cicdweek5.service;

import ie.atu.cicdweek5.model.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PassengerServiceTest {

    private PassengerService service;

    @BeforeEach
    void setUp() { service = new PassengerService();}

    @Test
    void createThenFindById() {
        Passenger p = Passenger.builder()
                .passengerId("K1")
                .name("Keelan")
                .email("keelan@atu.ie")
                .build();

        service.create(p);

        Optional<Passenger> found = service.findById("K1");
        assertTrue(found.isPresent());
        assertEquals("Keelan", found.get().getName());
    }

    @Test
    void duplicateIdThrows() {
        service.create(Passenger.builder()
                .passengerId("K2")
                .name("Bob")
                .email("bob@atu.ie")
                .build());

        assertThrows(IllegalArgumentException.class, () ->
                service.create(Passenger.builder()
                        .passengerId("K2")
                        .name("Bobby")
                        .email("bob@ex.com")
                        .build()));


    }

}
