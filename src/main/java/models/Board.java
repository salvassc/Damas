package models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Board {

    private Map<Color, Set<Coordinate>> coordinates;

    Board(){
        coordinates = new HashMap<>();
        for (int i = 0; i < Color.values().length-1;i++){
            coordinates.put(Color.values()[i], new HashSet<>());
        }
    }

    private Color getColor(Coordinate coordinate){
        return Color.NONE;
    }

    private boolean existColor(Color color){
        return true;
    }

    private void put(Coordinate coordinate, Color color){}

    private void remove(Coordinate coordinate, Color color){}

    private void clear(){}

	public boolean empty(Coordinate coordinate) {
		return false;
	}
}