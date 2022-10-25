package springframework.web.petclinic.bootstrap;

import springframework.data.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import springframework.data.services.OwnerService;
import springframework.data.services.PetTypeService;
import springframework.data.services.SpecialtyService;
import springframework.data.services.VetService;

import java.time.LocalDate;
import java.util.Set;

/**
 * Spring boot specific CommandLineRunner to load data into out application on start up.
 * When Spring is up and ready, commandLineRunner is then executed.
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    private void loadData() {

        /**
         * INITIALIZE OWNERS + PETS
         */
        Owner owner1 = new Owner();
        owner1.setFirstName("Jack");
        owner1.setLastName("Bainbridge");
        owner1.setAddress("123 Melanson Rd");
        owner1.setCity("Dieppe");
        owner1.setTelephone("506-123-4567");

        PetType dog = new PetType();
        dog.setName("Dog");
        petTypeService.save(dog);

        Pet jacksPet = new Pet();
        jacksPet.setOwner(owner1);
        jacksPet.setPetType(dog);
        jacksPet.setName("Jed");
        jacksPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(jacksPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Testing");
        owner2.setLastName("Second");
        owner2.setAddress("987 Random St");
        owner2.setCity("Miami");
        owner2.setTelephone("123-123-4567");

        PetType cat = new PetType();
        cat.setName("Cat");
        petTypeService.save(cat);

        Pet testingPet = new Pet();
        testingPet.setOwner(owner2);
        testingPet.setPetType(cat);
        testingPet.setName("TestCat");
        testingPet.setBirthDate(LocalDate.now());

        owner2.getPets().add(testingPet);
        ownerService.save(owner2);

        System.out.println("Owners have been loaded...");
        System.out.println("Pets have been loaded...");

        /**
         * INITIALIZE VETS + SPECIALTIES
         */

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");

        Specialty surgery = new Specialty();
        radiology.setDescription("Surgery");

        Specialty dentistry = new Specialty();
        radiology.setDescription("Dentistry");

        Specialty savedRadiology = specialtyService.save(radiology);
        Specialty savedSurgery = specialtyService.save(surgery);
        Specialty savedDentistry = specialtyService.save(dentistry);

        Vet vet1 = new Vet();
        vet1.setFirstName("Sam");
        vet1.setLastName("Axe");
        vet1.getSpecialties().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Testing");
        vet2.setLastName("SecondVet");

        vet2.getSpecialties().add(savedSurgery);
        vet2.getSpecialties().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("Vets have been loaded...");
    }

    @Override
    public void run(String... args) throws Exception {

        // If we dont have any petType, load default data.
        if (petTypeService.findAll().size() < 1) {
            loadData();
        }
    }

}
