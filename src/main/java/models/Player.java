package models;

public class Player {

    int numTokens;

    Player(){
        numTokens = 12;
    }

    public int getToken(){
        return numTokens;
    }

    public void setNumTokens(int numTokens){
        this.numTokens = numTokens;
    }

}