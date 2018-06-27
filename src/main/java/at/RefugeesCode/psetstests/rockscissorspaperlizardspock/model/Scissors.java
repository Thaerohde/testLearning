package at.RefugeesCode.psetstests.rockscissorspaperlizardspock.model;

public class Scissors implements Choice {


    @Override
    public ChoiceType getName() {
        return ChoiceType.Scissors;
    }

    @Override
    public boolean isWin(Choice choice) {
        return ((choice.getName().equals(ChoiceType.Lizard) || (choice.getName().equals(ChoiceType.Paper))));
    }
}
  