package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.Controller;
import es.urjccode.mastercloudapps.adcs.draughts.models.Color;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;

public class GameView extends WithConsoleView {

	void write(Controller controller) {
        final int DIMENSION = controller.getDimension();
        this.writeNumbersLine(DIMENSION);
        for(int i=0; i<DIMENSION; i++){
            this.console.write((i+1)+"");
            for(int j=0; j<DIMENSION; j++){
                Color color = controller.getColor(new Coordinate(i,j));
                if (color == null){
                    this.console.write(MessageView.PIECE_COLORS[2]);
                } else {
                    this.console.write(MessageView.PIECE_COLORS[color.ordinal()]);
                }
            }
            this.console.writeln((i+1)+"");
        }
        this.writeNumbersLine(DIMENSION);
	}

    private void writeNumbersLine(final int DIMENSION) {
        this.console.write(" ");
        for(int i=0; i<DIMENSION; i++){
            this.console.write((i+1)+"");
        }
        this.console.writeln();
    }

}
