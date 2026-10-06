class LoggerService {

    private static LoggerService instance;

    private LoggerService() {
        System.out.println("Logger Service Created");
    }

    public static LoggerService getInstance() {
        if (instance == null) {
            instance = new LoggerService();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

public class SingletonDemo {
    public static void main(String[] args) {

        LoggerService logger1 = LoggerService.getInstance();
        LoggerService logger2 = LoggerService.getInstance();

        logger1.log("Application Started");
        logger2.log("Application Running");

        if (logger1 == logger2) {
            System.out.println("Both are the same LoggerService instance");
        }
    }
}