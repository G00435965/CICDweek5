package ie.atu.cicdweek5.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.contraints.Email;


@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Passenger {
    @NotBlank @Size(max = 40)
    private String passengerId;

    @NotBlank @Size(max = 60)
    private String name;


    @NotBlank @Email
    private String email;
}
