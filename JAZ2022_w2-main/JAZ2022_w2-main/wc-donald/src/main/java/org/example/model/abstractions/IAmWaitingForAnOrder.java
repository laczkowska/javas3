package org.example.model.abstractions;

import org.example.model.Order;

public interface IAmWaitingForAnOrder {

    boolean ShouldStartWork(Order order);
}
