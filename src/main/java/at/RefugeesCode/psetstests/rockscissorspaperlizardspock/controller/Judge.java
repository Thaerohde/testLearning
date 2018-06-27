package at.RefugeesCode.psetstests.rockscissorspaperlizardspock.controller;


import at.RefugeesCode.psetstests.rockscissorspaperlizardspock.model.Choice;
import at.RefugeesCode.psetstests.rockscissorspaperlizardspock.model.Result;

public class Judge {

    public Result getResult(Choice choice1, Choice choice2) {
        Result result = new Result();
        result.setChoice1(choice1);
        result.setChoice2(choice2);
        result.setWinner(getWinner(choice1, choice2));
        return result;
    }

    private String getWinner(Choice choice1, Choice choice2) {
        if (choice1.isWin(choice2)) {
            return "Player one wins";
        }
        if (choice2.isWin(choice1)) {
            return "Player two wins";
        }
        return "No one!!";
    }

}


