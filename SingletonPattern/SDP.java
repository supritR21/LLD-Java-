class Singleton {
    private static Singleton instance;

    // Private constructor
    private Singleton() {
        // Initialization code
    }
    // Static method to get the instance
    public static Singleton getInstance() {
        if(instance==null) {
            instance = new Singleton();
        }
        return instance;
    }
}

public class SDP {
    public static void main(String[] args) {
        // Get the Singleton instance
        Singleton singleton = Singleton.getInstance();

        // Use the Singleton
    }
}
