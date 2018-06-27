package at.RefugeesCode.psetstests.pset4.controller.travelstage;


import at.RefugeesCode.psetstests.pset4.model.Luggage;

import java.time.Duration;

public class Flight implements TravelStage {

    @Override
    public Luggage process(Luggage luggage) {
        // TODO add travel duration to the processing time
        // Update arrival time
//        LocalDateTime departureTime = luggage.getDepartureTime();
//        Duration flightDuration = luggage.getFlightDuration();
        Duration duration = luggage.getWaitingDuration().plus(luggage.getFlightDuration());
        luggage.setWaitingDuration(duration);
        luggage.setArrivalTime(luggage.getDepartureTime().plus(luggage.getFlightDuration()));
        return luggage;


    }
}
