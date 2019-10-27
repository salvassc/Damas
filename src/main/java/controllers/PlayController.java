package controllers;

import models.Coordinate;
import models.Game;
import models.Piece;
import models.State;
import types.Color;

public class PlayController extends Controller{

    public PlayController(Game game, State state){
        super(game,state);
    }

	@Override
    public void accept(AcceptorController acceptorController) {
        acceptorController.visit(this);

    }

    public Error move(Coordinate origin, Coordinate target){
        return null;
    }

    public Error move(Coordinate origin, Coordinate target, Coordinate zigzag){
        return null;
    }

    public boolean isWinner(){
        return this.game.isWinner();
    }

    public Piece getPiece(Coordinate coordinate){
        return this.game.getPiece(coordinate);
    }

    public int getPiecesWhite(){
        return this.game.getPiecesWhite();
    }

    public int getPiecesBlack(){
        return this.game.getPiecesBlack();
    }

    public int getPiecesPeons(){
        return this.game.getPiecesPeons();    
    }

    public int getPiecesLadies(){
        return this.game.getPiecesLadies();    
    }

    public boolean squareEmpty(Coordinate coordinate){
        return this.game.squareEmpty(coordinate);
    }    

    public Color getPieceColor(Coordinate coordinate){
        return this.game.getPieceColor(coordinate);
    }

}