package digital.ah.salud_cerca.application.usecases;

import digital.ah.salud_cerca.application.dto.RegisterPersonRequest;
import digital.ah.salud_cerca.domain.models.CatalogDetail;
import digital.ah.salud_cerca.domain.models.CatalogHeader;
import digital.ah.salud_cerca.domain.models.Person;
import digital.ah.salud_cerca.domain.repository.CatalogDetailRepository;
import digital.ah.salud_cerca.domain.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegisterPersonUseCase {

    private final PersonRepository personRepository;

    private final CatalogDetailRepository  catalogDetailRepository;

    @Transactional
    public Person execute(RegisterPersonRequest request) {
        if (this.personRepository.findByDocumentNumber(request.documentNumber()).isPresent()) {
            throw new IllegalArgumentException("Person with this document already exists");
        }

        CatalogDetail catalogDocType = this.catalogDetailRepository.findById(request.documentTypeId());
        CatalogDetail catalogGenderType = this.catalogDetailRepository.findById(request.genderId());

        Person person = new Person(
                request.firstName(),
                request.lastName(),
                catalogDocType,
                request.documentNumber(),
                request.phone(),
                request.email(),
                request.birthDate(),
                catalogGenderType
        );
        return this.personRepository.save(person);
    }

}
