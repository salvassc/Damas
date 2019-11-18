package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.Controller;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Piece;

class GameView extends SubView {

	void write(Controller controller) {
        assert controller != null;
        final int DIMENSION = controller.getDimension();
        this.writeNumbersLine(DIMENSION);
        this.writeBoard(controller,DIMENSION);
        this.writeNumbersLine(DIMENSION);
    }
    
    private void writeBoard(Controller controller, int DIMENSION){
        for(int i=0; i<DIMENSION; i++){
            this.console.write((i+1)+"");
            for(int j=0; j<DIMENSION; j++){
                Piece piece = controller.getPiece(new Coordinate(i,j));
                this.writeSquare(piece);    
            }
            this.console.writeln((i+1)+"");
        }
    }

    private void writeSquare(Piece piece){
        if(piece == null){
            this.console.write(MessageView.PIECE_COLORS[4]);
        }
        else{
            for(int p = 0; p < Piece.PIECES.length; p++){
                if(Piece.PIECES[p].getClass() == piece.getClass() && Piece.PIECES[p].getColor() == piece.getColor()){
                    this.console.write(MessageView.PIECE_COLORS[p]);
                }
            }
        }
    }

    private void writeNumbersLine(final int DIMENSION) {
        assert DIMENSION > 0;
        this.console.write(" ");
        for(int i=0; i<DIMENSION; i++){
            this.console.write((i+1)+"");
        }
        this.console.writeln();
    }

}
