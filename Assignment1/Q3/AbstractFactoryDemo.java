interface MobileFunction {
    void perform();
}

class Camera implements MobileFunction {
    @Override
    public void perform() {
        System.out.println("Taking a Photo...");
    }
    
}

class VideoRecorder implements MobileFunction {
    @Override
    public void perform() {
        System.out.println("Recording a Video...");
    }
}

abstract class MobileFactory {
    abstract MobileFunction getFunction();
}

class CameraFactory extends MobileFactory {
    @Override
    public MobileFunction getFunction() {
        return new Camera();
    }
}

class VideoFactory extends MobileFactory {
    @Override
    public MobileFunction getFunction() {
        return new VideoRecorder();
    }
}

public class AbstractFactoryDemo {
    public static void main(String[] args) {

        MobileFactory cameraFactory = new CameraFactory();
        MobileFunction camera = cameraFactory.getFunction();
        camera.perform();

        MobileFactory videoFactory = new VideoFactory();
        MobileFunction video = videoFactory.getFunction();
        video.perform();
    }
}