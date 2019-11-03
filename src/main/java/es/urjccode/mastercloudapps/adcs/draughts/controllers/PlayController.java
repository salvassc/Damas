package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import es.urjccode.mastercloudapps.adcs.draughts.models.Game;
import es.urjccode.mastercloudapps.adcs.draughts.models.Piece;
import es.urjccode.mastercloudapps.adcs.draughts.models.Color;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.State;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;

public class PlayController extends Controller{

	public PlayController(Game game, State state) {
		super(game,state);
	}

	public Error move(Coordinate origin, Coordinate target){
        return game.move(origin, target);
    }

	public Piece getPiece(Coordinate origin) {
		return game.getPiece(origin);
	}

	public Color getColor() {
		return null;
	}

	public Color getColorTurn(){
		return this.game.getColorTurn();
	}

	@Override
	public void accept(AcceptorController acceptorController) {
		do{
			acceptorController.visit(this);
		}while(!this.game.isWinner());

		this.state.next();
	}
}