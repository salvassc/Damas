package views;

import controllers.PlayController;
import controllers.ResumeController;
import controllers.StartController;

public class ConsoleView extends View {

    private StartView startView;
    private PlayView playView;
    private ResumeView resumeView;

    public ConsoleView() {
        this.startView = new StartView();
        this.playView = new PlayView();
        this.resumeView = new ResumeView();
    }

    @Override
    public void visit(StartController startController) {
        this.startView.interact(startController);

    }

    @Override
    public void visit(PlayController playController) {
        this.playView.interact(playController);

    }

    @Override
    public void visit(ResumeController resumeController) {
        this.resumeView.interact(resumeController);

    }

}