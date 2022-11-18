package springframework.data.services.springdataJPA;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springframework.data.model.PetType;
import springframework.data.repositories.PetTypeRepository;
import springframework.data.services.PetTypeService;

import java.util.HashSet;
import java.util.Set;

/**
 * Add profile of 'springdatajpa' that we NEED to activated to then activate the bean in springContext to be used.
 */
@Service
@Profile("springdatajpa")
public class PetTypeSDJPAService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeSDJPAService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();

        for (PetType petType : petTypeRepository.findAll()) {
            petTypes.add(petType);
        }

        return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
