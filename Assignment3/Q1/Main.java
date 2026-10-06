import java.util.Observable;
import java.util.Observer;

class WeatherStation extends Observable {
    private float temperature;
    private float humidity;
    private float pressure;

    public void measurementsChanged() {
        setChanged();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;

        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}

class WeatherDisplay implements Observer {

    @Override
    public void update(Observable observable, Object arg) {
        WeatherStation station = (WeatherStation) observable;

        System.out.println("Weather Update:");
        System.out.println("Temperature: " + station.getTemperature() + " °C");
        System.out.println("Humidity: " + station.getHumidity() + " %");
        System.out.println("Pressure: " + station.getPressure() + " hPa");
        System.out.println("-------------------------");
    }
}

public class Main {
    public static void main(String[] args) {

        WeatherStation weatherStation = new WeatherStation();

        WeatherDisplay display = new WeatherDisplay();

        weatherStation.addObserver(display);

        weatherStation.setMeasurements(30.5f, 65.0f, 1012.5f);
        weatherStation.setMeasurements(32.0f, 60.0f, 1010.2f);
        weatherStation.setMeasurements(28.5f, 70.0f, 1015.8f);
    }
}