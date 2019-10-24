package controllers;

import models.Game;

public abstract class Controller{
    protected Game game;

    Controller(Game game){
        this.game = game;
    }
}