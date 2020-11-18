package lab3;

import java.io.Serializable;
import java.util.Iterator;

public class FlightStats implements Serializable {
    private int cancelledFlights, delayedFlights;
    private float maxDelayedFlight;

    public FlightStats(Iterator<String> delays){
        this.cancelledFlights = 0;
        this.delayedFlights = 0;
        this.maxDelayedFlight = 0;
        while (delays.hasNext()){
            String delay = delays.next();
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

    @Override
    public String toString() {
        return "FlightStats{" +
                "cancelledFlights=" + cancelledFlights +
                ", delayedFlights=" + delayedFlights +
                ", maxDelayedFlight=" + maxDelayedFlight +
                '}';
    }
}
