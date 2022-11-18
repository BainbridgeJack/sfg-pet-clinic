package springframework.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import springframework.data.model.Pet;
import springframework.data.model.PetType;

@Component
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
