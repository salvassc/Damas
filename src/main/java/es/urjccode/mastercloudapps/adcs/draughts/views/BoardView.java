package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.utils.WithConsoleView;
import es.urjccode.mastercloudapps.adcs.draughts.models.Board;

class BoardView extends WithConsoleView{

    private PlayController playController;

    BoardView(PlayController  playController){
        this.playController = playController;
    }

    void write(){
        writeNumbers();
        for(int i = 0; i < Board.DIMENSION; i++){
            console.write(Integer.toString(i));
            for(int j = 0; j < Board.DIMENSION; j++){
                new SquareView(this.playController).write(i,j);
            }
            console.write(Integer.toString(i));
            console.writeln();
        }
        writeNumbers();

    }

    void writeNumbers(){
        console.write(" ");
        for(int i = 0; i < Board.DIMENSION; i++){
            console.write(Integer.toString(i));
        }
        console.writeln();
    }

}