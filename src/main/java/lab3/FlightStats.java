package lab3;

import java.io.Serializable;

public class FlightStats implements Serializable {
    int cancelledFlights, delayedFlights, maxDelayedFlight;

    public FlightStats(){
        this.cancelledFlights = 0;
        this.delayedFlights = 0;
        this.maxDelayedFlight = 0;
    }

    public int add(String delay){
        if (delay.isEmpty()){
            cancelledFlights++;
        } else {
            delayedFlights++;
            if (Integer.parseInt(delay) > maxDelayedFlight){
                maxDelayedFlight = delayedFlights;
            }
        }
    }


}
