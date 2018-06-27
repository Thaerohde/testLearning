package at.RefugeesCode.psetstests.rockscissorspaperlizardspock.model;

public class Lizard implements Choice {
    @Override
    public ChoiceType getName() {
        return ChoiceType.Lizard;
    }

    @Override
    public boolean isWin(Choice choice) {
        return ((choice.getName().equals(ChoiceType.Spock) || (choice.getName().equals(ChoiceType.Paper))));
    }
}
