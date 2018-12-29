package behavioral.observer.example1.observerImpl;

import behavioral.observer.example1.Display;
import behavioral.observer.example1.Observer;
import behavioral.observer.example1.Subject;

public class CurrentConditionsDisplay implements Observer, Display {
    private float temperature;
    private float humidity;
    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("CurrentConditions: \ntemperature: " + temperature + " humidity: " + humidity);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    public void remove() {
        weatherData.removeObserver(this);
    }
}
