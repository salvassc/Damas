package views;

import controllers.PlayController;
import utils.WithConsoleView;

public class PieceView extends WithConsoleView{

    private PlayController playController;

    PieceView(PlayController  playController){
        this.playController = playController;
    }

	public void write() {
        
	}
}