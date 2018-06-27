package at.RefugeesCode.psetstests.rockscissorspaperlizardspock.model;

public interface Choice {
    ChoiceType getName();

    boolean isWin(Choice choice);
}
