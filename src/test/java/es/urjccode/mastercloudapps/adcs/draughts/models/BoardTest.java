package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class BoardTest {

    private Board board;

    public BoardTest() {
        this.board = new Board();
    }

    @Test
    public void testGoodLocationsWhites(){
        int j=1;
        int column=0;
        for (int i = 0; i < 3; i++) {
            while(j < Board.DIMENSION){
                assertEquals(Color.BLACK, board.getColor(new Coordinate(i,j)));
                j+=2;
            }
            j = column;
            column++;
        }
    }
    

    @Test
    public void testGoodLocationsBlacks() {
        int j=0;
        int column=1;
        for (int i = 5; i < Board.DIMENSION; i++) {
            while(j < Board.DIMENSION){
                assertEquals(Color.WHITE, board.getColor(new Coordinate(i,j)));
                j+=2;
            }
            j = column;
            column--;
        }
    }
}