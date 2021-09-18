package service;

import model.Developer;

import java.util.List;
import java.util.Optional;

public class DeveloperServiceImpl implements BaseService<Developer, Long>{
    @Override
    public Developer save(Developer developer) {
        return null;
    }

    @Override
    public List<Developer> getAll() {
        return null;
    }

    @Override
    public Optional<Developer> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long aLong) {

    }
}
