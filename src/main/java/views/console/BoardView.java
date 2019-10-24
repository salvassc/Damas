package views.console;

import java.util.List;

import controllers.MoveController;
import controllers.StartController;
import utils.WithConsoleView;
import models.Coordinate;

class BoardView extends WithConsoleView{

    private MoveController moveController;

    BoardView(MoveController moveController){
        this.moveController = moveController;
    }

    void write(int position){}

    List<Coordinate> read(){
        return null;
    }
}