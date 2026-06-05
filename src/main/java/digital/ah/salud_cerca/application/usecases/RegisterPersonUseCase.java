package digital.ah.salud_cerca.application.usecases;

import digital.ah.salud_cerca.application.dto.RegisterPersonRequest;
import digital.ah.salud_cerca.domain.models.CatalogDetail;
import digital.ah.salud_cerca.domain.models.CatalogHeader;
import digital.ah.salud_cerca.domain.models.Person;
import digital.ah.salud_cerca.domain.repository.PersonRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterPersonUseCase {

    private final PersonRepository personRepository;

    public RegisterPersonUseCase(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Transactional
    public Person execute(RegisterPersonRequest request) {
        if (this.personRepository.findByDocumentNumber(request.documentNumber()).isPresent()) {
            throw new IllegalArgumentException("Person with this document already exists");
        }

        CatalogHeader catalogDocumentPeron = new CatalogHeader(1L, "Document Person");
        CatalogHeader catalogGender = new CatalogHeader(1L, "Gender");

        CatalogDetail docType = new CatalogDetail(1L, catalogDocumentPeron, "DNI");
        CatalogDetail genderType = new CatalogDetail(2L, catalogGender, "Male");

        Person person = new Person(
                request.firstName(),
                request.lastName(),
                docType,
                request.documentNumber(),
                request.phone(),
                request.email(),
                request.birthDate(),
                genderType
        );
        return this.personRepository.save(person);
    }

}
