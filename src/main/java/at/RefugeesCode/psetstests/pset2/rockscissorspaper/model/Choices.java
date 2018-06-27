package at.RefugeesCode.psetstests.pset2.rockscissorspaper.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Choices {
    private List<Choice> choises;
    public  Choices(){
        choises = Stream.of(
                new Rock(),
                new Paper(),
                new Scissors()
        ).collect(Collectors.toList());
    }
    public List<Choice> getChoises() {

        return new ArrayList<>(choises);
    }
}


