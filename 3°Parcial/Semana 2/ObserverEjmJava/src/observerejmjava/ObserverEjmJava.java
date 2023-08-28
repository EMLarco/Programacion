
package observerejmjava;


import Observer.TemperatureSensor;


public class ObserverEjmJava {
    
    public static void main(String[] args) {
        
        TemperatureSensor sensor = new TemperatureSensor();

        TemperatureDisplay display1 = new TemperatureDisplay("Observacion 1");
        TemperatureDisplay display2 = new TemperatureDisplay("Observacion 2");

        sensor.registerObserver(display1);
        sensor.registerObserver(display2);

        sensor.setTemperature(25);
        sensor.setTemperature(30);

        sensor.removeObserver(display1);

        sensor.setTemperature(22);
    }
}
