package org.example.source;

import org.example.model.Order;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TxtOrderSource implements OrderSource {


    @Override
    public List<Order> load(String path) {
        List<Order> orders = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                Order order = new Order(LocalDateTime.parse(parts[0]), parts[1], Double.parseDouble(parts[2]));
                orders.add(order);
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла " + path, e);
        }
        return orders;
    }
}
