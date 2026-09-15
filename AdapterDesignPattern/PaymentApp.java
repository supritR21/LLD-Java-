// Common Interface
interface PaymentGateway {
    void processPayment(double amount);
}

// Payment Gateway Adapters
// PayPal Adapter
class PaypalAdapter implements  PaymentGateway {
    private PayPal paymentGateway;
    public PaypalAdapter(PayPal paymentGateway) {
        this.paymentGateway = paymentGateway;
    }
    @Override 
    public void processPayment(double amount) {
        // Convert our application's method to PayPal's method
        paymentGateway.makePayment(amount);
    }
}

// Stripe Adapter
class StripeAdapter implements PaymentGateway {
    private Stripe paymentGateway;

    public StripeAdapter(Stripe paymentGateway) {
        this.paymentGateway = paymentGateway;
    }
    @Override 
    public void processPayment(double amount) {
        // Convert our application's method to Stripe's method
        paymentGateway.charge(amount);
    }
}


// PayPal Implementation
class PayPal {
    public void makePayment(double amount) {
        // PayPal-specific payment processing logic
        System.out.println("Paid $" + amount + " via PayPal.");
    }
}
class  Stripe {
    public void charge(double amount) {
        // Stripe-specific payment processing logic
        System.out.println("Charged $" + amount + " using Stripe.");
    }
}
public class PaymentApp {
    public static void main(String[] args) {
        PaymentGateway paypalGateway = new PaypalAdapter(new PayPal());
        PaymentGateway stripeGateway = new StripeAdapter(new Stripe());

        double amount = 100.0;

        // Process payments using different payment gateways
        paypalGateway.processPayment(amount);
        stripeGateway.processPayment(amount);
    }
}
