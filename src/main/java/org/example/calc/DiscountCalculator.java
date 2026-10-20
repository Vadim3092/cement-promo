package org.example.calc;

import org.example.model.Order;
import org.example.model.PromoConfig;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DiscountCalculator {
    public Map<String, Double> calculate(List<Order> orders, PromoConfig config) {
        Map<String, Double> totals = new LinkedHashMap<>();
        orders.sort(Comparator.comparing(Order::getTime));
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            double discount = config.getStartDiscount() - i * config.getStep();
            if (discount < 0) discount = 0;
            double cost = order.getWeight() * config.getPricePerKg() * (1 - discount);

            String company = order.getCompany();
            if (totals.containsKey(company)) {
                totals.put(company, totals.get(company) + cost);
            } else {
                totals.put(company, cost);
            }
        }
        return totals;
    }
}
