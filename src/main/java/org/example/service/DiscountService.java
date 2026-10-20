package org.example.service;

import org.example.calc.DiscountCalculator;
import org.example.model.Order;
import org.example.model.PromoConfig;
import org.example.source.OrderSource;
import org.example.write.ResultWriter;

import java.util.List;
import java.util.Map;

public class DiscountService {
    private final OrderSource source;
    private final DiscountCalculator calc;
    private final ResultWriter writer;

    public DiscountService(OrderSource source, DiscountCalculator calc, ResultWriter writer) {
        this.source = source;
        this.calc = calc;
        this.writer = writer;
    }

    public void run(String input, String output, PromoConfig config) {
        List<Order> orders = source.load(input);
        Map<String, Double> totals = calc.calculate(orders, config);
        writer.write(totals, output);
    }
}
