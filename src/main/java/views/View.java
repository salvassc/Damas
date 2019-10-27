package views;

import controllers.AcceptorController;
import controllers.Controller;

public abstract class View implements AcceptorController{

    public void interact(Controller controller){
        controller.accept(this);
    }
}