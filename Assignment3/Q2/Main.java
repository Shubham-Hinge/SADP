
interface Command {
    void execute();
    void undo();
}

class CeilingFan {
    private String speed = "OFF";

    public void high() {
        speed = "HIGH";
        System.out.println("Ceiling Fan is at HIGH speed");
    }

    public void medium() {
        speed = "MEDIUM";
        System.out.println("Ceiling Fan is at MEDIUM speed");
    }

    public void low() {
        speed = "LOW";
        System.out.println("Ceiling Fan is at LOW speed");
    }

    public void off() {
        speed = "OFF";
        System.out.println("Ceiling Fan is OFF");
    }

    public String getSpeed() {
        return speed;
    }
}

class CeilingFanHighCommand implements Command {
    CeilingFan ceilingFan;
    String previousSpeed;

    CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    public void execute() {
        previousSpeed = ceilingFan.getSpeed();
        ceilingFan.high();
    }

    public void undo() {
        if (previousSpeed.equals("HIGH"))
            ceilingFan.high();
        else if (previousSpeed.equals("MEDIUM"))
            ceilingFan.medium();
        else if (previousSpeed.equals("LOW"))
            ceilingFan.low();
        else
            ceilingFan.off();
    }
}

class RemoteControl {
    Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

    public void pressUndo() {
        command.undo();
    }
}

public class Main {
    public static void main(String[] args) {

        CeilingFan fan = new CeilingFan();
        RemoteControl remote = new RemoteControl();

        Command highCommand = new CeilingFanHighCommand(fan);

        remote.setCommand(highCommand);

        System.out.println("Pressing ON/HIGH button:");
        remote.pressButton();

        System.out.println("\nPressing UNDO button:");
        remote.pressUndo();
    }
}