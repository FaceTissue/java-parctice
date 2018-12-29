package behavioral.observer.example1;

import java.util.ArrayList;

public class WeatherData implements Subject{
    private float temperature;
    private float humidity;
    private float pressure;
    private ArrayList observers;

    public WeatherData() {
        observers = new ArrayList();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        if (index >= 0) observers.remove(index);
    }

    @Override
    public void nofifyObservers() {
        for (Object object : observers) {
            Observer observer = (Observer) object;
            observer.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged() {
        nofifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
