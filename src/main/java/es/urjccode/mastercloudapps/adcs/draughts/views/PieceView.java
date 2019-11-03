package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.utils.WithConsoleView;

public class PieceView extends WithConsoleView{

    private PlayController playController;

    PieceView(PlayController  playController){
        this.playController = playController;
    }

	public void write(int row, int column) {
        String color = playController.getPiece(new Coordinate(row, column)).getColor().name();
        if (color == "WHITE"){
            console.write("b");
        }else{
            console.write("n");
        }
    }
}