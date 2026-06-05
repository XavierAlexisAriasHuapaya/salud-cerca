package digital.ah.salud_cerca.infrastructure.database.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;

@Entity
@Table(name = "tb_persons")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Long documentTypeId;

    @Column(nullable = false, unique = true)
    private String documentNumber;

    @Column(nullable = false)
    private String phone;

    private String email;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private Long genderId;

    @Column(nullable = false, updatable = false)
    private Long createdBy;

    private Long updatedBy;

    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    private Instant updatedAt;

    @Column(nullable = false)
    private String status;

}
