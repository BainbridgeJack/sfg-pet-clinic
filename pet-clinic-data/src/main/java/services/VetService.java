package services;

import model.Vet;

public interface VetService extends CrudService<Vet, Long> {

    Vet findByLastName(String lastName);

}
