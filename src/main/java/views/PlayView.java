package views;

import controllers.PlayController;
import utils.WithConsoleView;

class PlayView extends WithConsoleView{
    
    boolean interact(PlayController playController) {
        new BoardView(playController);
        return true;
    }

}