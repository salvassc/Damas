package views;

import controllers.MoveController;
import controllers.ResumeController;
import controllers.StartController;

public abstract class View {

    protected StartController startController;
    protected MoveController moveController;
    protected ResumeController resumeController;

    public View(StartController startController, MoveController moveController, ResumeController resumeController){
        this.startController = startController;
        this.moveController = moveController;
        this.resumeController = resumeController;
    }

    public void interact(){}

    protected abstract void start();

    protected abstract boolean propose();

    protected abstract boolean isNewGame();
}