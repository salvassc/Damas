package models;

import types.Color;

public class Lady extends Piece{

    private boolean isLaidies;

    public Lady(Color color){
        super(color);
        this.isLaidies = true;
    }

    public boolean isLaidies(){
        return true;
    }
}