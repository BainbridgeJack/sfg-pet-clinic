package springframework.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import springframework.data.model.Vet;

@Component
public interface VetRepository extends CrudRepository<Vet, Long> {
}
