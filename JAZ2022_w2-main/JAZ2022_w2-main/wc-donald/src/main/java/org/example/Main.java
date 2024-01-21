package org.example;



public class Main {
    public static void main(String[] args) {

        /**
         * Utwórz implementacje interfejsów
         */

//        IAmWaitingForAnOrder waiter = new Waiter();
        //IAmWaitingForAnOrder waiter2 = new IAmWaitingForAnOrder();

        /**
         * Utwórz implementacje interfejsów korzystając z klas anonimowych
         */

//        IAmWaitingForAnOrder anon = new IAmWaitingForAnOrder() {
//            @Override
//            public boolean ShouldStartWork(Order meal) {
//
//                return true;
//            }
//        };


        /**
         * Utwórz implementacje klasy Worker
         */

//        Worker<Chips> chipsWorker = new ChipsWorker();
        /**
         * Utwórz implementacje klasy worker jako klase anonimową
         */
//
//        Worker<Beverage> beverageWorker = new Worker<Beverage>() {
//            @Override
//            public Beverage prepare(Order order) {
//                return new Beverage();
//            }
//
//            @Override
//            public boolean ShouldStartWork(Order order) {
//                return false;
//            }
//        };



        /**
         * Utwórz implementacje interfejsów przy pomocy lambd
         */
//
//        IPrepareMeal<Burger> burgerPreparator =
//                (order)-> {
//            System.out.println("robie burgera");
//            return new Burger();
//        };

//        Burger b = burgerPreparator.prepare(new Order(true, true, true));

        /**
         * Sprawdź co się stanie jak interfejs ma wiecej niz jedną metodę
         */

        /**
         * wykorzystaj lambdy przy tworzeniu klasy GeneralWorker
         */

//        Worker<Burger> generalBurgerWorker = new GeneralWorker<>(waiter, burgerPreparator);
//
//        Worker<Beverage> beverageGeneralWorker = new GeneralWorker<>(
//                //Order::isBeverageIncluded,
//                order ->
//                order.isBeverageIncluded(),
//                order-> new Beverage());
//
//        Worker<Beverage> beverageGeneralWorker2 = new GeneralWorker<>(order ->
//                order.isBeverageIncluded(),
//                order->
//                new Beverage()
//        );
//        Order beverageOrder = new Order(false,false, true);
//
//        if(beverageGeneralWorker.ShouldStartWork(beverageOrder))
//            beverageGeneralWorker.prepare(beverageOrder);


    }

}