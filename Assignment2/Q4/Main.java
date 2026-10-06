
interface BeatModelInterface {
    void start();
    void stop();
    int getBPM();
}

class HeartModel {
    public int getHeartRate() {
        return 72; // Heart rate in BPM
    }
}

class HeartAdapter implements BeatModelInterface {

    private HeartModel heart;

    public HeartAdapter(HeartModel heart) {
        this.heart = heart;
    }

    @Override
    public void start() {
        System.out.println("Heart is already beating.");
    }

    @Override
    public void stop() {
        System.out.println("Heart cannot be stopped!");
    }

    @Override
    public int getBPM() {
        return heart.getHeartRate();
    }
}

public class Main {
    public static void main(String[] args) {

        HeartModel heart = new HeartModel();

        // Adapt HeartModel to BeatModelInterface
        BeatModelInterface beatModel = new HeartAdapter(heart);

        beatModel.start();
        System.out.println("Current BPM: " + beatModel.getBPM());
        beatModel.stop();
    }
}