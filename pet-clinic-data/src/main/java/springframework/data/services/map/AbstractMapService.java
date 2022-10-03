package springframework.data.services.map;

import springframework.data.model.BaseEntity;

import java.util.*;

/**
 * MAP Service for our base Map that we will be saving to.
 * @param <T>
 * @param <ID>
 */
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(T object) {

        if (object != null) {
            if(object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        }
        else {
            throw new RuntimeException("Object being saved cannot be NULL!");
        }
        return object;
    }

    void delete(T object){
        //map.remove(object);
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    protected void deleteById(ID id) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(id));
    }

    private Long getNextId() {

        Long nextId = null;

        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch(NoSuchElementException e) {
            nextId = 1L;
        }

        return nextId;
    }
}
