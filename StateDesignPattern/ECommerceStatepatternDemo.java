// Placed, Shipped, Delivered, Cancelled
interface OrderState {
    void next(OrderContext context);
    void cancel(OrderContext context);
}

class OrderPlacedState implements OrderState {
    @Override 
    public void next(OrderContext context) {
        System.out.println("Order has been placed. Moving to Shipped state.");
        context.setState(new OrderShippedState());
    }
    @Override 
    public void cancel(OrderContext context) {
        System.out.println("Ordr has been cancelled.");
        context.setState(new OrderCancelledState());
    }
}

class OrderShippedState implements OrderState {
    @Override 
    public void next(OrderContext context) {
        System.out.println("Order has been shipped. Moving to Delivered state.");
        context.setState(new OrderDeliveredState());
    }
    @Override 
    public void cancel(OrderContext context) {
        System.out.println("Cannot cancel. Order has already been shipped.");
    }
}

class OrderDeliveredState implements OrderState {
    @Override 
    public void next(OrderContext context) {
        System.out.println("Order is already delivered.");
    }
    @Override 
    public void cancel(OrderContext context) {
        System.out.println("Cannot cancel. Order is already delivered.");
    }
}

class OrderCancelledState implements OrderState {
    @Override 
    public void next(OrderContext context) {
        System.out.println("Cannot proceed. Order is cancelled.");
    }
    @Override 
    public void cancel(OrderContext context) {
        System.out.println("Order is already cancelled.");
    }
}

class OrderContext {
    private OrderState currentState;
    public OrderContext() {
        currentState = new OrderPlacedState();
    }
    public void setState(OrderState state) {
        this.currentState = state;
    }
    public void proceedToNext() {
        currentState.next(this);
    }
    public void cancelOrder() {
        currentState.cancel(this);
    }
}

public class ECommerceStatepatternDemo {
    public static void main(String[] args) {
        OrderContext order = new OrderContext();

        System.out.println("Order Workflow:");
        order.proceedToNext();  // Move to Shipped
        order.proceedToNext();  // Move to Delivered
        order.cancelOrder();    // Try to cancel after delivery

        System.out.println("\nNew Order Workflow:");
        OrderContext newOrder = new OrderContext();
        newOrder.cancelOrder();  // Cancel immediately after placement
    }
}
