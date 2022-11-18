package springframework.data.services.springdataJPA;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springframework.data.model.Specialty;
import springframework.data.repositories.SpecialtyRepository;
import springframework.data.services.SpecialtyService;

import java.util.HashSet;
import java.util.Set;

/**
 * Add profile of 'springdatajpa' that we NEED to activated to then activate the bean in springContext to be used.
 */
@Service
@Profile("springdatajpa")
public class SpecialtySDJPAService implements SpecialtyService {

    private final SpecialtyRepository specialtyRepository;

    public SpecialtySDJPAService(SpecialtyRepository specialtyRepository) {
        this.specialtyRepository = specialtyRepository;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();

        for (Specialty specialty : specialtyRepository.findAll()) {
            specialties.add(specialty);
        }

        return specialties;
    }

    @Override
    public Specialty findById(Long aLong) {
        return specialtyRepository.findById(aLong).orElse(null);
    }

    @Override
    public Specialty save(Specialty object) {
        return specialtyRepository.save(object);
    }

    @Override
    public void delete(Specialty object) {
        specialtyRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyRepository.deleteById(aLong);
    }
}
