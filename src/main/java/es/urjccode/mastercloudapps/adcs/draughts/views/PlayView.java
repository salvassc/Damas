package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;

class PlayView extends Console{
    
    void interact(PlayController playController) {
        new BoardView(playController).write();
        new CommandView(playController).interact();
    }

}