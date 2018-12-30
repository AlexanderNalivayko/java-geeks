package com.hillel.elementary.javageeks.dir.pizza_service.services.order;

import com.hillel.elementary.javageeks.dir.pizza_service.domain.Customer;
import com.hillel.elementary.javageeks.dir.pizza_service.domain.Order;
import com.hillel.elementary.javageeks.dir.pizza_service.repositories.order.OrderRepository;
import com.hillel.elementary.javageeks.dir.pizza_service.services.chef.ChefService;
import com.hillel.elementary.javageeks.dir.pizza_service.services.pizza.PizzaService;

public class SimpleOrderService implements OrderService {
    private OrderRepository orderRepository;
    private PizzaService pizzaService;
    private ChefService chefService;

    public SimpleOrderService(OrderRepository orderRepository, PizzaService pizzaService, ChefService chefService) {
        this.orderRepository = orderRepository;
        this.pizzaService = pizzaService;
        this.chefService = chefService;
    }

    @Override
    public Order placeNewOrder(Customer customer, Long... idsOfPizzas) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer is null!");
        }
        ;
        if (idsOfPizzas.length == 0) {
            throw new IllegalArgumentException("The identifiers of pizzas is absent!");
        }

        return null;
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id);
    }
}
