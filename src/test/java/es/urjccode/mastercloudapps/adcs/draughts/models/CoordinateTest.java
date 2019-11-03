package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CoordinateTest {

    @Parameters
    public static Collection<Object[]> data(){
        return Arrays.asList(new Object[][]{
            {new Coordinate(1, 1),new Coordinate(2, 2),new Coordinate(0, 0)},
            {new Coordinate(3, 1),new Coordinate(2, 2),new Coordinate(4, 0)},
            {new Coordinate(3, 3),new Coordinate(2, 2),new Coordinate(4, 4)},
            {new Coordinate(1, 3),new Coordinate(2, 2),new Coordinate(0, 4)}
        });
    }

    private Coordinate expected;
    private Coordinate origin;
    private Coordinate target;

    public CoordinateTest(Coordinate expected, Coordinate origin, Coordinate target){
        this.expected = expected;
        this.origin = origin;
        this.target = target;
    }

    @Test
    public void testCoordinarteIsValid(){
        for (int i = 0; i < Board.DIMENSION; i++){
            for(int j = 0; j < Board.DIMENSION; j++){
                assertTrue(new Coordinate(i,j).isValid());
            }
        }
    }

    @Test
    public void testCoordinarteIsDiagonal(){
        for (int i = 0; i < Board.DIMENSION; i++){
            for(int j = 0; j < Board.DIMENSION; j++){
                assertTrue(new Coordinate(i,i).isDiagonal(new Coordinate(j+1, j+1)));
            }
        }
    }

    @Test
    public void testCoordinateBettweenDiagonal() {
        assertEquals(this.expected, this.origin.betweenDiagonal(target));
    }

    @Test
    public void x(){
        for (int i = 0; i < Board.DIMENSION; i++){
            for(int j = 0; j < Board.DIMENSION; j++){
                assertEquals(1,new Coordinate(i,j).diagonalDistance(new Coordinate(i+1,j+1)));
            }
        }
    }

}