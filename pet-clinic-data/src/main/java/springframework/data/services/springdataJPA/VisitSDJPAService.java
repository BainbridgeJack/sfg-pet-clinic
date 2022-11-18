package springframework.data.services.springdataJPA;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springframework.data.model.Visit;
import springframework.data.repositories.VisitRepository;
import springframework.data.services.VisitService;

import java.util.HashSet;
import java.util.Set;


/**
 * Add profile of 'springdatajpa' that we NEED to activated to then activate the bean in springContext to be used.
 */
@Service
@Profile("springdatajpa")
public class VisitSDJPAService implements VisitService {

    private final VisitRepository visitRepository;

    public VisitSDJPAService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();

        for (Visit visit : visitRepository.findAll()) {
            visits.add(visit);
        }

        return visits;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRepository.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit object) {
        return visitRepository.save(object);
    }

    @Override
    public void delete(Visit object) {
        visitRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        visitRepository.deleteById(aLong);
    }
}
