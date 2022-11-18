package springframework.data.services.springdataJPA;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import springframework.data.model.Owner;
import springframework.data.repositories.OwnerRepository;
import springframework.data.repositories.PetRepository;
import springframework.data.repositories.PetTypeRepository;
import springframework.data.services.OwnerService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Add profile of 'springdatajpa' that we NEED to activated to then activate the bean in springContext to be used.
 */
@Service
@Profile("springdatajpa")
public class OwnerSDJPAService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerSDJPAService(OwnerRepository ownerRepository, PetRepository petRepository,
                             PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }


    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();

        for (Owner owner : ownerRepository.findAll()) {
            owners.add(owner);
        }

        return owners;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }

    @Override
    public Owner findByID(Long id) {
        return null;
    }
}
