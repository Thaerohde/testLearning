package at.RefugeesCode.psetstests.rockscissorspaperlizardspock.controller;


import at.RefugeesCode.psetstests.pset4.controller.SecurityControl;
import at.RefugeesCode.psetstests.rockscissorspaperlizardspock.model.Choice;
import at.RefugeesCode.psetstests.rockscissorspaperlizardspock.model.Result;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;


class JudgeTest {
    private Judge judge = new Judge();
    private Choice firstChoice;
    private Choice secondChoice;



    @BeforeEach
    public void before() {

        firstChoice =  Mockito.mock(Choice.class);
        secondChoice =  Mockito.mock(Choice.class);

    }


    @Test
    public void getResultFirstPlayerWins() {

        Mockito.when(firstChoice.isWin(secondChoice)).thenReturn(true);
        Result result = judge.getResult(firstChoice, secondChoice);
        Assertions.assertEquals(result.getWinner(), "Player one wins");

    }

    @Test
    public void getResultSecondPlayerWins() {

        Mockito.when(secondChoice.isWin(firstChoice)).thenReturn(true);
        Result result = judge.getResult(firstChoice, secondChoice);
        Assertions.assertEquals(result.getWinner(), "Player two wins");

    }

    @Test
    public void getResultNoOneWins() {

        Result result = judge.getResult(firstChoice, secondChoice);
        Assertions.assertEquals(result.getWinner(), "No one!!");

    }
}