package repository;

import model.BaseEntity;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface BaseRepository<E extends BaseEntity<ID>, ID> {

    E save(E e);
    List<E> getAll();
    Optional<E> getById(ID id);
    void deleteById(ID id);
}
