package at.RefugeesCode.psetstests.pset1.models;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.regex.Matcher;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest

class SummaryTest {
   private Summary summary;

    @Test
    void getMost5RatedFilms() {

        List<String> most5RatedFilms = summary.getMost5RatedFilms();
        Assert.assertThat(most5RatedFilms.size(),is(5));
        Assert.assertThat(most5RatedFilms.get(0),is("Reckless"));
        Assert.assertThat(most5RatedFilms.get(1),is("Girl in the Cadillac"));
        Assert.assertThat(most5RatedFilms.get(2),is("The Haunted World of Edward D. Wood, Jr."));
        Assert.assertThat(most5RatedFilms.get(3),is("Carmen Miranda: Bananas Is My Business"));
        Assert.assertThat(most5RatedFilms.get(4),is("Other Voices Other Rooms"));
    }

    @Test
    void getMostHiredActors() {
        List<String> mostHiredActors = summary.getMostHiredActors();
        Assert.assertThat(mostHiredActors.size(),is(5));
        Assert.assertThat(mostHiredActors.get(0),is("Bess Flowers"));
        Assert.assertThat(mostHiredActors.get(0),is("Christopher Lee"));
        Assert.assertThat(mostHiredActors.get(0),is("Grey Griffin"));
        Assert.assertThat(mostHiredActors.get(0),is("Danny Trejo"));
        Assert.assertThat(mostHiredActors.get(0),is("Eric Roberts"));


    }

    @Test
    void getRatioMaleFemale() {
        String ratioMaleFemale = summary.getRatioMaleFemale();
        Assert.assertThat(ratioMaleFemale,is("female (64.39481635178916) % male (35.60518364821084) %"));
    }

    @Test
    void getMostAppearingMovieGenres() {
        List<String> mostAppearingMovieGenres = summary.getMostAppearingMovieGenres();
        Assert.assertThat(mostAppearingMovieGenres.size(),is(2));
        Assert.assertThat(mostAppearingMovieGenres.get(0),is("Drama (14495)"));
        Assert.assertThat(mostAppearingMovieGenres.get(0),is("Comedy (8955)"));

    }
}