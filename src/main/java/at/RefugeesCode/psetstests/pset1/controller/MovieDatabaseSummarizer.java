package at.RefugeesCode.psetstests.pset1.controller;

import at.RefugeesCode.psetstests.pset1.models.Actor;
import at.RefugeesCode.psetstests.pset1.models.Film;
import at.RefugeesCode.psetstests.pset1.models.Summary;
import at.RefugeesCode.psetstests.pset1.parser.ActorParser;
import at.RefugeesCode.psetstests.pset1.parser.ParserFilm;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MovieDatabaseSummarizer {


    public Optional <Summary>summarize() {
        ParserFilm films = new ParserFilm();
        List<Film> moviesInfo = films.parseFilms();
        List<String> most5RatedFilms =  moviesInfo.stream()
                .sorted(Comparator.comparing(Film::getRating).reversed())
                .limit(5)
                .map(name->name.getName()+" ("+name.getRating()+ ")")
                .collect(Collectors.toList());
        ActorParser actorParser = new ActorParser();

        List<Actor> ActorInfo = actorParser.parseActors();

        List<String> collect = ActorInfo.stream()
                .collect(Collectors.groupingBy(name -> name.getName(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((e1,e2)->e2.getValue().compareTo(e1.getValue()))
                .map(e->e.getKey() +" ("+e.getValue()+")")
                .limit(5)
                .collect(Collectors.toList());

        List<String> genrse =  moviesInfo.stream().map(info->info.getGenre())
                .flatMap(e->e.stream())
                .collect(Collectors.groupingBy(e->e,Collectors.counting()))
                        .entrySet().stream()
                .sorted((e1,e2)->e2.getValue().compareTo(e1.getValue()))
                .limit(2)
                .map(e->e.getKey()+ " ("+e.getValue()+")")
                .collect(Collectors.toList());

        String ratio = ActorInfo.stream().map(actor->actor.getGender())

                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet().stream()
                .map(e->e.getKey()+" ("+(e.getValue()*100.00)/ActorInfo.size()+")"+ " %")
                .collect(Collectors.joining(" "));


        Summary summary = new Summary();
        summary.setMost5RatedFilms(most5RatedFilms);
        summary.setRatioMaleFemale(ratio);
        summary.setMostHiredActors(collect);
        summary.setMostAppearingMovieGenres(genrse);
        return Optional.of(summary);
    }



}
