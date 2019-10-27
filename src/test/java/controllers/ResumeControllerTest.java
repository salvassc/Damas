package controllers;

import models.Game;
import models.State;
import models.StateValue;

import static org.junit.Assert.assertEquals;

import controllers.ResumeController;

public class ResumeControllerTest{

    public ResumeControllerTest(){}

    public void testResume(){
        Game game = new Game();
        State state = new State();
        ResumeController resumeController = new ResumeController(game, state);
        StateValue stateValue = state.getStateValue();
        assertEquals(stateValue, StateValue.INITIAL);
        resumeController.resume(false);
        assertEquals(stateValue, StateValue.IN_GAME);
        resumeController.resume(false);
        assertEquals(stateValue, StateValue.FINAL);
        resumeController.resume(false);
        assertEquals(stateValue, StateValue.EXIT);
        resumeController.resume(true);
        assertEquals(stateValue, StateValue.INITIAL);
    }
}