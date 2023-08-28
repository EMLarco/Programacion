
package observerejmjava;

import Observer.TemperatureObserver;

public class TemperatureDisplay implements TemperatureObserver {
    private String name;

    public TemperatureDisplay(String name) {
        this.name = name;
    }

    @Override
    public void updateTemperature(int temperature) {
        System.out.println(name + " Cambio de temperatura detectado: " + temperature + "°C");
    }
}
