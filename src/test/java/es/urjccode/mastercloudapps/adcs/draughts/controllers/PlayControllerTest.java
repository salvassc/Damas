package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import es.urjccode.mastercloudapps.adcs.draughts.models.Game;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Piece;
import es.urjccode.mastercloudapps.adcs.draughts.models.Color;

public class PlayControllerTest {

    private Game game;
    private PlayController playController;

    public PlayControllerTest() {}

    @Before
    public void initParameters(){
        game = new Game();
        playController = new PlayController(game,null);
    }

    @Test
    public void testMoveOk() {
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(4, 1);
        assertNull(playController.move(origin, target));
        assertNull(playController.getPiece(origin));
        Piece pieceTarget = playController.getPiece(target);
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget.getColor(), Color.WHITE);
    }

    @Test
    public void testMoveError(){
        Coordinate origin = new Coordinate(7,2);
        Coordinate target = new Coordinate(6,3);
        Piece pieceOrigin = playController.getPiece(origin);
        Piece pieceTarget = playController.getPiece(target);
        assertNotNull(playController.move(origin, target));
        assertEquals(pieceOrigin.getColor(), Color.WHITE);
        assertEquals(pieceTarget.getColor(), Color.WHITE);
    }

    @Test
    public void testMoveErrorColorBlack(){
        assertNotNull(playController.move(new Coordinate(2,1),new Coordinate(3,2)));
    }

    @Test
    public void testMoveEat() {
        Coordinate originMove1 = new Coordinate(5,2);
        Coordinate targetMove1 = new Coordinate(4,3);
        assertNull(playController.move(originMove1,targetMove1));
        assertNull(playController.getPiece(originMove1));
        assertEquals(playController.getPiece(targetMove1).getColor(), Color.WHITE);

        
        Coordinate originMove2 = new Coordinate(2,1);
        Coordinate targetMove2 = new Coordinate(3,2);
        assertNull(playController.move(originMove2,targetMove2));
        assertNull(playController.getPiece(originMove2));
        assertEquals(playController.getPiece(targetMove2).getColor(), Color.BLACK);

        
        Coordinate originMove3 = new Coordinate(4,3);
        Coordinate targetMove3 = new Coordinate(2,1);
        assertNull(playController.move(originMove3,targetMove3));
        assertNull(playController.getPiece(originMove3));
        assertEquals(playController.getPiece(targetMove3).getColor(), Color.WHITE);

        assertNull(playController.getPiece(targetMove2));
    }

}