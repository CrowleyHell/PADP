package lab3;

import java.io.Serializable;
import java.util.Iterator;

public class FlightStats implements Serializable {
    int cancelledFlights, delayedFlights;
    float maxDelayedFlight;

    public FlightStats(Iterator<String> delays){
        this.cancelledFlights = 0;
        this.delayedFlights = 0;
        this.maxDelayedFlight = 0;
        whi
    }

    public void add(String delay){
        if (delay.isEmpty()){
            cancelledFlights++;
        } else if (!delay.equals("0.00")){
            delayedFlights++;
            if (Float.parseFloat(delay) > maxDelayedFlight){
                maxDelayedFlight = Float.parseFloat(delay);
            }
        }
    }
}
