package com.hillel.elementary.javageeks.dir.pizza_service.services;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Pizza;

import java.util.Collection;

public interface PizzaService {
    Collection<Pizza> findAllPizzas();
}
