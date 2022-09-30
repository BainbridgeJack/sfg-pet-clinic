package services;

import model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByID(Long id);

}