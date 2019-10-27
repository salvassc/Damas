package models;

public class Square{

    Piece piece;

    public Square(){

    }

    public Square(Piece piece){
        this.piece = piece;
    }

    public boolean isEmpty(){
        return true;
    }

    public Piece getPiece(){
        return this.piece.getPiece();
    }


}