package at.RefugeesCode.psetstests.pset1.view;


import at.RefugeesCode.psetstests.pset1.models.Summary;

public class SummaryDisplayer {


    public void display(Summary summary) {
        System.out.println("Most 5 rated films:: ");
        summary.getMost5RatedFilms().forEach(film -> System.out.println(film));
        System.out.println("-----------");
        System.out.println("The 5 Most hired actors:: ");
        summary.getMostHiredActors().forEach(actor-> System.out.println(actor));
        System.out.println("-----------");
        System.out.println("TMost appearing movie genres: ");
        summary.getMostAppearingMovieGenres().forEach(e-> System.out.println(e));
        System.out.println("-----------");
        System.out.println("Actors male-female ratio = " );
        System.out.println(summary.getRatioMaleFemale());
    }


    public void display() {
        System.out.println("Bro");
    }
}
