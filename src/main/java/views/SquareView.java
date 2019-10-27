package views;

import controllers.PlayController;
import utils.WithConsoleView;

public class SquareView extends WithConsoleView{

    private PlayController playController;

    SquareView(PlayController  playController){
        this.playController = playController;
    }

	public void write() {
        new PieceView(this.playController).write();
	}
}