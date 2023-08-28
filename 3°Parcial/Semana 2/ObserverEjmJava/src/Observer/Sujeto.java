
package Observer;

public interface Sujeto {
    void registerObserver(TemperatureObserver observer);
    void removeObserver(TemperatureObserver observer);
    void notifyTemperatureObservers(int temperature);
}
