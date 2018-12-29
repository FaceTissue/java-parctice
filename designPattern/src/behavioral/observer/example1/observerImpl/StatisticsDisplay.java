package behavioral.observer.example1.observerImpl;

import behavioral.observer.example1.Display;
import behavioral.observer.example1.Observer;
import behavioral.observer.example1.Subject;

public class StatisticsDisplay implements Observer, Display {
    private float avgTemperature;
    private float minTemperature;
    private float maxTemperature;
    private Subject weatherData;

    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        String template = "Avg/Min/Max temperature: %s/%s/%s";
        System.out.println(String.format(template, avgTemperature, minTemperature, maxTemperature));
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        minTemperature = temperature > minTemperature ? minTemperature : temperature;
        maxTemperature = temperature < maxTemperature ? maxTemperature : temperature;
        avgTemperature = (minTemperature + maxTemperature) / 2;
        display();
    }
}
