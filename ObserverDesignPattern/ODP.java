import java.util.ArrayList;
import java.util.List;

interface StockObserver {
    void update(String stockSymbol, double stockPrice);
}

class Investor implements StockObserver {
    private String name;
    public Investor(String name) {
        this.name = name;
    }
    @Override 
    public void update(String stockSymbol, double stockPrice) {
        System.out.println(name + " received an update for " + stockSymbol + ": $" + stockPrice);
    }
}

interface StockMarket {
    void registerObserver(StockObserver observer);
    void removeObserver(StockObserver observer);
    void notifyObservers(String stockSymbol, double stockPrice);
    void setStockPrice(String stockSymbol, double stockPrice);
}

class StockMarketImplementation implements StockMarket {
    private List<StockObserver> observers = new ArrayList<>();
    @Override 
    public void registerObserver(StockObserver observer) {
        observers.add(observer);
    }
    @Override 
    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }
    @Override 
    public void notifyObservers(String stockSymbol, double stockPrice) {
        for(StockObserver observer : observers) {
            observer.update(stockSymbol, stockPrice);
        }
    }

    // Simulate stock price changes
    @Override 
    public void setStockPrice(String stockSymbol, double stockPrice) {
        notifyObservers(stockSymbol,stockPrice);
    }
}

public class ODP {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarketImplementation();
        StockObserver investor1 = new Investor("Alice");
        StockObserver investor2 = new Investor("Bob");
        stockMarket.registerObserver(investor1);
        stockMarket.registerObserver(investor2);

        stockMarket.setStockPrice("INFY",1250.0);
        stockMarket.setStockPrice("TCS", 2500.0);
        stockMarket.removeObserver(investor2);
        stockMarket.setStockPrice("WIPRO", 700.0);
    }
}
