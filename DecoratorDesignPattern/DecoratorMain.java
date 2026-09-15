// Component interface
interface Pizza {
    String getDescription();
    double getCost();
}

// Concrete Component
class PlainPizza implements Pizza {
    @Override 
    public String getDescription() {
        return "Plain Pizza";
    }
    @Override 
    public double getCost() {
        return 5.0;
    }
}

// Decorator
abstract class PizzaDecorator implements  Pizza {
    protected Pizza decoratedPizza;
    public PizzaDecorator(Pizza pizza) {
        this.decoratedPizza=pizza;
    }
}

class CheeseDecorator extends PizzaDecorator {
    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }
    @Override 
    public String getDescription() {
        return decoratedPizza.getDescription() + ", Cheese";
    }
    @Override 
    public double getCost() {
        return decoratedPizza.getCost() + 1.5;
    }
}

class PepperoniDecorator extends PizzaDecorator {
    public PepperoniDecorator(Pizza pizza) {
        super(pizza);
    }
    @Override 
    public String getDescription() {
        return decoratedPizza.getDescription() + ", Pepperoni";
    }
    @Override 
    public double getCost() {
        return decoratedPizza.getCost() + 2.0;
    }
}

public class DecoratorMain {
    public static void main(String[] args) {
        Pizza pizza = new PlainPizza();
        pizza = new CheeseDecorator(pizza);
        pizza = new PepperoniDecorator(pizza);
        System.out.println("Description: " + pizza.getDescription());
        System.out.println("Cost: $" + pizza.getCost());
    }
}