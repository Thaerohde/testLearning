package at.RefugeesCode.psetstests.pset4.controller.travelstage;


import at.RefugeesCode.psetstests.pset4.model.Luggage;

public class TransportCart implements TravelStage {

    @Override
    public Luggage process(Luggage luggage) {
        // TODO add 25 minutes to the processing time
        luggage.setWaitingDuration(luggage.getWaitingDuration().plusMinutes(25));
        return luggage;
    }
}
