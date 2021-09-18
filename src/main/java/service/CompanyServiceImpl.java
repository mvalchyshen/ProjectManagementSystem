package service;

import model.Company;

import java.util.List;
import java.util.Optional;

public class CompanyServiceImpl implements BaseService<Company, Long> {
    @Override
    public Company save(Company company) {
        return null;
    }

    @Override
    public List<Company> getAll() {
        return null;
    }

    @Override
    public Optional<Company> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long aLong) {

    }
}
