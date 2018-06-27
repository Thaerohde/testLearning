package at.RefugeesCode.psetstests.pset1.models;

import java.util.List;

public class Summary {

    private List<String>  most5RatedFilms;
    private List<String> mostHiredActors;
    private String ratioMaleFemale;
    private List<String> mostAppearingMovieGenres;


    public List<String> getMost5RatedFilms() {
        return most5RatedFilms;
    }

    public void setMost5RatedFilms(List<String> most5RatedFilms) {
        this.most5RatedFilms = most5RatedFilms;
    }

    public List<String> getMostHiredActors() {
        return mostHiredActors;
    }

    public void setMostHiredActors(List<String> mostHiredActors) {
        this.mostHiredActors = mostHiredActors;
    }

    public String getRatioMaleFemale() {
        return ratioMaleFemale;
    }

    public void setRatioMaleFemale(String ratioMaleFemale) {
        this.ratioMaleFemale = ratioMaleFemale;
    }

    public List<String> getMostAppearingMovieGenres() {
        return mostAppearingMovieGenres;
    }

    public void setMostAppearingMovieGenres(List<String> mostAppearingMovieGenres) {
        this.mostAppearingMovieGenres = mostAppearingMovieGenres;
    }
}
