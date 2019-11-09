package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Game;
import es.urjccode.mastercloudapps.adcs.draughts.models.Piece;
import es.urjccode.mastercloudapps.adcs.draughts.models.State;
import es.urjccode.mastercloudapps.adcs.draughts.models.Color;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;

public class PlayControllerTest {

    private PlayController playController;

    @Before
    public void init(){
        playController = new PlayController(new Game(), new State());
    }

    @Test
    public void givenPlayControllerWhenMovementRequiereCorrectThenNotError() {
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(4, 1);
        assertNull(playController.move(origin, target));
        assertNull(playController.getPiece(origin));
        Piece pieceTarget = playController.getPiece(target);
        assertNotNull(pieceTarget);
        assertEquals(pieceTarget.getColor(), Color.WHITE);
    }

    private Error advance(Coordinate[][] coordinates){
        Error error = null;
        for (int i = 0; i < coordinates.length; i++) {
            assertNull(error);
            error = playController.checkMovements(coordinates[i][0], coordinates[i][1]);
            if (error == null){
                playController.move(coordinates[i][0], coordinates[i][1]);
            }
        }
        return error;
    }

    @Test()
    public void testGivenPlayControllerGameWhenMoveWithOuterCoordinateThenOutCoordinateError() {
        assertEquals(Error.OUT_COORDINATE, this.advance(new Coordinate[][] {{new Coordinate(4, 7), new Coordinate(3, 8)},}));
        assertEquals(Error.OUT_COORDINATE, this.advance(new Coordinate[][] {{new Coordinate(8, 3), new Coordinate(4, 1)},}));
    }

    @Test
    public void testGivenPlayControllerWhenMoveEmptySquaerThenEmptySquareError() {
        assertEquals(Error.EMPTY_ORIGIN, this.advance(new Coordinate[][] {{new Coordinate(4, 3), new Coordinate(3, 4)},}));
    }

    @Test
    public void testGivenPlayControllerWhenMoveOppositePieceThenError() {
        assertEquals(Error.OPPOSITE_PIECE, this.advance(new Coordinate[][] { 
            { new Coordinate(5, 6), new Coordinate(4, 7) },
            { new Coordinate(2, 7), new Coordinate(3, 6) }, 
            { new Coordinate(3, 6), new Coordinate(2, 7) }, 
        }));
    }

    // public void data(){
    //     Coordinate[][] coordinates = new Coordinate[][] {
    //         { new Coordinate(0,0), new Coordinate(0,0) },
    //         { new Coordinate(0,0), new Coordinate(0,0), new Coordinate(0,0), new Coordinate(0,0) },
    //         { new Coordinate(0,0), new Coordinate(0,0) },
    //     };

        // peon mueve una
        // peon come una
        // peon come varias
        // peon se convierte en dama
        // dama mueve una
        // dama mueve varias
        // dama come una
        // dama come varias, atras

    //}


}