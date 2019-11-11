package es.urjccode.mastercloudapps.adcs.draughts.models;

public class Piece {

	private Color color;

	Piece(Color color){
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}

	public boolean isAdvanced(Coordinate origin, Coordinate target) {
		int difference = getDifferenceRow(origin,target);
		if (color == Color.WHITE){
			return difference>0;
		}
		return difference<0;
	}

	private int getDifferenceRow(Coordinate origin, Coordinate target){
		return origin.getRow() - target.getRow();
	} 

}