package at.RefugeesCode.psetstests.pset2.rockscissorspaper.view;



import at.RefugeesCode.psetstests.pset2.rockscissorspaper.model.Choice;
import at.RefugeesCode.psetstests.pset2.rockscissorspaper.model.Choices;
import at.RefugeesCode.psetstests.pset2.rockscissorspaper.model.Player;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HumanPlayer implements Player {

    @Override
    public Choice makeMove(Choices choises) {
        //Greeting();
        Choices choices = new Choices();
        System.out.println("Please choose one from the following List");
        ShowChoices(choices);
        Scanner scanner = new Scanner(System.in);
        Choice humanChoice = getAChoice(choises);
        System.out.println("Your choice is : " + humanChoice.getName());

        return humanChoice;
    }

    @Override
    public boolean wantToPlay() {
        System.out.println("Do you want to play again?");
        Scanner scanner = new Scanner(System.in);
        String feedBack = scanner.next();
        if ((feedBack.equalsIgnoreCase("Yes")) || (feedBack.equalsIgnoreCase("Y"))) {
            return true;
        } else return false;
    }


    private Choice getAChoice(Choices choises) {

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        if (choises.getChoises().stream()
                .filter(move -> move.getName().equalsIgnoreCase(choice))

                .findFirst().isPresent()) {

            return choises.getChoises().stream()
                    .filter(move -> move.getName().equalsIgnoreCase(choice))

                    .findFirst().get();
        } else {
            System.out.println("Invalid move");
            System.exit(1);
        }
        return choises.getChoises().stream()
                .filter(move -> move.getName().equalsIgnoreCase(choice))

                .findFirst().get();

    }



    private void ShowChoices(Choices choices) {
        List<String> choice = choices.getChoises()
                .stream()

                .map(e -> e.getName())
                .collect(Collectors.toList());
        System.out.println(choice);
    }

}
