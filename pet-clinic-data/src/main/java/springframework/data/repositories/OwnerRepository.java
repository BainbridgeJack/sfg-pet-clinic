package springframework.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import springframework.data.model.Owner;

@Component
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);

}
