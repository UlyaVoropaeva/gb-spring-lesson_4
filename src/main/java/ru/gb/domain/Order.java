package ru.gb.domain;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private int id;
    private LocalDate date;
    private List<Product> products;
    private float cost;

    public Order() {
    }

    public Order(int id, LocalDate date, List<Product> products, float cost) {
        this.id = id;
        this.date = date;
        this.products = products;
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public float getCost() {
        return cost;
    }

    public List<Product> getProducts() {
        return products;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", products=" + products +
                ", cost=" + cost +
                '}';
    }
}