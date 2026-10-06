public class FactoryMethodDemo {

    public static void main(String[] args) {

        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        System.out.println("Ordering from New York Store");
        Pizza pizza1 = nyStore.orderPizza("cheese");
        System.out.println("Ordered: " + pizza1.getName());

        System.out.println();

        System.out.println("Ordering from Chicago Store");
        Pizza pizza2 = chicagoStore.orderPizza("cheese");
        System.out.println("Ordered: " + pizza2.getName());
    }
}
