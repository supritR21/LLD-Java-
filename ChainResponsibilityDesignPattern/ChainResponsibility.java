abstract class RequestHandler {
    String name;
    RequestHandler nextHandler;
    private RequestHandler() {

    }
    public RequestHandler(String name) {
        this.name = name;
    }
    abstract void setNext(RequestHandler nextHandler);
    void approve(int id) {
        if(this.nextHandler != null) {
            this.nextHandler.approve(id);
        } else {
            System.out.println("Request cannot be approved");
        }
    }
}

class Manager extends RequestHandler {
    public Manager() {
        super("manager");
    }
    @Override 
    void setNext(RequestHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    @Override 
    void approve(int id) {
        if(id>=1 && id<=20) {
            System.out.println("Request Approved by Manager");
        } else {
            super.approve(id);
        }
    }
}

class SeniorManager extends RequestHandler {
    public SeniorManager() {
        super("Senior Manager");
    }
    @Override 
    void setNext(RequestHandler nextHandler) {
        this.nextHandler=nextHandler;
    }
    @Override 
    void approve(int id) {
        if(id>=21 && id<=40) {
            System.out.println("Request Approved by Senior Manager");
        } else {
            super.approve(id);
        }
    }
}

class Director extends RequestHandler {
    public Director() {
        super("Director");
    }
    @Override 
    void setNext(RequestHandler nextHandler) {
        this.nextHandler=nextHandler;
    }
    @Override 
    void approve(int id) {
        if(id>=41 && id<=80) {
            System.out.println("Request Approved by Director");
        } else {
            super.approve(id);
        }
    }
}

public class ChainResponsibility {
    public static void main(String[] args) {
        RequestHandler manager = new Manager();
        RequestHandler seniorManager = new SeniorManager();
        RequestHandler director = new Director();
        manager.setNext(seniorManager);
        seniorManager.setNext(director);
        manager.approve(5);
        manager.approve(35);
        manager.approve(55);
        manager.approve(90);
    }
}