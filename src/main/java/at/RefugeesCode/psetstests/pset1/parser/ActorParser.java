package at.RefugeesCode.psetstests.pset1.parser;

import at.RefugeesCode.psetstests.pset1.models.Actor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ActorParser {

        public List<Actor> parseActors() {
            String filePath = "src/main/java/at/RefugeesCode/psetstests/pset1/data/actors.csv";

            try {
                List<Actor> collect = Files.lines(Paths.get(filePath))
                        .skip(1)
                        .map(s -> s.replaceAll("'name'", ""))
                        .map(s -> s.replaceAll("'gender'", ""))
                        .map(line->line.replaceAll(":",""))
                        .map(line->line.replaceAll("'",""))
                        .map(line -> line.split(";"))
                        .map(columns -> columns[0])
                        .map(jsonLine -> jsonLine.split("},"))
                        .flatMap(strings -> Arrays.stream(strings))
                        .map(s -> s.split(","))

                        .filter(strings -> strings.length >= 5)
                        .map(s -> getActorFunction(s))
                        .collect(Collectors.toList());
                //collect.forEach(e -> System.out.println(e.getName() + " " + e.getGender()));


                //System.out.println(collect.size());
                return collect;

            } catch (IOException e) {
                e.printStackTrace();
                return new ArrayList<>();
            }
        }

        private Actor getActorFunction(String[] strings) {
            Actor actor = new Actor();
            actor.setName(strings[5].trim());
            actor.setGender(getValue(strings[3]).trim());
            return actor;

        }

        private String getValue(String string) {
            if (string.contains("0") || string.contains("1")) {
                return "female";
            }
            if (string.contains("2")) {
                return "male";
            } else {
                return "male";
            }
        }
    }

