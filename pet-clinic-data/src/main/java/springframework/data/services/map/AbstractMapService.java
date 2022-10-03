package springframework.data.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * MAP Service for our base Map that we will be saving to.
 * @param <T>
 * @param <ID>
 */
public abstract class AbstractMapService<T, ID> {

    protected Map<ID, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T save(ID id, T object) {
        map.put(id, object);

        return object;
    }

    void delete(T object){
        //map.remove(object);
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    protected void deleteById(ID id) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(id));
    }
}
