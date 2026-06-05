package digital.ah.salud_cerca.presentation.dto;

import java.time.LocalDate;

public record PersonResponse(
        String firstName,
        String lastName,
        String documentNumber,
        String phone,
        String email,
        LocalDate birthDate,
        String status
) {}
