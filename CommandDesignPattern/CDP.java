// Command Interface
interface Command {
    void execute();
}

class Lights {
    public Lights() {
        //
    }
    public void TurnOn() {
        System.out.println("Turning on the lights");
    }
    public void TurnOff() {
        System.out.println("Turning off the lights");
    }
}

class TurnOnLights implements Command {
    private Lights lights;
    public TurnOnLights(Lights lights) {
        this.lights = lights;
    }
    @Override 
    public void execute() {
        this.lights.TurnOn();
    }
}

class TurnOffLights implements Command {
    private Lights lights;
    public TurnOffLights(Lights lights) {
        this.lights=lights;
    }
    @Override 
    public void execute() {
        this.lights.TurnOff();
    }
}

class RemoteController {
    Command command;
    public RemoteController() {
        //
    }
    public void setCommand(Command command) {
        this.command=command;
    }
    public void pressButton() {
        this.command.execute();
    }
}

public class CDP {
    public static void main(String[] args) {
        Lights lights = new Lights(); // executor
        RemoteController remote = new RemoteController(); // controller
        Command c1 = new TurnOnLights(lights);
        Command c2 = new TurnOffLights(lights);
        remote.setCommand(c1);
        remote.pressButton(); // invoking command
        remote.setCommand(c2);
        remote.pressButton();
    }
}