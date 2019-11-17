package es.urjccode.mastercloudapps.adcs.draughts.models;

public class Piece {

	private Color color;
	private static final int MAX_DISTANCE = 2;
	public static final String[] pieceTypes = {"b","B","n","N"," "};
	public static Piece[] PIECES = new Piece[]{
		new Men(Color.WHITE),
		new King(Color.WHITE),
		new Men(Color.BLACK),
		new King(Color.BLACK),
	};

	Piece(Color color) {
		assert color != null;
		this.color = color;
	}

	Error isCorrect(Coordinate origin, Coordinate target, PieceProvider pieceProvider) {
		if (!origin.isDiagonal(target)) {
			return Error.NOT_DIAGONAL;
		}
		if (!pieceProvider.isEmpty(target)) {
			return Error.NOT_EMPTY_TARGET;
		}
		if (!this.isAdvanced(origin, target)) {
			return Error.NOT_ADVANCED;
		}
		int distance = origin.diagonalDistance(target);
		if (distance > Piece.MAX_DISTANCE) {
			return Error.BAD_DISTANCE;
		}
		if (distance == Piece.MAX_DISTANCE) {
			if (pieceProvider.getPiece(origin.betweenDiagonal(target)) == null) {
				return Error.EATING_EMPTY;
			}
		}
		return null;
	}

	boolean isLimit(Coordinate coordinate){
		return coordinate.getRow()== Board.LIMIT_INITIAL && this.getColor() == Color.WHITE ||
		coordinate.getRow()== Board.LIMIT_FINAL && this.getColor() == Color.BLACK;
	}

	boolean isAdvanced(Coordinate origin, Coordinate target) {
		assert origin != null;
		assert target != null;
		int difference = origin.getRow() - target.getRow();
		if (color == Color.WHITE) {
			return difference > 0;
		}
		return difference < 0;
	}

	public Color getColor() {
		return this.color;
	}

}