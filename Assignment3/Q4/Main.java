interface State {
    void insertQuarter();
    void ejectQuarter();
    void turnCrank();
    void dispense();
}

class GumballMachine {
    State state;
    int count;

    GumballMachine(int count) {
        this.count = count;
        state = new NoQuarterState(this);
    }

    void insertQuarter() { state.insertQuarter(); }
    void ejectQuarter() { state.ejectQuarter(); }
    void turnCrank() { state.turnCrank(); }
    void dispense() { state.dispense(); }
}

class NoQuarterState implements State {
    GumballMachine machine;

    NoQuarterState(GumballMachine m) {
        machine = m;
    }

    public void insertQuarter() {
        System.out.println("Quarter inserted");
        machine.state = new HasQuarterState(machine);
    }

    public void ejectQuarter() {
        System.out.println("No quarter inserted");
    }

    public void turnCrank() {
        System.out.println("Insert a quarter first");
    }

    public void dispense() {
        System.out.println("No gumball");
    }
}

class HasQuarterState implements State {
    GumballMachine machine;

    HasQuarterState(GumballMachine m) {
        machine = m;
    }

    public void insertQuarter() {
        System.out.println("Already have a quarter");
    }

    public void ejectQuarter() {
        System.out.println("Quarter returned");
        machine.state = new NoQuarterState(machine);
    }

    public void turnCrank() {
        System.out.println("Crank turned");
        machine.state = new SoldState(machine);
    }

    public void dispense() {
        System.out.println("Turn the crank first");
    }
}

class SoldState implements State {
    GumballMachine machine;

    SoldState(GumballMachine m) {
        machine = m;
    }

    public void insertQuarter() {
        System.out.println("Please wait");
    }

    public void ejectQuarter() {
        System.out.println("Cannot eject now");
    }

    public void turnCrank() {
        System.out.println("Already turned");
    }

    public void dispense() {
        if (machine.count > 0) {
            machine.count--;
            System.out.println("Gumball dispensed");
        }

        if (machine.count == 0)
            System.out.println("Machine is empty");
        else
            machine.state = new NoQuarterState(machine);
    }
}

public class Main {
    public static void main(String[] args) {
        GumballMachine machine = new GumballMachine(2);

        machine.insertQuarter();
        machine.turnCrank();
        machine.dispense();

        machine.insertQuarter();
        machine.ejectQuarter();
    }
}