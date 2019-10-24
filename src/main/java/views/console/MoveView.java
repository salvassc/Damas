package views.console;

import controllers.MoveController;

class MoveView{

    private MoveController moveController;

    MoveView(MoveController moveController){
        this.moveController = moveController;
    }

    boolean interact(){
        return true;
    }

}