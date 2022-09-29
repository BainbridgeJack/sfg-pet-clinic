package services;

import model.Owner;
import model.Vet;

import java.util.Set;

public interface VetService {

    Vet findByID(Long id);

    Vet findByLastName(String lastName);

    Vet save(Vet owner);

    Set<Vet> findAll(Vet owner);
}
