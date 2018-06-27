package at.RefugeesCode.psetstests.pset4.controller;


import at.RefugeesCode.psetstests.pset4.model.Luggage;

import java.util.ArrayList;
import java.util.List;

public class SecurityControl {

    private List<Luggage> rejectedLuggage = new ArrayList<>();

    public boolean isAllowedToTravel(Luggage luggage) {
        // validate that the luggage arrived at least 30 minutes before departure time
        if (luggage.getDropOffTime().isBefore(luggage.getDepartureTime().minusMinutes(30))) {
            return true;
        }

        rejectedLuggage.add(luggage);
        return false;

    }


    public List<Luggage> getRejectedLuggage() {
        return rejectedLuggage;
    }
}
