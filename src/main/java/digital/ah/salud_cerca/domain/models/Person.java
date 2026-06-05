package digital.ah.salud_cerca.domain.models;

import digital.ah.salud_cerca.domain.shared.EntityStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
public class Person {

    @Setter
    private String firstName;

    @Setter
    private String lastName;

    private final CatalogDetail documentType;

    private final String documentNumber;

    @Setter
    private String phone;

    @Setter
    private String email;

    @Setter
    private LocalDate birthDate;

    @Setter
    private CatalogDetail gender;

    private EntityStatus status;

    public Person(String firstName, String lastName, CatalogDetail documentType, String documentNumber, String phone, String email, LocalDate birthDate, CatalogDetail gender) {
        if (documentNumber == null || documentNumber.isBlank()) {
            throw new IllegalArgumentException("Document number is required");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.birthDate =  birthDate;
        this.status = EntityStatus.ACTIVE;
    }

    public void deactivate() {
        this.status = EntityStatus.INACTIVE;
    }

    public void delete() {
        this.status = EntityStatus.DELETED;
    }
}
