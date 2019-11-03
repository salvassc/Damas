package es.urjccode.mastercloudapps.adcs.draughts;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.Controller;
import es.urjccode.mastercloudapps.adcs.draughts.controllers.Logic;
import es.urjccode.mastercloudapps.adcs.draughts.views.View;
import es.urjccode.mastercloudapps.adcs.draughts.views.ConsoleView;

class Ladies {

    private Logic logic;
    private View view;
    

    protected Ladies(){
        this.logic = new Logic();
        this.view = this.createView();
    }

    private void play() {
        Controller controller;
        do{
            controller = this.logic.getController();
            if(controller != null){
                this.view.interact(controller);
            }
        }while(controller != null);
    }

    private View createView(){
        return new ConsoleView();
    }

    public static void main(String[] args) {
       new Ladies().play();
    }

    
}