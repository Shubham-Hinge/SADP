class ChicagoStyleCheesePizza extends Pizza {

    ChicagoStyleCheesePizza() {
        name = "Chicago Style Cheese Pizza";
    }

    @Override
    void cut() {
        System.out.println("Cutting into square slices");
    }
}
