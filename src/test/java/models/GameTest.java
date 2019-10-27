package models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import types.Color;

public class GameTest{

    public GameTest(){}

    @Test
    public void testTurnGame(){
        Game game = new Game();
        Color colorActual = game.getTurn().getColor();
        assertEquals(colorActual, Color.WHITE);
        game.nextTurn();
        assertEquals(colorActual, Color.BLACK);
    }       
}