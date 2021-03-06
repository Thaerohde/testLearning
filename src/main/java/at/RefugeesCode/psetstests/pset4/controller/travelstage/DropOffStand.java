package at.RefugeesCode.psetstests.pset4.controller.travelstage;


import at.RefugeesCode.psetstests.pset4.model.Luggage;

import java.time.Duration;

public class DropOffStand implements TravelStage {

    @Override
    public Luggage process(Luggage luggage) {
        // TODO add 10 minutes to the processing time
        Duration newLuggageDuration = luggage.getWaitingDuration().plusMinutes(10);
        luggage.setWaitingDuration(newLuggageDuration);
        return luggage;
    }

}
