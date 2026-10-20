package org.example;


import org.example.calc.DiscountCalculator;
import org.example.model.PromoConfig;
import org.example.service.DiscountService;
import org.example.source.HashOrderSource;
import org.example.write.ResultWriter;


public class Main {
    public static void main(String[] args) {
        PromoConfig config = new PromoConfig(10, 0.5, 0.05);
        DiscountCalculator calculator = new DiscountCalculator();
        ResultWriter writer = new ResultWriter();

        DiscountService service = new DiscountService(new HashOrderSource(), calculator, writer);
        service.run("discount_day_without_ext", "result.txt", config);
    }
}