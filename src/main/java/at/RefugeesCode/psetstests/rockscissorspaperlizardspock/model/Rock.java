package at.RefugeesCode.psetstests.rockscissorspaperlizardspock.model;

public class Rock implements Choice {


    @Override
    public ChoiceType getName() {
        return ChoiceType.Rock;
    }

    @Override
    public boolean isWin(Choice choice) {
        return ((choice.getName().equals(ChoiceType.Lizard) || (choice.getName().equals(ChoiceType.Scissors))));
    }
}
