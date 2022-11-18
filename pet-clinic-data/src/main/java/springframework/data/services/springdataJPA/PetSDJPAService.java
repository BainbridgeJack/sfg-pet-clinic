package springframework.data.services.springdataJPA;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import springframework.data.model.Pet;
import springframework.data.repositories.PetRepository;
import springframework.data.services.PetService;

import java.util.HashSet;
import java.util.Set;

/**
 * Add profile of 'springdatajpa' that we NEED to activated to then activate the bean in springContext to be used.
 */
@Service
@Profile("springdatajpa")
public class PetSDJPAService implements PetService {

    private final PetRepository petRepository;

    public PetSDJPAService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Set<Pet> findAll() {
        Set<Pet> pets = new HashSet<>();

        for (Pet pet : petRepository.findAll()) {
            pets.add(pet);
        }

        return pets;
    }

    @Override
    public Pet findById(Long aLong) {
        return petRepository.findById(aLong).orElse(null);
    }

    @Override
    public Pet save(Pet object) {
        return petRepository.save(object);
    }

    @Override
    public void delete(Pet object) {
        petRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petRepository.deleteById(aLong);
    }
}
