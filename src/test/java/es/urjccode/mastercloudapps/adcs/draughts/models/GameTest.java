package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.junit.Assert.assertNull;

import org.junit.Before;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GameTest {

    private Game game;
    Error error;
    Coordinate [][] coordinates;

    @Before
    public void initGame(){
        this.game = new Game();
        this.error = null;
        coordinates = new Coordinate[][] { { new Coordinate(5, 6), new Coordinate(4, 7) }, { new Coordinate(4, 7), new Coordinate(3, 8) }, { new Coordinate(4, 3), new Coordinate(3, 4) },
        { new Coordinate(2, 7), new Coordinate(3, 6) }, { new Coordinate(3, 6), new Coordinate(2, 7)}, { new Coordinate(5, 2), new Coordinate(4, 2)},
        { new Coordinate(4, 7), new Coordinate(3, 6) }, { new Coordinate(1, 6), new Coordinate(2, 7) },{ new Coordinate(0, 7), new Coordinate(1, 6) }, 
        { new Coordinate(3, 4), new Coordinate(4, 5) },};
    }

    @Test()
    public void testGameErrorOutCoordinate() {
        assertNull(game.move(coordinates[0][0], coordinates[0][1]));
        assertEquals(Error.OUT_COORDINATE, game.move(coordinates[1][0], coordinates[1][1]));
    }

    @Test
    public void testGameErrorEmptySquare() {
        assertEquals(Error.EMPTY_ORIGIN, game.move(coordinates[2][0], coordinates[2][1]));
    }

    @Test
    public void testGameErrorMoveOppositePiece() {
        assertNull(game.move(coordinates[0][0], coordinates[0][1]));
        assertNull(game.move(coordinates[3][0], coordinates[3][1]));
        assertEquals(Error.OPPOSITE_PIECE, game.move(coordinates[4][0], coordinates[4][1]));
    }

    @Test
    public void testGameErrorNotDiagonalMovement() {
        assertEquals(Error.NOT_DIAGONAL, game.move(coordinates[5][0], coordinates[5][1]));
    }

    @Test
    public void testGameErrorWithNotAdvanced() {
        Coordinate[][] coordinates = new Coordinate[][] { { new Coordinate(5, 6), new Coordinate(4, 7) },
                { new Coordinate(2, 7), new Coordinate(3, 6) }, { new Coordinate(5, 4), new Coordinate(4, 3) },
                { new Coordinate(1, 6), new Coordinate(2, 7) }, { new Coordinate(4, 3), new Coordinate(3, 4) },
                { new Coordinate(0, 7), new Coordinate(1, 6) }, { new Coordinate(3, 4), new Coordinate(4, 5) }, };
        Error error = null;
        for (int i = 0; i < coordinates.length; i++) {
            assertNull(error);
            error = game.move(coordinates[i][0], coordinates[i][1]);
        }
        assertEquals(Error.NOT_ADVANCED, error);
    }

    @Test
    public void testGameErrorNotEmptyTarge() {
        assertNull(game.move(coordinates[0][0], coordinates[0][1]));
        assertNull(game.move(coordinates[3][0], coordinates[3][1]));
        assertEquals(Error.NOT_EMPTY_TARGET, game.move(coordinates[6][0], coordinates[6][1]));
    }

    @Test
    public void testGameCorrectMovement() {
        Coordinate origin = new Coordinate(5, 0);
        Coordinate target = new Coordinate(4, 1);
        this.game.move(origin, target);
        assertNull(this.game.getColor(origin));
        assertEquals(Color.WHITE, this.game.getColor(target));
        origin = new Coordinate(2, 3);
        target = new Coordinate(3, 4);
        this.game.move(origin, target);
        assertNull(this.game.getColor(origin));
        assertEquals(Color.BLACK, this.game.getColor(target));
    }

    @Test
    public void testGameMovementEatPiece() {
        Coordinate[][] coordinates = new Coordinate[][] { { new Coordinate(5, 0), new Coordinate(4, 1) },
                { new Coordinate(2, 1), new Coordinate(3, 0) }, { new Coordinate(5, 2), new Coordinate(4, 3) },
                { new Coordinate(3, 0), new Coordinate(5, 2) }, };
        Error error = null;
        for (int i = 0; i < coordinates.length; i++) {
            assertNull(error);
            error = game.move(coordinates[i][0], coordinates[i][1]);
        }
        assertNull(error);
        assertNull(game.getColor(new Coordinate(3, 0)));
        assertNull(game.getColor(new Coordinate(4, 1)));
        assertEquals(Color.BLACK, game.getColor(new Coordinate(5, 2)));
    }

    @Test
    public void testGameErrorEatEmptyPiece() {
        assertEquals(Error.EATING_EMPTY, this.game.move(new Coordinate(5, 4), new Coordinate(3, 2)));
    }

    @Test
    public void testGameErrorBadDistance() {
        assertEquals(Error.BAD_DISTANCE, this.game.move(new Coordinate(5, 0), new Coordinate(2, 3)));
    }

}