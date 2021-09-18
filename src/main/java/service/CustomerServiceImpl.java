package service;

import model.Customer;

import java.util.List;
import java.util.Optional;

public class CustomerServiceImpl implements BaseService<Customer,Long> {
    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public List<Customer> getAll() {
        return null;
    }

    @Override
    public Optional<Customer> getById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long aLong) {

    }
}
