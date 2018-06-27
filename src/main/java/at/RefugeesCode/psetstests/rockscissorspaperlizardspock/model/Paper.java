package at.RefugeesCode.psetstests.rockscissorspaperlizardspock.model;

public class Paper implements Choice {

    @Override
    public ChoiceType getName() {

        return ChoiceType.Paper;
    }

    @Override
    public boolean isWin(Choice choice) {
        return ((choice.getName().equals(ChoiceType.Spock) || (choice.getName().equals(ChoiceType.Rock))));
    }
}
