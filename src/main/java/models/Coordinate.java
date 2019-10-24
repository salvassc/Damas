package models;

public class Coordinate {

    private int row;
    private int column;

    public Coordinate(int row, int column){
        this.row = row;
        this.column = column;
    }

    private int getRow(){
        return this.row;
    }

    private int getColumn(){
        return this.column;
    }
    private void setRow(int row){
        this.row = row;
	}
	
	private void setColumn(int column){
		this.column = column;
    }

    public void moveColor(Color c){}
}