package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.AcceptorController;
import es.urjccode.mastercloudapps.adcs.draughts.controllers.Controller;

public abstract class View implements AcceptorController{

    public void interact(Controller controller){
        controller.accept(this);
    }
}