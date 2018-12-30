package com.hillel.elementary.javageeks.dir.pizza_service.repositories.customer;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Customer;

import java.util.HashMap;
import java.util.Map;

public class InMemCustomerRepository implements CustomerRepository {
    Map<Long, Customer> customers = new HashMap<>();
    Long counter = 0L;

    @Override
    public Customer findById(Long id) {
        return customers.get(id);
    }

    @Override
    public Customer save(Customer customer) {
        if (customer == null) {
            throw new NullPointerException();
        }
        if (customer.getId() == null) {
            Customer customerToSave = new Customer(++counter, customer.getName());
            customers.put(customerToSave.getId(), customerToSave);
            return customerToSave;
        } else if (customers.get(customer.getId()) == null) {
            throw new IllegalArgumentException();
        }
        return customer;
    }

    @Override
    public Customer findByName(String name) {
        for (Customer customer : customers.values()) {
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }
}
