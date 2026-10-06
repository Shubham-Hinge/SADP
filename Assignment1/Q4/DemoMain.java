interface Car {
    void showCar();
}

interface Specification {
    void showSpec();
}

class NorthAmericaCar implements Car {
    @Override
    public void showCar() {
        System.out.println("North America Car");
    }
}

class EuropeCar implements Car {
    @Override
    public void showCar() {
        System.out.println("Europe Car");
    }
}

class NorthAmericaSpec implements Specification {
    @Override
    public void showSpec() {
        System.out.println("Specification: EPA Standard");
    }
}

class EuropeSpec implements Specification {
    @Override
    public void showSpec() {
        System.out.println("Specification: Euro Standard");
    }
}

interface Factory {
    Car getCar();
    Specification getSpec();
}

class NorthAmericaFactory implements Factory {
    @Override
    public Car getCar() {
        return new NorthAmericaCar();
    }

    @Override
    public Specification getSpec() {
        return new NorthAmericaSpec();
    }
}

class EuropeFactory implements Factory {
    @Override
    public Car getCar() {
        return new EuropeCar();
    }

    @Override
    public Specification getSpec() {
        return new EuropeSpec();
    }
}

public class DemoMain {
    public static void main(String[] args) {

        Factory f1 = new NorthAmericaFactory();
        f1.getCar().showCar();
        f1.getSpec().showSpec();

        System.out.println();

        Factory f2 = new EuropeFactory();
        f2.getCar().showCar();
        f2.getSpec().showSpec();
    }
}