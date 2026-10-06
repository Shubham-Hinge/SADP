abstract class PizzaStore {

    abstract Pizza createPizza(String type);

    Pizza orderPizza(String type) {

        Pizza pizza = createPizza(type);

        if (pizza != null) {
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        } else {
            System.out.println("Pizza type not available.");
        }

        return pizza;
    }
}
