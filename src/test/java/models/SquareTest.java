package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import types.Color;

public class SquareTest{

    public SquareTest(){}

    @Test
    public void TestIsEmpty(){
        Square squareEmpty = new Square();
        assertNull(squareEmpty.getPiece());
        assertTrue(squareEmpty.isEmpty());
        Square squareWithPiece = new Square(new Peon(Color.WHITE));
        assertNotNull(squareWithPiece.getPiece());
        assertEquals(squareWithPiece.getPiece().getColor(), Color.WHITE);
        assertFalse(squareWithPiece.isEmpty());
    }
}