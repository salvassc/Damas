package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.utils.WithConsoleView;

public class SquareView extends WithConsoleView{

    private PlayController playController;

    SquareView(PlayController  playController){
        this.playController = playController;
    }

	public void write(int row, int column) {
        if(playController.getPiece(new Coordinate(row, column)) != null){
            new PieceView(this.playController).write(row,column);
        }else{
            console.write(" ");
        }
	}
}