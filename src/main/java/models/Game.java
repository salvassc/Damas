package models;

public class Game {

    private Board board;
    private Player playerOne,playerTwo;

    public Game(){
		board = new Board();
		playerOne = new Player();
		playerTwo = new Player();
	}   
    
    public void clear() {}

	public boolean isWinner() {
		return false;
	}

	public boolean isLooser() {
		return false;
	}

	public int getPosition() {
		return 0;
    }
	
	public boolean empty(Coordinate coordinate) {
		return board.empty(coordinate);
	}

}