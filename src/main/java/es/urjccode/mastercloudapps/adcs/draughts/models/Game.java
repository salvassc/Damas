package es.urjccode.mastercloudapps.adcs.draughts.models;

import java.util.List;

public class Game {

	private Board board;
	Turn turn;

	public Game() {
		initGame();
	}

	private void initGame(){
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

	public Game(Board board){
		this.turn = new Turn();
		this.board = board;
	}

	private Piece getInitialPiece(Coordinate coordinate) {
		assert coordinate != null;
		if (coordinate.isBlack()) {
			final int row = coordinate.getRow();
			Color color = null;
			if (row <= 2) {
				color = Color.BLACK;
			} else if (row >= 5) {
				color = Color.WHITE;
			}
			if (color != null) {
				return new Men(color);
			}
		}
		return null;
	}

	public void move(Coordinate origin, Coordinate target) {
		assert this.isCorrect(origin, target) == null;
		Color colorPiece = this.getColor(origin);
		if (origin.diagonalDistance(target) == 2) {
			this.board.remove(origin.betweenDiagonal(target));
		}
		this.board.move(origin, target);
		if (this.board.getPiece(target).isLimit(target)){
			if(board.getNumberkings(colorPiece) < King.MAX_KINGS){
				this.board.remove(target);
				this.board.put(target, new King(colorPiece));
			}
		}
		this.turn.change();
	}

	public Error isCorrect(Coordinate origin, Coordinate target){
		assert origin != null;
		assert target != null;
		if (board.isEmpty(origin)) {
			return Error.EMPTY_ORIGIN;
		}
		if (this.turn.getColor() != this.board.getColor(origin)) {
			return Error.OPPOSITE_PIECE;
		}
		return this.board.getPiece(origin).isCorrect(origin, target, board);
	}

	public Color getColor(Coordinate coordinate) {
		assert coordinate != null;
		return this.board.getColor(coordinate);
	}

	public Color getTurnColor() {
		return this.turn.getColor();
	}

	public boolean isBlocked() {
		return this.board.getPieces(this.turn.getColor()).isEmpty() || !isPosibleMovePieces();
	}

	private boolean isPosibleMovePieces(){
		List<Piece> pieces = board.getPieces(this.getTurnColor());
		for(int p = 0; p < pieces.size(); p++){
				for(int i = 0; i < board.getDimension(); i++){
					for(int j = 0; j < board.getDimension(); j++){
						Coordinate coordinate = new Coordinate(i,j);
						if(this.isPosibleMovePiece(pieces,p,coordinate)){
							return true;
						}
					}
				}
		}
		return false;
	}

	private boolean isPosibleMovePiece(List<Piece> pieces, int p, Coordinate coordinate){
		if(board.getSquare(coordinate).getColor() == this.getTurnColor()){
			if(board.getSquare(coordinate).getPiece() == pieces.get(p)){
				if(canMove(coordinate)){
					return true;
				}
			}
		}
		return false;
	}

	private boolean canMove(Coordinate origin){
		for(int i = 0; i < board.getDimension(); i++){
			for(int j = 0; j < board.getDimension(); j++){
				Coordinate target = new Coordinate(i,j);
				if(board.getPiece(origin).isCorrect(origin, target, this.board) == null){
					return true;
				}
			}
		}
		return false;
	}

	public int getDimension() {
		return this.board.getDimension();
	}

	public Piece getPiece(Coordinate coordinate) {
		assert coordinate != null;
		return this.board.getPiece(coordinate);
	}

	@Override
	public String toString() {
		return this.board + "\n" + this.turn;
	}

}