package springframework.data.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.data.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
