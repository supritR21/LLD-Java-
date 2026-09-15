import java.util.ArrayList;
import java.util.List;

interface ISubscriber {
    void update();
}

interface IChannel {
    void subscribe(ISubscriber subscriber);
    void unsubscribe(ISubscriber subscriber);
    void notifySubscribers();
}

class Channel implements IChannel {
    private List<ISubscriber> subscribers;
    private String name;
    private String latestVideo;

    public Channel(String name) {
        this.name = name;
        this.subscribers = new ArrayList<>();
    }

    @Override 
    public void subscribe(ISubscriber subscriber) {
        if(!subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
        }
    }

    @Override 
    public void unsubscribe(ISubscriber subscriber) {
        if(subscribers.contains(subscriber)) {
            subscribers.remove(subscriber);
        }
    }

    @Override 
    public void notifySubscribers() {
        for(ISubscriber sub : subscribers) {
            sub.update();
        }
    }

    public void uploadVideo(String title) {
        latestVideo=title;
        System.out.println("\n[" + name + " upload \"" + title + "\"]");
        notifySubscribers();
    }

    public String getVideoData() {
        return "\nCheckout our new Video : " + latestVideo + "\n";
    }
}

class Subscriber implements ISubscriber {
    private String name;
    private Channel channel;

    public Subscriber(String name, Channel channel) {
        this.name = name;
        this.channel = channel;
    }

    @Override 
    public void update() {
        System.out.println("Hey " + name + "," + channel.getVideoData());
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        Channel channel = new Channel("DevilsTriangle");
        Subscriber subs1 = new Subscriber("Devil", channel);
        Subscriber subs2 = new Subscriber("Demon", channel);

        channel.subscribe(subs1);
        channel.subscribe(subs2);

        channel.uploadVideo("Observer Pattern Tutorial");
        channel.unsubscribe(subs1);
        channel.uploadVideo("Observer-D Pattern Tutorial");
    }
}