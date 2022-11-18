package springframework.data.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import springframework.data.model.Visit;

@Component
public interface VisitRepository extends CrudRepository<Visit, Long> {
}
