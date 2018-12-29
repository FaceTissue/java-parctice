package behavioral.observer.example1;

import behavioral.observer.example1.observerImpl.CurrentConditionsDisplay;
import behavioral.observer.example1.observerImpl.StatisticsDisplay;

public class Client {
    public static void main(String[] args) {
        Subject subject = new WeatherData();

        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(subject);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(subject);

        ((WeatherData) subject).setMeasurements(20, 30, 0);
        ((WeatherData) subject).setMeasurements(40, 50, 0);
        currentConditionsDisplay.remove();
        ((WeatherData) subject).setMeasurements(60, 70, 0);
    }
}
