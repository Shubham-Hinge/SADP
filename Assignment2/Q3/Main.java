interface Workshop {
    void work();
}

class Produce implements Workshop {
    public void work() {
        System.out.println("Produced");
    }
}

class Assemble implements Workshop {
    public void work() {
        System.out.println("Assembled");
    }
}

abstract class Vehicle {
    protected Workshop workshop1;
    protected Workshop workshop2;

    protected Vehicle(Workshop w1, Workshop w2) {
        this.workshop1 = w1;
        this.workshop2 = w2;
    }

    abstract void manufacture();
}

class Car extends Vehicle {

    public Car(Workshop w1, Workshop w2) {
        super(w1, w2);
    }

    public void manufacture() {
        System.out.println("Car:");
        workshop1.work();
        workshop2.work();
    }
}

class Bike extends Vehicle {

    public Bike(Workshop w1, Workshop w2) {
        super(w1, w2);
    }

    public void manufacture() {
        System.out.println("Bike:");
        workshop1.work();
        workshop2.work();
    }
}

public class Main {
    public static void main(String[] args) {

        Vehicle car = new Car(new Produce(), new Assemble());
        car.manufacture();

        System.out.println();

        Vehicle bike = new Bike(new Produce(), new Assemble());
        bike.manufacture();
    }
}
