package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import types.Color;

public class PieceTest{

    public PieceTest(){}

    @Test
    public void testPieceColor(){
        Piece peonWhite = new Peon(Color.WHITE);
        assertNotNull(peonWhite.getPiece());
        assertEquals(peonWhite.getPiece().getColor(), Color.WHITE);

        Piece peonBlack = new Peon(Color.BLACK);
        assertNotNull(peonBlack.getPiece());
        assertEquals(peonBlack.getPiece().getColor(), Color.BLACK);
    }

    public void testIsLady(){
        Piece ladyWhite = new Peon(Color.WHITE);
        assertTrue(ladyWhite.isLaidies());
        assertNotNull(ladyWhite.getPiece());
        assertEquals(ladyWhite.getPiece().getColor(), Color.WHITE);

        Piece ladyBlack = new Peon(Color.BLACK);
        assertTrue(ladyBlack.isLaidies());
        assertNotNull(ladyBlack.getPiece());
        assertEquals(ladyBlack.getPiece().getColor(), Color.BLACK);

        Piece peon = new Peon(Color.WHITE);
        assertFalse(peon.isLaidies());
    }
}