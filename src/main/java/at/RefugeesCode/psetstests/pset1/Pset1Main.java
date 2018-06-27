package at.RefugeesCode.psetstests.pset1;

import at.RefugeesCode.psetstests.pset1.controller.MovieDatabaseSummarizer;
import at.RefugeesCode.psetstests.pset1.models.Summary;
import at.RefugeesCode.psetstests.pset1.view.SummaryDisplayer;

import java.util.Optional;

public class    Pset1Main {

    public static void main(String[] args) {
        MovieDatabaseSummarizer summarizer = new MovieDatabaseSummarizer();
        SummaryDisplayer displayer = new SummaryDisplayer();

        Optional<Summary> summary = summarizer.summarize();
        if(summary.isPresent()){
            displayer.display(summary.get());
        } else {
            displayer.display();
        }
    }
}
