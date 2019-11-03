package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PieceTest {

    Piece pieceWhite;
    Piece pieceBlack;

    @Before
    public void initPieces(){
        this.pieceWhite = new Piece(Color.WHITE);
        this.pieceBlack = new Piece(Color.BLACK);
    }

    @Test
    public void testPieceIsAdvancedOk(){
        assertTrue(this.pieceWhite.isAdvanced(new Coordinate(5,0), new Coordinate(4,1)));
        assertTrue(this.pieceBlack.isAdvanced(new Coordinate(2,1), new Coordinate(3,2)));
    }

    @Test
    public void testPieceIsAdvancedError(){
        assertFalse(this.pieceWhite.isAdvanced(new Coordinate(5,0), new Coordinate(6,1)));
        assertFalse(this.pieceBlack.isAdvanced(new Coordinate(2,1), new Coordinate(1,2)));
    }

    @Test
    public void testPieceIsBlack(){
        assertFalse(this.pieceWhite.isBlack());
        assertTrue(this.pieceBlack.isBlack());
    }
}