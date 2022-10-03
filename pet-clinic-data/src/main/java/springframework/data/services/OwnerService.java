package springframework.data.services;

import springframework.data.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByID(Long id);

}