package at.RefugeesCode.psetstests.rockscissorspaperlizardspock.controller;


import at.RefugeesCode.psetstests.rockscissorspaperlizardspock.model.Choice;
import at.RefugeesCode.psetstests.rockscissorspaperlizardspock.model.Choices;
import at.RefugeesCode.psetstests.rockscissorspaperlizardspock.model.Player;
import at.RefugeesCode.psetstests.rockscissorspaperlizardspock.view.Viewer;

import java.util.Scanner;
import java.util.stream.Stream;

public class HumanPlayer implements Player {


    @Override
    public Choice playOneRound(Choices choises) {

        Viewer.showChoices();

        Choice humanChoice = getAChoice(choises);
        Viewer.viewPlayer1Choise(humanChoice.getName());

        return humanChoice;
    }


    @Override
    public boolean wantToPlay() {
        Viewer.player1WantToPlay();
        Scanner scanner = new Scanner(System.in);
        String feedBack = scanner.next();
        if ((feedBack.equalsIgnoreCase("Yes")) || (feedBack.equalsIgnoreCase("Y"))) {
            return true;
        } else return false;
    }


    private Choice getAChoice(Choices choices) {

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next().toUpperCase();
        return Stream.of(choices).flatMap(element -> element.getChoises().stream())
                .filter(e -> choice.equalsIgnoreCase(e.getName().toString()))
                .findFirst().get();
    }
}








