package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.StartController;

class StartView extends SubView {

    StartView(){
        super();
    }

    void interact(StartController startController) {
        assert startController != null;
        this.console.writeln(MessageView.TITLE.getMessage());
        new GameView().write(startController);
        startController.start();
    }

}
