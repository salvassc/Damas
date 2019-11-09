package es.urjccode.mastercloudapps.adcs.draughts.controllers;

import es.urjccode.mastercloudapps.adcs.draughts.models.Color;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;
import es.urjccode.mastercloudapps.adcs.draughts.models.Piece;
import es.urjccode.mastercloudapps.adcs.draughts.models.State;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import es.urjccode.mastercloudapps.adcs.draughts.models.Game;

public class PlayController extends Controller {

    public PlayController(Game game, State state) {
		super(game,state);
	}

	public Error checkMovements(Coordinate origin, Coordinate target){
		if(!origin.isValid() || !target.isValid()){
			return Error.OUT_COORDINATE;
		}
		if(game.isEmptyMove(origin)){
			return Error.EMPTY_ORIGIN;
		}
		if(!game.getColorMove(origin)){
			return Error.OPPOSITE_PIECE;
		}
		if (!origin.isDiagonal(target)) {
			return Error.NOT_DIAGONAL;
		}
		if (origin.diagonalDistance(target) >= 3) {
			return Error.BAD_DISTANCE;
		}
		if (!game.isEmptyMove(target)) {
			return Error.NOT_EMPTY_TARGET;
		}
		if (!game.isAdvancedMove(origin,target)) {
			return Error.NOT_ADVANCED;
		}
		if (!game.isBetweenDiagonalMove(origin, target)){
			return Error.EATING_EMPTY;
		}
		return null;
	}

	public Error move(Coordinate origin, Coordinate target){
		Error error = this.game.move(origin, target);
		if (this.game.isBlocked()){
			this.state.next();
		}
		return error;
    }

	Piece getPiece(Coordinate coordinate) {
		return game.getPiece(coordinate);
	}

	public Color getColor() {
		return game.getColor();
	}
	
	public boolean isBlocked() {
		return game.isBlocked();
	}

	@Override
	public void accept(ControllersVisitor controllersVisitor) {
		controllersVisitor.visit(this);
	}

}