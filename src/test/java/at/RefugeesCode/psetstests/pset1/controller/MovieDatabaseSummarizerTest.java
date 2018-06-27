package at.RefugeesCode.psetstests.pset1.controller;

import at.RefugeesCode.psetstests.pset1.models.Summary;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;


class MovieDatabaseSummarizerTest {

    private MovieDatabaseSummarizer summarizer = new MovieDatabaseSummarizer();
    private Summary summary = summarizer.summarize().get();

    @Test
    void getMost5RatedFilms() {
        List<String> most5RatedFilms = summary.getMost5RatedFilms();
        assertAll(
                () -> assertEquals(5, most5RatedFilms.size()),
                () -> assertEquals("Reckless (10.0)", most5RatedFilms.get(0)),
                () -> assertEquals("The Haunted World of Edward D. Wood, Jr. (10.0)", most5RatedFilms.get(2)),
                () -> assertEquals("Girl in the Cadillac (10.0)", most5RatedFilms.get(1)),
                () -> assertEquals("Carmen Miranda: Bananas Is My Business (10.0)", most5RatedFilms.get(3)),
                () -> assertEquals("Other Voices Other Rooms (10.0)", most5RatedFilms.get(4))


        );
//        Assert.assertThat(most5RatedFilms.size(), is(5));
//        Assert.assertThat(most5RatedFilms.get(0), is("Reckless"));
//        Assert.assertThat(most5RatedFilms.get(1), is("Girl in the Cadillac"));
//        Assert.assertThat(most5RatedFilms.get(2), is("The Haunted World of Edward D. Wood, Jr."));
//        Assert.assertThat(most5RatedFilms.get(3), is("Carmen Miranda: Bananas Is My Business"));
//        Assert.assertThat(most5RatedFilms.get(4), is("Other Voices Other Rooms"));
    }

    @Test
    void getMostHiredActors() {
        List<String> mostHiredActors = summary.getMostHiredActors();

        Assertions.assertAll(
                () -> assertEquals(5, mostHiredActors.size()),
                () -> assertEquals("Bess Flowers (82)", mostHiredActors.get(0)),
                    () -> assertEquals("Christopher Lee (69)", mostHiredActors.get(1)),
                () -> assertEquals("Grey Griffin (59)", mostHiredActors.get(2)),
                () -> assertEquals("Danny Trejo (54)", mostHiredActors.get(3)),
                () -> assertEquals("Eric Roberts (52)", mostHiredActors.get(4))

        );

    }

    @Test
    void getRatioMaleFemale() {

        String ratioMaleFemale = summary.getRatioMaleFemale();
        assertEquals("female (64.39481635178916) % male (35.60518364821084) %",ratioMaleFemale);
       // Assert.assertThat(ratioMaleFemale, is("female (64.39481635178916) % male (35.60518364821084) %"));
    }

    @Test
    void getMostAppearingMovieGenres() {

        List<String> mostAppearingMovieGenres = summary.getMostAppearingMovieGenres();
        Assertions.assertAll(
                () -> assertEquals(2, mostAppearingMovieGenres.size()),
                () -> assertEquals("Drama (14495)", mostAppearingMovieGenres.get(0)),
                () -> assertEquals("Comedy (8955)", mostAppearingMovieGenres.get(1))

        );


    }
}
