package at.RefugeesCode.psetstests.pset4.controller.travelstage;


import at.RefugeesCode.psetstests.pset4.model.Luggage;

import java.time.Duration;
import java.time.LocalDateTime;

public class StorageArea implements TravelStage {

    @Override
    public Luggage process(Luggage luggage) {
        // TODO add as much duration to the processing time as the departure time minus 30 minutes
        // if 30 minutes is not possible, the luggage won't be stored at all, which means that
        // no waiting time will be added at all
        LocalDateTime beginingtime = luggage.getDropOffTime().plus(luggage.getWaitingDuration());
        LocalDateTime endtime = luggage.getDepartureTime().minusMinutes(30);
        Duration storgeWaitting = Duration.between(beginingtime, endtime);
        if(endtime.isAfter(beginingtime)){
            luggage.setWaitingDuration(luggage.getWaitingDuration().plus(storgeWaitting));
            return luggage;
        }

        return luggage;
    }
}
