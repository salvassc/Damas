package controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import models.Coordinate;
import models.Game;
import models.Piece;
import types.Color;

public class PlayControllerTest{

    private Game game;
    private PlayController playController;

    public PlayControllerTest(){}

    @Before
    public void initParameters(){
        game = new Game();
        playController = new PlayController(game,null);
    }

    @Test
    public void TestMoveSimple(){
        Coordinate origin = new Coordinate(5,0);
        Coordinate target = new Coordinate(4,1);
        Piece pieceTarget = game.getPiece(target);
        Error error = playController.move(origin, target);
        assertNull(error);
        assertNull(playController.getPiece(origin));
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget, Color.WHITE);
    }

    @Test
    public void testMoveError(){
        Coordinate origin = new Coordinate(7,2);
        Coordinate target = new Coordinate(6,3);
        Piece pieceTarget = playController.getPiece(target);
        playController.move(origin, target);
        assertNull(playController.getPiece(origin));
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget, Color.WHITE);
    }

    @Test
    public void testMoveErrorColorBlack(){
        Coordinate origin = new Coordinate(0,1);
        playController.move(origin,new Coordinate(1,2));
        Piece pieceOrigin = playController.getPiece(origin);
        assertNotNull(playController.getPiece(origin));
        assertEquals(pieceOrigin.getColor(), Color.BLACK);
    }

    public void testMoveEat(){
        Coordinate originMove1 = new Coordinate(5,2);
        Coordinate targetMove1 = new Coordinate(4,3);
        playController.move(originMove1,targetMove1);
        Piece pieceTargetMove1 = playController.getPiece(targetMove1);
        assertNull(playController.getPiece(originMove1));
        assertNotNull(pieceTargetMove1);
        assertEquals(pieceTargetMove1.getColor(), Color.WHITE);

        
        Coordinate originMove2 = new Coordinate(2,1);
        Coordinate targetMove2 = new Coordinate(3,2);
        playController.move(originMove2,targetMove2);
        Piece pieceTargetMove2 = playController.getPiece(targetMove2);
        assertNull(playController.getPiece(originMove2));
        assertNotNull(pieceTargetMove2);
        assertEquals(pieceTargetMove2.getColor(), Color.BLACK);

        
        Coordinate originMove3 = new Coordinate(4,3);
        Coordinate targetMove3 = new Coordinate(2,1);
        playController.move(originMove3,targetMove3);
        Piece pieceTargetMove3 = playController.getPiece(targetMove3);
        assertNull(playController.getPiece(originMove3));
        assertNotNull(pieceTargetMove3);
        assertEquals(pieceTargetMove3.getColor(), Color.WHITE);
    }

    @Test
    public void testMoveEatZigzag(){
        Coordinate originMove1 = new Coordinate(5,0);
        Coordinate targetMove1 = new Coordinate(4,1);
        playController.move(originMove1,targetMove1);
        Piece pieceTargetMove1 = playController.getPiece(targetMove1);
        assertNull(playController.getPiece(originMove1));
        assertNotNull(pieceTargetMove1);
        assertEquals(pieceTargetMove1.getColor(), Color.WHITE);

        Coordinate originMove2 = new Coordinate(2,1);
        Coordinate targetMove2 = new Coordinate(3,2);
        Coordinate targetZigzag = new Coordinate(5,0);
        playController.move(originMove2,targetMove2,targetZigzag);
        Piece pieceTargetZigzag = playController.getPiece(targetZigzag);
        assertNull(playController.getPiece(originMove2));
        assertNull(playController.getPiece(targetMove2));
        assertNotNull(pieceTargetZigzag);
        assertEquals(pieceTargetZigzag.getColor(), Color.BLACK);
    }

}