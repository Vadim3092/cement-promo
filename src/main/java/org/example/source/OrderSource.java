package org.example.source;

import org.example.model.Order;

import java.util.List;

public interface OrderSource {

    List<Order> load(String path);
}
