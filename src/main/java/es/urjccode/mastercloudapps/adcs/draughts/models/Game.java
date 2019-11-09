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

	public void move(Coordinate origin, Coordinate target) {
		assert origin != null && target != null;
		this.board.move(origin, target);
		this.turn.change();
	}

	public boolean isEmptyMove(Coordinate coordinate){
		return board.isEmpty(coordinate);
	}

	public boolean isBetweenDiagonalMove(Coordinate origin, Coordinate target){
		if (origin.diagonalDistance(target) == 2) {
			Coordinate between = origin.betweenDiagonal(target);
			if (this.board.getPiece(between) == null) {
				return false;
			}
			this.board.remove(between);
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