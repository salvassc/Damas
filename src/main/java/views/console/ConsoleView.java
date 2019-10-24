package views.console;

import controllers.MoveController;
import controllers.ResumeController;
import controllers.StartController;
import views.View;

public class ConsoleView extends View{

    private StartView startView;
    private MoveView moveView;
    private ResumeView resumeView;

    public ConsoleView(StartController startController, MoveController moveController, ResumeController resumeController){
        super(startController,moveController,resumeController);
        this.startView = new StartView(this.startController);
        this.moveView = new MoveView(this.moveController);
        this.resumeView = new ResumeView(this.resumeController);
    }

    @Override
    protected void start() {
        this.startView.interact();
    }

    @Override
    protected boolean propose() {
        new BoardView(moveController);
        return this.moveView.interact();
    }

    @Override
    protected boolean isNewGame() {
        return this.resumeView.interact();
    }


}