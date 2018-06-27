package at.RefugeesCode.psetstests.rockscissorspaperlizardspock.controller;


import at.RefugeesCode.psetstests.rockscissorspaperlizardspock.model.Choice;
import at.RefugeesCode.psetstests.rockscissorspaperlizardspock.model.Choices;
import at.RefugeesCode.psetstests.rockscissorspaperlizardspock.model.Player;
import at.RefugeesCode.psetstests.rockscissorspaperlizardspock.model.Result;
import at.RefugeesCode.psetstests.rockscissorspaperlizardspock.view.Viewer;

public class RockScissorsPaperGame {
    private Viewer viewer = new Viewer();
    private Choices choices = new Choices();
    private Judge consultant = new Judge();

    public void play() {

        Player player1 = new HumanPlayer();
        Player player2 = new ComputerPlayer();
        do {
            playRound(player1, player2);
        }
        while (wantToPlayAgain(player1, player2));
    }

    private boolean wantToPlayAgain(Player player1, Player player2) {
        return player1.wantToPlay() && player2.wantToPlay();
    }

    private void playRound(Player player1, Player player2) {
        Choice player1Choice = player1.playOneRound(choices);
        Choice player2Choice = player2.playOneRound(choices);
        Result result = consultant.getResult(player1Choice, player2Choice);
        viewer.viewTheResult(result);

    }
}
