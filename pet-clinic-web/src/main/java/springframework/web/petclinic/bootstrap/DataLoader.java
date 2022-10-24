package springframework.web.petclinic.bootstrap;

import springframework.data.model.Owner;
import springframework.data.model.PetType;
import springframework.data.model.Vet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.data.services.OwnerService;
import springframework.data.services.PetTypeService;
import springframework.data.services.VetService;

/**
 * Spring boot specific CommandLineRunner to load data into out application on start up.
 * When Spring is up and ready, commandLineRunner is then executed.
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Jack");
        owner1.setLastName("Bainbridge");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Testing");
        owner2.setLastName("Second");

        ownerService.save(owner2);

        System.out.println("Owners have been loaded...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Testing");
        vet2.setLastName("SecondVet");

        vetService.save(vet2);

        System.out.println("Vets have been loaded...");
    }
}
