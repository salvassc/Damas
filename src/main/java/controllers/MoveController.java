package controllers;

import models.Game;

public class MoveController extends Controller{

    public MoveController(Game game){
        super(game);
    }

    public boolean isWinner() {
		return this.game.isWinner();
	}

	public boolean isLooser() {
		return this.game.isLooser();
    }
    
    public int getPosition(){
        return this.game.getPosition();
    }
}