package springframework.web.petclinic.bootstrap;

import springframework.data.model.Owner;
import springframework.data.model.Vet;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.data.services.OwnerService;
import springframework.data.services.VetService;

/**
 * Spring boot specific CommandLineRunner to load data into out application on start up.
 * When Spring is up and ready, commandLineRunner is then executed.
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Jack");
        owner1.setLastName("Bainbridge");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Testing");
        owner2.setLastName("Second");

        ownerService.save(owner2);

        System.out.println("Owners have been loaded...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Testing");
        vet2.setLastName("SecondVet");

        vetService.save(vet2);

        System.out.println("Vets have been loaded...");
    }
}
