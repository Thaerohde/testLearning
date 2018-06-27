package at.RefugeesCode.psetstests.pset2.rockscissorspaper.controller;


import at.RefugeesCode.psetstests.pset2.rockscissorspaper.model.Choice;
import at.RefugeesCode.psetstests.pset2.rockscissorspaper.model.Choices;
import at.RefugeesCode.psetstests.pset2.rockscissorspaper.model.Player;
import at.RefugeesCode.psetstests.pset2.rockscissorspaper.model.Result;
import at.RefugeesCode.psetstests.pset2.rockscissorspaper.view.ComputerPlayer;
import at.RefugeesCode.psetstests.pset2.rockscissorspaper.view.HumanPlayer;
import at.RefugeesCode.psetstests.pset2.rockscissorspaper.view.Summery;

public class RockScissorsPaperGame {

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
        Summery summary = new Summery();
        Choices choices = new Choices();
        Judge consultation = new Judge();
        Choice player1Choice = player1.makeMove(choices);
        Choice player2Choice = player2.makeMove(choices);
        Result result = consultation.getResult(player1Choice, player2Choice);
        summary.summary(result);
    }

}
