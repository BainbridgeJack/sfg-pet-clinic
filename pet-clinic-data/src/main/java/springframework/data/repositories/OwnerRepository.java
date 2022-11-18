package springframework.data.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.data.model.Owner;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
