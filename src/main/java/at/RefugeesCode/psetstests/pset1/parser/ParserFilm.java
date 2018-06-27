package at.RefugeesCode.psetstests.pset1.parser;

import at.RefugeesCode.psetstests.pset1.models.Film;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParserFilm {
    public List<Film> parseFilms() {


        String filePath = "src/main/java/at/RefugeesCode/psetstests/pset1/data/movies.csv";
        try {
            Stream<String> lines = Files.lines(Paths.get(filePath));
            return
                    lines.skip(1)
                            .map(line -> line.split(";"))
                            .filter(columns -> columns.length == 24)
                            .map(ParserFilm::createNewFilm)

                            .collect(Collectors.toList());


        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }


    }

    private static Film createNewFilm(String[] strings) {
        return new Film(strings[20], Float.parseFloat(strings[22]), getListOfGenres(strings[3]));
    }

    private static List<String> getListOfGenres(String jsonstr) {
        return Stream.of(jsonstr.replaceAll("'", "")
                .replaceAll("]", "")
                .replaceAll("\\[", "")
                .replaceAll("}", "")
                // id :28, name Action ,id: 80 ,name  Crime ,id: 18 ,name: Drama, id: 53 name: Thriller
                .replaceAll("\\{", "")
                .replace("'", "")
                .split(",")).filter(s -> s.startsWith(" name"))
                .map(word -> word.split(":"))
                .map(word -> word[1].trim())
                .collect(Collectors.toList());
    }


}
