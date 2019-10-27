package views;

import controllers.StartController;
import utils.WithConsoleView;
import views.MessageView;

class StartView extends WithConsoleView{

    void interact(StartController startController){
        this.console.writeln(MessageView.TITLE.getMessage());
        new BoardView(startController).write();
    }
}