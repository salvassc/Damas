package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.Controller;
import es.urjccode.mastercloudapps.adcs.draughts.models.Color;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;

public class GameView extends WithConsoleView {

	void write(Controller controller) {
        final int DIMENSION = controller.getDimension();
        this.writeNumbersLine(DIMENSION);
        this.writeBoard(controller,DIMENSION);
        this.writeNumbersLine(DIMENSION);
    }

    private void writeBoard(Controller controller, int DIMENSION){
        for(int i=0; i<DIMENSION; i++){
            this.console.write((i+1)+"");
            for(int j=0; j<DIMENSION; j++){
                this.writeSquare(controller, new Coordinate(i, j));    
            }
            this.console.writeln((i+1)+"");
        }
    }
    
    private void writeSquare(Controller controller, Coordinate coordinate){
        Color color = controller.getColor(coordinate);
        if (color == null){
            this.console.write(MessageView.PIECE_COLORS[2]);
        } else {
            this.console.write(MessageView.PIECE_COLORS[color.ordinal()]);
        }
    }

    private void writeNumbersLine(final int DIMENSION) {
        this.console.write(" ");
        for(int i=0; i<DIMENSION; i++){
            this.console.write((i+1)+"");
        }
        this.console.writeln();
    }

}
