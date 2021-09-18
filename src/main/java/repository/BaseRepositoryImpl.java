package repository;

import model.BaseEntity;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class BaseRepositoryImpl<T extends BaseEntity<ID>, ID> implements Closeable, BaseRepository<T, ID> {

    public BaseRepositoryImpl(Class<T> className) {}

    @Override
    public T save(T t) {
        return null;
    }

    @Override
    public List<T> getAll() {
        return null;
    }

    @Override
    public Optional<T> getById(ID id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(ID id) {

    }

    @Override
    public void close() throws IOException {

    }
}
