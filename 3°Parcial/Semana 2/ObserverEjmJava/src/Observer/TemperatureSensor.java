
package Observer;


import java.util.ArrayList;
import java.util.List;

public class TemperatureSensor implements Sujeto {
    private List<TemperatureObserver> observers = new ArrayList<>();
    private int temperature;

    @Override
    public void registerObserver(TemperatureObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(TemperatureObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyTemperatureObservers(int temperature) {
        for (TemperatureObserver observer : observers) {
            observer.updateTemperature(temperature);
        }
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyTemperatureObservers(temperature);
    }
}
