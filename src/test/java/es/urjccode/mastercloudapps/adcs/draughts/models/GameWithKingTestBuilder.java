package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class GameWithKingTestBuilder {

    @Test
    public void testGivenGameWhenWhiteMenAtLimitThenNewKing(){
        Coordinate origin = new Coordinate(1,0);
        Coordinate target = new Coordinate(0,1);

        Game game = new GameBuilder()
            .row("        ")
            .row("b       ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .build();
        assertEquals(Color.WHITE, game.getPiece(origin).getColor());
        assertNull(game.getPiece(target));

        game.move(origin, target);

        assertNull(game.getPiece(origin));
        assertEquals(Color.WHITE, game.getPiece(target).getColor());
        
    }

   
    @Test
    public void testGivenGameWhenWhiteMenAtLimitAndEatingThenNewKing(){
        Coordinate origin = new Coordinate(2,1);
        Coordinate eat = new Coordinate(1,2);
        Coordinate target = new Coordinate(0,3);

        Game game = new GameBuilder()
            .row("        ")
            .row("  n     ")
            .row(" b      ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .row("        ")
            .build();
        
        assertEquals(Color.WHITE, game.getPiece(origin).getColor());
        assertEquals(Color.BLACK, game.getPiece(eat).getColor());
        assertNull(game.getPiece(target));

        game.move(origin, target);

        assertNull(game.getPiece(origin));
        assertNull(game.getPiece(eat));
        assertEquals(Color.WHITE, game.getPiece(target).getColor());
    }

     @Test
    public void testGivenGameWhenBlackMenAtLimitThenNewKing(){
        Coordinate origin = new Coordinate(6,3);
        Coordinate target = new Coordinate(7,2);

        Game game = new GameBuilder()
        .row("        ")
        .row("        ")
        .row("        ")
        .row("        ")
        .row("        ")
        .row("        ")
        .row("   n    ")
        .row("        ")
        .build();

        assertEquals(Color.BLACK, game.getPiece(origin).getColor());
        assertNull(game.getPiece(target));

        game.move(origin, target);

        assertNull(game.getPiece(origin));
        assertEquals(Color.BLACK, game.getPiece(target).getColor());
    }

    @Test
    public void testGivenGameWhenBlackMenAtLimitAndEatingThenNewKing(){
        Coordinate origin = new Coordinate(5,0);
        Coordinate eat = new Coordinate(6,1);
        Coordinate target = new Coordinate(7,2);

        Game game = new GameBuilder()
        .row("        ")
        .row("        ")
        .row("        ")
        .row("        ")
        .row("        ")
        .row("n       ")
        .row(" b      ")
        .row("        ")
        .build();

        assertEquals(Color.BLACK, game.getPiece(origin).getColor());
        assertEquals(Color.WHITE, game.getPiece(eat).getColor());
        assertNull(game.getPiece(target));

        game.move(origin, target);

        assertNull(game.getPiece(origin));
        assertNull(game.getPiece(eat));
        assertEquals(Color.BLACK, game.getPiece(target).getColor());
    }

}