package ru.gb.repository;


import org.springframework.stereotype.Repository;
import ru.gb.domain.Order;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepository {
    private List<Order> orders = new ArrayList<>();

    public OrderRepository() {
        orders.add(new Order(1, LocalDate.now(), Collections.emptyList(), 100.50F));
    }

    public Optional<Order> findOrdersById(int id) {

        return orders.stream().filter(o -> o.getId() == id).findFirst();
    }

    public List<Order> findAll() {
        return orders;
    }

    public void save(Order order) {
        this.orders.add(order);
    }

    public void delete(int id) throws Exception {
       Order order = findOrdersById(id).orElseThrow(()-> new Exception());
        this.orders.remove(findOrdersById(id));
    }


    @Override
    public String toString() {
        return "OrderRepository{" +
                "orders=" + orders +
                '}';
    }
}
