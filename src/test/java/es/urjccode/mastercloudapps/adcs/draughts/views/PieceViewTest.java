package es.urjccode.mastercloudapps.adcs.draughts.views;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Color;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Piece;

@RunWith(MockitoJUnitRunner.class)
public class PieceViewTest {

    private int row;
    private int column;

    @Mock
    PlayController playController;

    @InjectMocks
    PieceView pieceView;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
        row = 2;
        column = 1;
    }
    
    @Test
    public void testGetPiece(){
        when(playController.getPiece(new Coordinate(row, column))).thenReturn(new Piece(Color.BLACK));
        pieceView.write(row, column);
        verify(playController).getPiece(new Coordinate(row, column));
    }

}