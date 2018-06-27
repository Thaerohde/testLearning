package at.RefugeesCode.psetstests.pset2.rockscissorspaper.controller;

import at.RefugeesCode.psetstests.pset2.rockscissorspaper.model.Choice;
import at.RefugeesCode.psetstests.pset2.rockscissorspaper.model.Result;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

class JudgeTest {
    private Judge judge = new Judge();
    private Choice firstChoice;
    private Choice secondChoice;


    @Test
    public void getResultmove1wins() {
        firstChoice = Mockito.mock(Choice.class);
        secondChoice = Mockito.mock(Choice.class);
        when(firstChoice.getName()).thenReturn("Rock");
        when(secondChoice.getName()).thenReturn("Scissors");

        Result result = judge.getResult(firstChoice, secondChoice);

        Assertions.assertEquals("The winner " + firstChoice.getName(), result.getWinner());


    }

    @Test
    public void getResultmove2wins() {
        firstChoice = Mockito.mock(Choice.class);
        secondChoice = Mockito.mock(Choice.class);
        when(firstChoice.getName()).thenReturn("Paper");
        when(secondChoice.getName()).thenReturn("Scissors");

        Result result = judge.getResult(firstChoice, secondChoice);

        Assertions.assertEquals("The winner " + secondChoice.getName(), result.getWinner());


    }

    @Test
    public void getResultmovetie() {
        firstChoice = Mockito.mock(Choice.class);
        secondChoice = Mockito.mock(Choice.class);
        when(firstChoice.getName()).thenReturn("Paper");
        when(secondChoice.getName()).thenReturn("Paper");

        Result result = judge.getResult(firstChoice, secondChoice);

        Assertions.assertEquals("tie", result.getWinner());


    }
}