package springframework.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import springframework.data.model.Specialty;

@Component
public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
