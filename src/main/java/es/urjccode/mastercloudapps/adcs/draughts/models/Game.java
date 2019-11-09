package es.urjccode.mastercloudapps.adcs.draughts.models;

import java.util.List;

public class Game {

	private Board board;
	private Turn turn;

	public Game() {
		this.turn = new Turn();
		this.board = new Board();
		for (int i = 0; i < this.board.getDimension(); i++) {
			for (int j = 0; j < this.board.getDimension(); j++) {
				Coordinate coordinate = new Coordinate(i, j);
				Piece piece = this.getInitialPiece(coordinate);
				if (piece != null) {
					this.board.put(coordinate, piece);
				}
			}
		}
	}

	private Piece getInitialPiece(Coordinate coordinate) {
		if (coordinate.isBlack()) {
			final int row = coordinate.getRow();
			if (row <= 2) {
				return new Piece(Color.BLACK);
			}
			if (row >= 5) {
				return new Piece(Color.WHITE);
			}
		}
		return null;
	}

	//Refactorizar este método
	public Error move(Coordinate origin, Coordinate target) {
		assert origin != null && target != null;
		Piece piece = this.board.getPiece(origin);
		if (!piece.isAdvanced(origin, target)) {
			return Error.NOT_ADVANCED;
		}
		if (!this.board.isEmpty(target)) {
			return Error.NOT_EMPTY_TARGET;
		}
		if (origin.diagonalDistance(target) == 2) {
			Coordinate between = origin.betweenDiagonal(target);
			if (this.board.getPiece(between) == null) {
				return Error.EATING_EMPTY;
			}
			this.board.remove(between);
		}
		this.board.move(origin, target);
		this.turn.change();
		return null;
	}

	public  boolean isValidMove(Coordinate origin, Coordinate target){
		if(!origin.isValid() || !target.isValid()){
			return false;
		}
		return true;
	}

	public boolean isEmptyMove(Coordinate origin){
		return board.isEmpty(origin);
	}

	public boolean getColorMove(Coordinate origin){
		Color color = this.board.getColor(origin);
		if (this.turn.getColor() != color) {
			return false;
		}
		return true;
	}

	public Color getColor(Coordinate coordinate) {
		return this.board.getColor(coordinate);
	}

	public Color getColor() {
		return this.turn.getColor();
	}

	public Piece getPiece(Coordinate coordinate) {
		return this.board.getPiece(coordinate);
	}

	public boolean isBlocked() {
		return this.board.getPieces(this.turn.getColor()).isEmpty();
	}

	public int getDimension() {
		return this.board.getDimension();
	}

	List<Piece> getPieces(Color color) {
		return board.getPieces(color);
	}

}