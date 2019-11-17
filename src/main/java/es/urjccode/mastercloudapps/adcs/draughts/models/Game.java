package es.urjccode.mastercloudapps.adcs.draughts.models;

public class Game {

	private Board board;
	Turn turn;

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
		return this.board.getPieces(this.turn.getColor()).isEmpty() || !isPosibleMove();
	}

	private boolean isPosibleMove() {
		for(int i = 0; i < this.getDimension(); i++){
            for(int j = 0; j < this.getDimension(); j++){
                Coordinate origin = new Coordinate(i, j);
                int row = origin.getRow();
				int column = origin.getColumn();
				Piece piece = this.getPiece(origin);
				if(piece != null && this.getPiece(origin).getClass() == Men.class){
					try{
						if(this.getTurnColor() == Color.WHITE){
							if(this.isCorrect(origin, new Coordinate(row-1, column-1)) == null || this.isCorrect(origin, new Coordinate(row-1, column+1)) == null){
								return true;
							}  
						}
						else{
							if(this.isCorrect(origin, new Coordinate(row+1, column-1)) == null || this.isCorrect(origin, new Coordinate(row+1, column+1)) == null){
								return true;
							}  
						}
					} catch(IndexOutOfBoundsException e){
						
					}
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