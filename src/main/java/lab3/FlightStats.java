package lab3;

import java.io.Serializable;
import java.util.Iterator;

public class FlightStats implements Serializable {
    private int originID, arrivalID;
    private float maxDelayedFlight, perDelay, perCancelled;
    private String originPortName, arrivalPortName;

    public static FlightStats CountStats(Iterator<String> delays){
        int cancelledFlights = 0;
        int delayedFlights = 0;
        int generalCountFlights = 0;
        float maxDelayedFlight = 0;
        while (delays.hasNext()){
            String delay = delays.next();
            generalCountFlights++;
            if (delay.isEmpty()){
                cancelledFlights++;
            } else if (!delay.equals("0.00")){
                delayedFlights++;
                if (Float.parseFloat(delay) > maxDelayedFlight){
                    maxDelayedFlight = Float.parseFloat(delay);
                }
            }
        }
        float perDelay = delayedFlights*100/generalCountFlights;
        float perCancelled = cancelledFlights*100/generalCountFlights;
        return new FlightStats(maxDelayedFlight, perDelay, perCancelled);
    }

    public FlightStats(float maxDelayedFlight, float perDelay, float perCancelled) {
        this.maxDelayedFlight = maxDelayedFlight;
        this.perDelay = perDelay;
        this.perCancelled = perCancelled;
    }

    public String formFinalStats(){

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
