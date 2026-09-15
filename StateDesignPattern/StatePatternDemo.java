// State Interface
interface TrafficLightState {
    void handleRequest(TrafficLightContext context);
}

// Concrete States

class RedLightState implements TrafficLightState {
    @Override 
    public void handleRequest(TrafficLightContext context) {
        System.out.println("Red Light: Cars must stop.");
        context.setState(new GreenLightState());
    }
}

class GreenLightState implements TrafficLightState {
    @Override 
    public void handleRequest(TrafficLightContext context) {
        System.out.println("Green Light: Cars can go.");
        context.setState(new YellowLightState());
    }
}

class YellowLightState implements TrafficLightState {
    @Override 
    public void handleRequest(TrafficLightContext context) {
        System.out.println("Yellow Light: Cars should prepare to stop.");
        context.setState(new RedLightState()); 
    }
}

class TrafficLightContext {
    private TrafficLightState currentState;
    public TrafficLightContext() {
        currentState=new RedLightState(); // Default initial state
    }
    public void setState(TrafficLightState state) {
        this.currentState=state;
    }
    public void changeLight() {
        currentState.handleRequest(this);
    }
}

public class StatePatternDemo {
    public static void main(String[] args) {
        TrafficLightContext trafficLight = new TrafficLightContext();
        for(int i=0; i<6; i++) {
            trafficLight.changeLight();
            System.out.println();
        }
    }
}