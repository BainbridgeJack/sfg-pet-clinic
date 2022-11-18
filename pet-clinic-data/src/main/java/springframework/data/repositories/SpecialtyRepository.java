package springframework.data.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.data.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
