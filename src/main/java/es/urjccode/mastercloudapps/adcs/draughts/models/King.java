package es.urjccode.mastercloudapps.adcs.draughts.models;

public class King extends Piece {

    static final int MAX_KINGS = 2;

    public King(Color color) {
        super(color);
    }

    @Override
    public Error isCorrect(Coordinate origin, Coordinate target, PieceProvider pieceProvider){
        if (!origin.isDiagonal(target)) {
			return Error.NOT_DIAGONAL;
		}
		if (!pieceProvider.isEmpty(target)) {
			return Error.NOT_EMPTY_TARGET;
		}
		if (!this.isAdvanced(origin, target)) {
			return Error.NOT_ADVANCED;
		}
		return null;
    }

    @Override
    public boolean isAdvanced(Coordinate origin, Coordinate target){
        assert origin != null;
		assert target != null;
		return true;
    }

}