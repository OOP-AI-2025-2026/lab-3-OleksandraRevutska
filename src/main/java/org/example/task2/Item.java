package org.example.task2;

import java.util.Arrays;

public class Item {

    private long id;
    private String name;
    private double price;

    public Item(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Геттери
    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    // Сеттер для назви, якщо потрібно
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + this.id +
                ", price=" + this.price +
                ", name='" + this.name + '\'' +
                '}';
    }
}


