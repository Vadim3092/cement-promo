package org.example.model;

public class PromoConfig {

    private final double pricePerKg;
    private final double startDiscount;
    private final double step;

    public PromoConfig(double pricePerKg, double startDiscount, double step) {
        if (pricePerKg <= 0) {
            throw new IllegalArgumentException("Цена за кг цемента не может быть отрицательной или равна нулю");
        }
        if (startDiscount < 0 || startDiscount > 1) {
            throw new IllegalArgumentException("Начальная скидка не может быть отрицательной или быть больше 100%");
        }
        if (step < 0 || step > 1) {
            throw new IllegalArgumentException("Шаг скидки не может быть отрицательным или больше, чем 100%");
        }
        this.pricePerKg = pricePerKg;
        this.startDiscount = startDiscount;
        this.step = step;
    }

    public double getPricePerKg() {
        return pricePerKg;
    }

    public double getStartDiscount() {
        return startDiscount;
    }

    public double getStep() {
        return step;
    }

    @Override
    public String toString() {
        return "PromoConfig{" +
                "pricePerKg= " + pricePerKg +
                ", startDiscount= " + startDiscount +
                ", step= " + step +
                '}';
    }
}
