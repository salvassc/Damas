package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;

public class PlayView extends WithConsoleView {

    public PlayView(){
        super();
    }

    void interact(PlayController playController) {
        String color = MessageView.NAME_COLORS[playController.getColor().ordinal()];
        Error error = null;
        GameView gameView = new GameView();
        String[] numbers;
        do {
            String command = this.console.readString("Mueven las " + color + ": ");
            numbers = command.split("\\.|\\n");
            error = playController.checkMovements(new Coordinate(numbers[0]), new Coordinate(numbers[1]));
            if (error != null){
                console.writeln(MessageView.ERROR.getMessage() + error.name());
            }
        } while (error != null);
            playController.move(new Coordinate(numbers[0]), new Coordinate(numbers[1]));
            gameView.write(playController);
         
        if (playController.isBlocked()){
            this.console.write(MessageView.MESSAGE_END_GAME.getMessage());
        }
    }

}