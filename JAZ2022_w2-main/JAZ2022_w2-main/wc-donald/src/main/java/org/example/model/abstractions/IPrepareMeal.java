package org.example.model.abstractions;

import org.example.model.Order;

@FunctionalInterface
public interface IPrepareMeal<TMeal extends  Meal> {

    TMeal prepare(Order order);

    //void giveOrderBack();
}
