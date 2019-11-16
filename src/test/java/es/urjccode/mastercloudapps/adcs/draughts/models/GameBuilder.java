package es.urjccode.mastercloudapps.adcs.draughts.models;

import java.util.ArrayList;
import java.util.List;

class GameBuilder {

    private List<String> strings;

    GameBuilder(){
        this.strings = new ArrayList<String>();
    }

	GameBuilder row(String string) {
        this.strings.add(string);
        return this;
	}

	Game build() {
        char[] character_pieces = {'b', 'B', 'n', 'N'};
        Piece[] pieces = {new Men(Color.WHITE), new King(Color.WHITE), new Men(Color.BLACK), new King(Color.BLACK)};
        Board board = new Board();
        for(int i = 0; i < this.strings.size(); i++){
            for(int j = 0; j < this.strings.get(i).length(); j++){
                char character = this.strings.get(i).charAt(j);
                for(int num = 0; num < character_pieces.length; num++){
                    if(character_pieces[num] == character){
                        board.put(new Coordinate(i,j), pieces[num]);
                    }
                }
            }
        }
		return new Game(board);
	}

}