import controllers.MoveController;
import controllers.ResumeController;
import controllers.StartController;
import models.Game;
import views.View;
import views.console.ConsoleView;

class Ladies {

    private Game game;
    private View view;
    private StartController startController;
    private MoveController moveController;
    private ResumeController resumeController;

    protected Ladies(){
        this.game = new Game();
        this.startController = new StartController(this.game);
        this.moveController = new MoveController(this.game);
        this.resumeController = new ResumeController(this.game);
        this.view = this.createView(this.startController, this.moveController, this.resumeController);
    }

    private void play() {
        this.view.interact();
    }

    private View createView(StartController startController, MoveController moveController, ResumeController resumeController){
        return new ConsoleView(startController, moveController, resumeController);
    }

    public static void main(String[] args) {
        new Ladies().play();
    }

    
}