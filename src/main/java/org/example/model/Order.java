package org.example.model;

import java.time.LocalDateTime;

public class Order {

    private final LocalDateTime time;
    private final String company;
    private final double weight;

    public Order(LocalDateTime time, String company, double weight) {
        if (time == null) {
            throw new IllegalArgumentException("time не может быть - null");
        }
        if (company == null) {
            throw new IllegalArgumentException("company не может быть пустым");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("Вес не может быть меньше или равен нулю");
        }

        this.time = time;
        this.company = company;
        this.weight = weight;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getCompany() {
        return company;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Order{" +
                "time=" + time +
                ", company='" + company + '\'' +
                ", weight=" + weight +
                '}';
    }
}

