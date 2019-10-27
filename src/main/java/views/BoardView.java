package views;

import controllers.Controller;
import controllers.PlayController;
import utils.WithConsoleView;

class BoardView extends WithConsoleView{

    private PlayController playController;
    private Controller controller;

    BoardView(Controller  controller){
        this.controller = controller;
    }

    void write(){
        new SquareView(this.playController).write();

    }

}