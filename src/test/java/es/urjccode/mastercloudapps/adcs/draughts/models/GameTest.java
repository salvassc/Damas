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

    @Test
    public void testGivenGameWhenConstructThenInitialDistribution(){
        assertEquals(Color.WHITE, game.getColor(new Coordinate(5,0)));
        assertEquals(Color.BLACK, game.getColor(new Coordinate(2,1)));
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