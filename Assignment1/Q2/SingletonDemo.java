
class Singleton {

    private static Singleton instance;

    private Singleton() {
        System.out.println("Singleton Object Created");
    }

    public static synchronized Singleton getInstance() {

        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }

    public void display() {
        System.out.println("Hello from Singleton");
    }
}

public class SingletonDemo {

    public static void main(String[] args) {

        Runnable task = () -> {
            Singleton obj = Singleton.getInstance();
            obj.display();
            System.out.println("Hash Code: " + obj.hashCode());
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
    }
}