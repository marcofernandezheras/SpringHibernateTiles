package model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Marco A. Fernández Heras on 15/03/16.
 */
public interface GenericDao<T> {
    /**
     * Get all T object from the data source
     * @return List of T, never null
     */
    List<T> all();

    /**
     * Search for T object with pk equals <code>id</code> in the data source
     * @param id pk of the searched object
     * @return Optional<T>
     */
    Optional<T> search(Serializable id);

    /**
     * Insert T into the data source
     * @param object to insert into data source, must be update if needed
     */
    void insert(T object);

    /**
     * Sync T and its representation on the data source
     * @param object to sync the data source
     */
    void update(T object);

    /**
     * Remove T from the data source
     * @param object to remove
     */
    void delete(T object);
}
