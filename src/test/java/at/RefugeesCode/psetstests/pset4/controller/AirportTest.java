package at.RefugeesCode.psetstests.pset4.controller;

import at.RefugeesCode.psetstests.pset4.controller.travelstage.*;
import at.RefugeesCode.psetstests.pset4.model.Luggage;
import at.RefugeesCode.psetstests.pset4.util.TimeUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class AirportTest {
    private Airport airport = new Airport();
    private Luggage luggage = new Luggage();
    private SecurityControl securityControl = new SecurityControl();



    @Test
    void testLuggageIsRejected() {
        // create one luggage that will arrive too late
        //Mohammad Alsakini;Berlin;Baggage;18:16;18:30;2
        //Owner;Destination;Type;Drop Off Time;Departure Time;Flight Duration

        luggage.setWaitingDuration(Duration.ofMinutes(0));
        luggage.setOwner("thaer");
        luggage.setDestination("Berlin");
        luggage.setDropOffTime(TimeUtils.todayAt("18:16"));
        luggage.setFlightDuration(TimeUtils.durationOfHours("2"));
        luggage.setDepartureTime(TimeUtils.todayAt("18:30"));
        luggage.setType("Baggage");
        List<Luggage> rejectedtravellist = new ArrayList<>();

        //rejectedtravellist.add(luggage);
        securityControl.isAllowedToTravel(luggage);
        rejectedtravellist = securityControl.getRejectedLuggage();

        //Assertions.assertEquals(luggage.getWaitingDuration().toMinutes(), "");
        Assertions.assertEquals(rejectedtravellist.size(), 1);
        Assertions.assertEquals(rejectedtravellist.get(0).getOwner(), "thaer");
    }

    @Test
    void testLuggageIsAccepted() {
        // create one luggage that will arrive too late
        //Mohammad Alsakini;Berlin;Baggage;18:16;18:30;2
        //Owner;Destination;Type;Drop Off Time;Departure Time;Flight Duration

        luggage.setWaitingDuration(Duration.ofSeconds(0));
        luggage.setOwner("thaer");
        luggage.setDestination("Berlin");
        luggage.setDropOffTime(TimeUtils.todayAt("16:00"));
        luggage.setFlightDuration(TimeUtils.durationOfHours("2"));
        luggage.setDepartureTime(TimeUtils.todayAt("18:30"));
        luggage.setType("Baggage");


        List<Luggage> travelList = new ArrayList<>();
        travelList.add(luggage);
        securityControl.isAllowedToTravel(luggage);
        Assertions.assertEquals(airport.travel(travelList).get(0), luggage);
        Assertions.assertEquals(luggage.getOwner(),"thaer");
        Assertions.assertEquals(luggage.getWaitingDuration().toMinutes(),305);
        Assertions.assertEquals(luggage.getDepartureTime().getHour(),18);




        // create one luggage that will be accepted


        // test that the duration and arrival times are correct


    }

}

/* private Luggage toTravelReport(String[] columns) {
        Luggage luggage = new Luggage();
        luggage.setOwner(columns[0]);
        luggage.setDestination(columns[1]);
        luggage.setType(columns[2]);
        luggage.setDropOffTime(TimeUtils.todayAt(columns[3]));
        luggage.setDepartureTime(TimeUtils.todayAt(columns[4]));
        luggage.setFlightDuration(TimeUtils.durationOfHours(columns[5]));
        luggage.setWaitingDuration(Duration.ofSeconds(0));
        return luggage;*/