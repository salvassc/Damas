package models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import types.Color;

public class BoardTest{

    private Board board;

    public BoardTest(){}

    @Before
    public void initBoard(){
        board = new Board();
    }

    @Test
    public void testInitBoard(){
        int numPiecesColor = 12;
        assertNotNull(board.getPiece(new Coordinate(7,0)));
        assertNull(board.getPiece(new Coordinate(7,1)));
        assertEquals(board.getPiecesBlack(),numPiecesColor);
        assertEquals(board.getPiecesWhite(),numPiecesColor);
        assertEquals(board.getPiecesPeons(),24);
        assertEquals(board.getPiecesLadies(),0);
        assertFalse(board.isWinner());
    }

    @Test
    public void testAddPiecesBoard(){
        board.addPiecesBoard(new Coordinate(4,1), new Peon(Color.WHITE), Color.WHITE);
        Coordinate coordinateAdd = new Coordinate(4,1);
        assertNotNull(board.getPiece(coordinateAdd));
        assertEquals(board.getPiece(coordinateAdd).getColor(), Color.WHITE);
        assertEquals(board.getPiecesWhite(), 13);
        assertEquals(board.getPiecesBlack(), 13);
    }

    @Test
    public void testIsPosibleMove(){
        assertFalse(board.isPosibleMove(new Coordinate(7,0), new Coordinate(6,1)));
        assertTrue(board.isPosibleMove(new Coordinate(5,6), new Coordinate(4,7)));
    }
    
    @Test
    public void testMoveSimple(){
        Coordinate origin = new Coordinate(5,0);
        Coordinate target = new Coordinate(4,1);
        Piece pieceTarget = board.getPiece(target);
        board.move(origin, target);
        assertNull(board.getPiece(origin));
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget, Color.WHITE);
    }

    @Test
    public void testMoveError(){
        Coordinate origin = new Coordinate(7,2);
        Coordinate target = new Coordinate(6,3);
        Piece pieceTarget = board.getPiece(target);
        board.move(origin, target);
        assertNull(board.getPiece(origin));
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget, Color.WHITE);

    }

    @Test
    public void testMoveErrorColorBlack(){
        Coordinate origin = new Coordinate(0,1);
        board.move(origin,new Coordinate(1,2));
        Piece pieceOrigin = board.getPiece(origin);
        assertNotNull(board.getPiece(origin));
        assertEquals(pieceOrigin.getColor(), Color.BLACK);
    }

    public void testMoveEat(){
        Coordinate originMove1 = new Coordinate(5,2);
        Coordinate targetMove1 = new Coordinate(4,3);
        board.move(originMove1,targetMove1);
        Piece pieceTargetMove1 = board.getPiece(targetMove1);
        assertNull(board.getPiece(originMove1));
        assertNotNull(pieceTargetMove1);
        assertEquals(pieceTargetMove1.getColor(), Color.WHITE);

        
        Coordinate originMove2 = new Coordinate(2,1);
        Coordinate targetMove2 = new Coordinate(3,2);
        board.move(originMove2,targetMove2);
        Piece pieceTargetMove2 = board.getPiece(targetMove2);
        assertNull(board.getPiece(originMove2));
        assertNotNull(pieceTargetMove2);
        assertEquals(pieceTargetMove2.getColor(), Color.BLACK);

        
        Coordinate originMove3 = new Coordinate(4,3);
        Coordinate targetMove3 = new Coordinate(2,1);
        board.move(originMove3,targetMove3);
        Piece pieceTargetMove3 = board.getPiece(targetMove3);
        assertNull(board.getPiece(originMove3));
        assertNotNull(pieceTargetMove3);
        assertEquals(pieceTargetMove3.getColor(), Color.WHITE);
    }

    @Test
    public void testMoveEatZigzag(){
        Coordinate originMove1 = new Coordinate(5,0);
        Coordinate targetMove1 = new Coordinate(4,1);
        board.move(originMove1,targetMove1);
        Piece pieceTargetMove1 = board.getPiece(targetMove1);
        assertNull(board.getPiece(originMove1));
        assertNotNull(pieceTargetMove1);
        assertEquals(pieceTargetMove1.getColor(), Color.WHITE);

        Coordinate originMove2 = new Coordinate(2,1);
        Coordinate targetMove2 = new Coordinate(3,2);
        Coordinate targetZigzag = new Coordinate(5,0);
        board.move(originMove2,targetMove2,targetZigzag);
        Piece pieceTargetZigzag = board.getPiece(targetZigzag);
        assertNull(board.getPiece(originMove2));
        assertNull(board.getPiece(targetMove2));
        assertNotNull(pieceTargetZigzag);
        assertEquals(pieceTargetZigzag.getColor(), Color.BLACK);
    }
        
}