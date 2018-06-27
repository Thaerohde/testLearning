package at.RefugeesCode.psetstests.pset1.models;

import java.util.List;

public class Film {

    private String name;
    private Float rating;
    private List<String> genre;

    public Film (String name, Float rating, List<String> genre) {
        this.name = name;
        this.rating = rating;
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public Float getRating() {
        return rating;
    }

    public List<String> getGenre ( ) {
        return genre;
    }

}
