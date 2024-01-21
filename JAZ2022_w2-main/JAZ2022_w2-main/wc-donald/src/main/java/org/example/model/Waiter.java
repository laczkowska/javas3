package org.example.model;

import org.example.model.abstractions.IAmWaitingForAnOrder;

public class Waiter implements IAmWaitingForAnOrder {
    @Override
    public boolean ShouldStartWork(Order meal) {
        return false;
    }
}
