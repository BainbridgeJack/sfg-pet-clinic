package springframework.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import springframework.data.model.Pet;

@Component
public interface PetRepository extends CrudRepository<Pet, Long> {
}
