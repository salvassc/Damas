package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import es.urjccode.mastercloudapps.adcs.draughts.models.Game;
import es.urjccode.mastercloudapps.adcs.draughts.models.State;
import es.urjccode.mastercloudapps.adcs.draughts.models.StateValue;

public class ResumeControllerTest{

    public ResumeControllerTest(){}

    @Test
    public void testResume(){
        Game game = new Game();
        State state = new State();
        ResumeController resumeController = new ResumeController(game, state);
        assertEquals(state.getStateValue(), StateValue.INITIAL);
        resumeController.resume(false);
        assertEquals(state.getStateValue(), StateValue.IN_GAME);
        resumeController.resume(false);
        assertEquals(state.getStateValue(), StateValue.FINAL);
        resumeController.resume(false);
        assertEquals(state.getStateValue(), StateValue.EXIT);
        resumeController.resume(true);
        assertEquals(state.getStateValue(), StateValue.INITIAL);
    }
}