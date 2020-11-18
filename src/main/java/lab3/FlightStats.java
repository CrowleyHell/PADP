package lab3;

import java.io.Serializable;

public class FlightStats implements Serializable {
    int cancelledFlights, delayedFlights;
    float maxDelayedFlight;

    public FlightStats(){
        this.cancelledFlights = 0;
        this.delayedFlights = 0;
        this.maxDelayedFlight = 0;
    }

    public int add(String delay){
        if (delay.isEmpty()){
            cancelledFlights++;
        } else if (delay != "0"){
            delayedFlights++;
            if (Float.parseFloat(delay) > maxDelayedFlight){
                maxDelayedFlight = Float.parseFloat(delay);
            }
        }
    }


}
