package springframework.data.repositories;

import org.springframework.data.repository.CrudRepository;
import springframework.data.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
