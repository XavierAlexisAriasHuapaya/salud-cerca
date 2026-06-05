package digital.ah.salud_cerca.application.dto;

import java.time.LocalDate;

public record RegisterPersonRequest(
    String firstName,
    String lastName,
    Long documentTypeId,
    String documentNumber,
    String phone,
    String email,
    LocalDate birthDate,
    Long genderId
) { }
