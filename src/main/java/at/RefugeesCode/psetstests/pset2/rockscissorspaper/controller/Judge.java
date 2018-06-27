package at.RefugeesCode.psetstests.pset2.rockscissorspaper.controller;


import at.RefugeesCode.psetstests.pset2.rockscissorspaper.model.Choice;
import at.RefugeesCode.psetstests.pset2.rockscissorspaper.model.Result;

import java.util.HashMap;

public class Judge {

    private HashMap<String, String> jury;

    public Judge() {
        jury = new HashMap<>();
        jury.put("rock", "scissors");
        jury.put("scissors", "paper");
        jury.put("paper", "rock");
    }

    //        String[] options = {"ROCK", "SCISSORS", "PAPER"};
//        Integer difference = ((computerChoice.toUpperCase()).indexOf(String.valueOf(options)) - humanChoice.toUpperCase().indexOf(String.valueOf(options)));
//
//        if (difference == 0) {
//            System.out.println("its a tie,no one wins");
//
//        } else if ((difference == -1) || (difference == -2)) {
//            System.out.println("You lost !!!!");
//        } else System.out.println("You won! ");


    public Result getResult(Choice choice1, Choice choice2) {
        Result result = new Result();
        result.setChoice1(choice1);
        result.setChoice2(choice2);
        result.setWinner(findWinner(choice1, choice2));
        return result;
    }

    private String findWinner(Choice choice1, Choice choice2) {
        String opposite = jury.get(choice1.getName().toLowerCase());

        if (opposite == null) {
            return "invalid move ";
        }

        if (choice1.getName().equalsIgnoreCase(choice2.getName())) {
            return "tie";
        }
        if (choice2.getName().equalsIgnoreCase(opposite)) {
            return ("The winner " + choice1.getName());
        }
        return ("The winner " + choice2.getName());

    }
}


