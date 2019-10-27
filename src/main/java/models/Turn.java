package models;

import types.Color;

public class Turn{

    Color color;

    public Turn(Color color){
        this.color = color;
    }

    public Color getColor(){
        return this.color;
    }

    public void  setColor(Color color){
        this.color = color;
    }
    
}