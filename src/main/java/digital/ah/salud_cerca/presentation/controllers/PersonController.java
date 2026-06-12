package digital.ah.salud_cerca.presentation.controllers;

import digital.ah.salud_cerca.application.dto.RegisterPersonRequest;
import digital.ah.salud_cerca.application.usecases.RegisterPersonUseCase;
import digital.ah.salud_cerca.domain.models.Person;
import digital.ah.salud_cerca.presentation.dto.PersonRequest;
import digital.ah.salud_cerca.presentation.dto.PersonResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {

    private final RegisterPersonUseCase registerPersonUseCase;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody PersonRequest registerPersonRequest) {
        Person registeredPerson = this.registerPersonUseCase.execute(registerPersonRequest);
        PersonResponse response = new PersonResponse(
                registeredPerson.getFirstName(),
                registeredPerson.getLastName(),
                registeredPerson.getDocumentNumber(),
                registeredPerson.getPhone(),
                registeredPerson.getEmail(),
                registeredPerson.getBirthDate(),
                registeredPerson.getStatus().name()
        );
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
