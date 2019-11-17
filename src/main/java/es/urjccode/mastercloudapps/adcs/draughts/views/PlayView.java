package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;

class PlayView extends SubView {

    private static final String FORMAT = "xx.xx";

    PlayView() {
        super();
    }

    void interact(PlayController playController) {
        assert playController != null;
        Coordinate origin = null;
        Coordinate target = null;
        Error error;
        GameView gameView = new GameView();
        do {
            error = null;
            String color = MessageView.NAME_COLORS[playController.getColor().ordinal()];
            String format = this.console.readString("Mueven las " + color + ": ");
            if (format.length() != PlayView.FORMAT.length()) {
                error = Error.BAD_FORMAT;
                this.console.writeln(MessageView.ERROR.getMessage() + error.name());
            } else {
                origin = Coordinate.getInstance(format.substring(0, 2));
                target = Coordinate.getInstance(format.substring(3, 5));
                if (origin == null || target == null) {
                    error = Error.BAD_FORMAT;
                    this.console.writeln(MessageView.ERROR.getMessage() + error.name());
                } 
            }
        } while (error != null);
        error = playController.isCorrect(origin, target);
        if (error == null){
            playController.move(origin, target);
            gameView.write(playController);
            if (playController.isBlocked()){
                this.console.writeln(MessageView.MESSAGE_END_GAME.getMessage());
            }
        }
        else{
            this.console.writeln(MessageView.ERROR.getMessage() + error.name());
        }
    }

}