package org.example.model;

public class Order {

    private boolean isChipsIncluded;
    private boolean isBurgerIncluded;
    private boolean isBeverageIncluded;

    public Order(boolean isChipsIncluded, boolean isBurgerIncluded, boolean isBeverageIncluded) {
        this.isChipsIncluded = isChipsIncluded;
        this.isBurgerIncluded = isBurgerIncluded;
        this.isBeverageIncluded = isBeverageIncluded;
    }

    public boolean isBurgerIncluded() {
        return isBurgerIncluded;
    }

    public boolean isBeverageIncluded() {
        return isBeverageIncluded;
    }

    public boolean isChipsIncluded() {
        return isChipsIncluded;
    }
}
