package at.RefugeesCode.psetstests.rockscissorspaperlizardspock.view;



import at.RefugeesCode.psetstests.rockscissorspaperlizardspock.model.ChoiceType;
import at.RefugeesCode.psetstests.rockscissorspaperlizardspock.model.Result;


public class Viewer {


    public static void showPlayer2Choice(ChoiceType name) {
        System.out.println("Player2 choice is: " + name);
    }

    public static void showChoices() {
        System.out.println("Hello, to play, choose from the list: Rock, Scissor, Paper, Lizard, Spock ");
    }


    public static void viewPlayer1Choise(ChoiceType choice) {
        System.out.println("Your choice is : " + choice);
    }

    public static void player1WantToPlay() {
        System.out.println("Do you want to play again?");
    }

    public static void viewTheResult(Result result) {
        System.out.println("The winner is  " + result.getWinner());

    }


}



