package es.urjccode.mastercloudapps.adcs.draughts.models;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class GameWithKingTest {

    @Mock
    Piece piece;
    
    @Mock
    Board board;

    @InjectMocks
    Game game;

    @Before
    public void before(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGivenGameWhenWhiteMenAtLimitThenNewKing(){
        Coordinate origin = new Coordinate(1,0);
        Coordinate target = new Coordinate(0,1);
        
        when(board.isEmpty(origin)).thenReturn(false);
        when(board.getColor(origin)).thenReturn(Color.WHITE);
        when(board.getPiece(origin)).thenReturn(piece);
        when(piece.isCorrect(origin, target, board)).thenReturn(null);
        when(board.remove(origin)).thenReturn(new Piece(Color.WHITE));
        when(board.getPiece(target)).thenReturn(new Piece(Color.WHITE));

        game.move(origin, target);
        verify(board).remove(target);
        verify(board).put(any(Coordinate.class), any(King.class));
    }

    @Test
    public void testGivenGameWhenWhiteMenAtLimitAndEatingThenNewKing(){
        Coordinate origin = new Coordinate(2,1);
        Coordinate target = new Coordinate(0,3);

        when(board.isEmpty(origin)).thenReturn(false);
        when(board.getColor(origin)).thenReturn(Color.WHITE);
        when(board.getPiece(origin)).thenReturn(piece);
        when(piece.isCorrect(origin, target, board)).thenReturn(null);
        when(board.remove(origin)).thenReturn(new Piece(Color.WHITE));
        when(board.getPiece(target)).thenReturn(new Piece(Color.WHITE));

        game.move(origin, target);
        verify(board).remove(origin.betweenDiagonal(target));
        verify(board).remove(target);
        verify(board).put(any(Coordinate.class), any(King.class));
    }

    @Test
    public void testGivenGameWhenBlackMenAtLimitThenNewKing(){
        Coordinate origin = new Coordinate(6,3);
        Coordinate target = new Coordinate(7,2);

        when(board.isEmpty(origin)).thenReturn(false);
        when(board.getColor(origin)).thenReturn(Color.BLACK);
        when(board.getPiece(origin)).thenReturn(piece);
        when(piece.isCorrect(origin, target, board)).thenReturn(null);
        when(board.remove(origin)).thenReturn(new Piece(Color.BLACK));
        when(board.getPiece(target)).thenReturn(new Piece(Color.BLACK));

        game.turn.change();
        game.move(origin, target);
        verify(board).remove(target);
        verify(board).put(any(Coordinate.class), any(King.class));
    }

    @Test
    public void testGivenGameWhenBlackMenAtLimitAndEatingThenNewKing(){
        Coordinate origin = new Coordinate(5,0);
        Coordinate target = new Coordinate(7,2);

        when(board.isEmpty(origin)).thenReturn(false);
        when(board.getColor(origin)).thenReturn(Color.BLACK);
        when(board.getPiece(origin)).thenReturn(piece);
        when(piece.isCorrect(origin, target, board)).thenReturn(null);
        when(board.remove(origin)).thenReturn(new Piece(Color.BLACK));
        when(board.getPiece(target)).thenReturn(new Piece(Color.BLACK));

        game.turn.change();
        game.move(origin, target);
        verify(board).remove(origin.betweenDiagonal(target));
        verify(board).remove(target);
        verify(board).put(any(Coordinate.class), any(King.class));
    }

}