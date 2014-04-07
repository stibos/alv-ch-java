package ch.alv.components.service.persistence;

import ch.alv.components.core.model.ModelItem;
import ch.alv.components.persistence.search.ValuesProvider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

/**
 * Persistence Service interface for {@link ModelItem} entities
 *
 * @since 1.0.0
 */
public interface PersistenceService<TYPE extends ModelItem, IDTYPE extends Serializable> {

    Page<TYPE> findAll(Pageable pageable);

    Page<TYPE> find(ValuesProvider valuesProvider);

    Page<TYPE> find(String searchName, ValuesProvider valuesProvider);

    Page<TYPE> find(Pageable pageable, ValuesProvider valuesProvider);

    Page<TYPE> find(Pageable pageable, String searchName, ValuesProvider valuesProvider);

    TYPE getById(IDTYPE id);

    TYPE save(TYPE item);

    Iterable<TYPE> save(List<TYPE> items);

    void delete(IDTYPE id);

}
