package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class TurnTest{

    private Turn turn;

    @Before
    public void initTurn(){
        this.turn = new Turn();
    }

    @Test
    public void testGetColorTurn(){
        assertEquals(Color.WHITE, this.turn.getColorTurn());
        assertTrue(this.turn.isColor(Color.WHITE));
        assertFalse(this.turn.isColor(Color.BLACK));
    }

    @Test
    public void testChangeTurn(){
        this.turn.change();
        assertEquals(Color.BLACK, this.turn.getColorTurn());
        assertTrue(this.turn.isColor(Color.BLACK));
        assertFalse(this.turn.isColor(Color.WHITE));
    }
}