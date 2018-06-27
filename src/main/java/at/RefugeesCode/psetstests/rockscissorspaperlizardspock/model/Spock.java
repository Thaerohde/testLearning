package at.RefugeesCode.psetstests.rockscissorspaperlizardspock.model;

public class  Spock implements Choice {
    @Override
    public ChoiceType getName() {
        return ChoiceType.Spock;
    }

    @Override
    public boolean isWin(Choice choice) {
        return ((choice.getName().equals(ChoiceType.Scissors) || (choice.getName().equals(ChoiceType.Rock))));
    }
}
