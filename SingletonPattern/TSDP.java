class Singleton {
    private static volatile Singleton instance;

    // Private constructor
    private Singleton() {
        // initialization code
    }

    // static method to get the instance
    public static Singleton getInstance() {
        if(instance==null) {
            synchronized(Singleton.class) {
                if(instance==null) {
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }
}
public class TSDP {
    public static void main(String[] args) {
        // get the singleton instance
        Singleton singleton = Singleton.getInstance();
        // Use the singleton
    }
}
