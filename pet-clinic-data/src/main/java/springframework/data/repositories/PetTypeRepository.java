package springframework.data.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.data.model.Pet;
import springframework.data.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
