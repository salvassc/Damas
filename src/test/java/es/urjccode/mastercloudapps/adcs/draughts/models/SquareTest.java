package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class SquareTest {

    private Square square;

    @Before
    public void initSquare(){
        square = new Square();
    }

    @Test
    public void testSquareIsEmpty(){
        assertTrue(this.square.isEmpty());
    }

    @Test
    public void testSquarePut(){
        square.put(new Piece(Color.WHITE));
        assertFalse(square.isEmpty());
        assertNotNull(square.getPiece());
        assertEquals(Color.WHITE, square.getColor());
    }

    @Test
    public void testSquareRemove(){
        square.remove();
        assertNull(square.getPiece());
    }
}