package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.StartController;

public class StartView extends WithConsoleView {

    public StartView(){
        super();
    }

    void interact(StartController startController) {
        MessageView.TITLE.writeln();
        new GameView().write(startController);
        startController.start();
    }
}
