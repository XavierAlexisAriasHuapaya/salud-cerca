package digital.ah.salud_cerca.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonRequest {
    private String firstName;
    private String lastName;
    private Long documentTypeId;
    private String documentNumber;
    private String phone;
    private String email;
    private LocalDate birthDate;
    private Long genderId;
}
