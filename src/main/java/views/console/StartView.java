package views.console;

import controllers.StartController;
import utils.WithConsoleView;
import views.MessageView;

class StartView extends WithConsoleView{
    private StartController startController;

    StartView(StartController startController){
        this.startController = startController;

    }

    void interact(){
        this.console.writeln(MessageView.TITLE.getMessage());
    }
}