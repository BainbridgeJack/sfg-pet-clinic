package springframework.data.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.data.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
