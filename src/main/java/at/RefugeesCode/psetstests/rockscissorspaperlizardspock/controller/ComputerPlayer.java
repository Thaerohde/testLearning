package at.RefugeesCode.psetstests.rockscissorspaperlizardspock.controller;


import at.RefugeesCode.psetstests.rockscissorspaperlizardspock.model.Choice;
import at.RefugeesCode.psetstests.rockscissorspaperlizardspock.model.Choices;
import at.RefugeesCode.psetstests.rockscissorspaperlizardspock.model.Player;
import at.RefugeesCode.psetstests.rockscissorspaperlizardspock.view.Viewer;

import java.util.Collections;
import java.util.List;

public class ComputerPlayer implements Player {
    @Override
    public Choice playOneRound(Choices choises) {
        return getPlayer2Choice(choises);

    }

    @Override
    public boolean wantToPlay() {
        return true;
    }


    private Choice getPlayer2Choice(Choices choises) {
        List<Choice> player2Choice = choises.getChoises();
        Collections.shuffle(player2Choice);

        Viewer.showPlayer2Choice(player2Choice.get(0).getName());
        return player2Choice.get(0);
    }
}
