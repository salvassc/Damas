package es.urjccode.mastercloudapps.adcs.draughts.models;

public class Piece {

	protected Color color;
	private Men men;
	private King king;
	protected static final int MAX_DISTANCE = 2;
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
		if(this instanceof King){
			return king.isCorrect(origin, target, pieceProvider);
		}
		return men.isCorrect(origin, target, pieceProvider);
	}

	boolean isLimit(Coordinate coordinate){
		return coordinate.getRow()== Board.LIMIT_INITIAL && this.getColor() == Color.WHITE ||
		coordinate.getRow()== Board.LIMIT_FINAL && this.getColor() == Color.BLACK;
	}

	boolean isAdvanced(Coordinate origin, Coordinate target) {
		if(this instanceof King){
			return king.isAdvanced(origin, target);
		}
		return men.isAdvanced(origin, target);
	}

	public Color getColor() {
		return this.color;
	}

}