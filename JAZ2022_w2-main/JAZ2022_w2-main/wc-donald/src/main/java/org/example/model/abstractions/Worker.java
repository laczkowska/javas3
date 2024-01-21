package org.example.model.abstractions;

import org.example.model.Order;
import org.example.model.abstractions.IAmWaitingForAnOrder;
import org.example.model.abstractions.IPrepareMeal;
import org.example.model.abstractions.Meal;

public abstract class Worker<TMeal extends Meal> implements IAmWaitingForAnOrder, IPrepareMeal<TMeal> {


    protected TMeal meal;

    public TMeal getMeal() {
        return meal;
    }

    public void setMeal(TMeal meal) {
        this.meal = meal;
    }

    @Override
    public abstract TMeal prepare(Order order);

    @Override
    public abstract boolean ShouldStartWork(Order order);
}
