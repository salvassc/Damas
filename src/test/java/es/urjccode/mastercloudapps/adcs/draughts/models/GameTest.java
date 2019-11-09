package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.junit.Assert.assertNull;

import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GameTest {

    private Game game;

    public GameTest() {
        game = new Game();
    }

    @Test
    public void testGivenNewBoardThenGoodLocations() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < game.getDimension(); j++) {
                Coordinate coordinate = new Coordinate(i,j);
                Color color = game.getColor(coordinate);
                if (coordinate.isBlack()){
                    assertEquals(Color.BLACK, color);
                } else {
                    assertNull(color);
                }
            }
        }
        for (int i = 5; i < game.getDimension(); i++) {
            for (int j = 0; j < game.getDimension(); j++) {
                Coordinate coordinate = new Coordinate(i,j);
                Color color = game.getColor(coordinate);
                if (coordinate.isBlack()){
                    assertEquals(Color.WHITE, color);
                } else {
                    assertNull(color);
                }
            }
        }
    }

    private Error advance(Coordinate[][] coordinates){
        Error error = null;
        for (int i = 0; i < coordinates.length; i++) {
            assertNull(error);
            error = game.move(coordinates[i][0], coordinates[i][1]);
        }
        return error;
    }

    @Test
    public void testGivenGameWhenConstructThenInitialDistribution(){
        assertEquals(Color.WHITE, game.getColor(new Coordinate(5,0)));
        assertEquals(Color.BLACK, game.getColor(new Coordinate(2,1)));
    }

    @Test
    public void testGivenGameWhenMoveWithNotAdvancedThenError() {
        assertEquals(Error.NOT_ADVANCED, this.advance(new Coordinate[][] { 
            { new Coordinate(5, 6), new Coordinate(4, 7) },
            { new Coordinate(2, 7), new Coordinate(3, 6) }, 
            { new Coordinate(5, 4), new Coordinate(4, 3) },
            { new Coordinate(1, 6), new Coordinate(2, 7) }, 
            { new Coordinate(4, 3), new Coordinate(3, 4) },
            { new Coordinate(0, 7), new Coordinate(1, 6) }, 
            { new Coordinate(3, 4), new Coordinate(4, 5) }, 
        }));        
    }

    @Test
    public void testGivenGameWhenCorrectMovementThenOk() {
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
    public void testGivenGameWhenMovementThenEatPiece() {
        assertNull(this.advance(new Coordinate[][] { 
            { new Coordinate(5, 0), new Coordinate(4, 1) },
            { new Coordinate(2, 1), new Coordinate(3, 0) }, 
            { new Coordinate(5, 2), new Coordinate(4, 3) },
            { new Coordinate(3, 0), new Coordinate(5, 2) }, 
        }));
        assertNull(game.getColor(new Coordinate(3, 0)));
        assertNull(game.getColor(new Coordinate(4, 1)));
        assertEquals(Color.BLACK, game.getColor(new Coordinate(5, 2)));
    }

    @Test
    public void testGivenGameWhenEatEmptyPieceThenError() {
        assertEquals(Error.EATING_EMPTY, this.advance(new Coordinate[][] { 
            { new Coordinate(5, 4), new Coordinate(3, 2) },
        })); 
    }

    @Test
    public void testGivenBoardWhenGetPiecesColorBlackThenPiecesColorBlack() {
        List<Piece> pieces = game.getPieces(Color.BLACK);
        for(int i = 0; i < game.getDimension(); i++){
            assertEquals(12, pieces.size());
            assertEquals(Color.BLACK, pieces.get(i).getColor());
        }
    }

    @Test
    public void testGivenBoardWhenGetPiecesColorWhiteThenPiecesColorWhite() {
        List<Piece> pieces = game.getPieces(Color.WHITE);
        for(int i = 0; i < game.getDimension(); i++){
            assertEquals(12, pieces.size());
            assertEquals(Color.WHITE, pieces.get(i).getColor());
        }
    }

}