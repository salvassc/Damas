package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.StartController;
import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;
import es.urjccode.mastercloudapps.adcs.draughts.views.MessageView;

class StartView extends Console{

    void interact(StartController startController){
        new Console().writeln(MessageView.TITLE.getMessage());
    }
}