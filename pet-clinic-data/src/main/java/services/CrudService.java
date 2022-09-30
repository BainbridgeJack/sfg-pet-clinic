package services;

import java.util.Set;

public interface CrudService<T, ID> {

    Set<T> findAll();
    T findById(ID id);
    <T> void save(T object);
    void delete(T object);
    void deleteById(ID id);
}
