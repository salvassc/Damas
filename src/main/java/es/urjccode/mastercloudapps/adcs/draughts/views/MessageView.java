package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;

public enum MessageView {

    TITLE("Draughts"),
    MESSAGE_RESUME("¿Queréis jugar otra?"),
    MESSAGE_END_GAME("Derrota!!! No puedes mover tus fichas!!!"),
    MESSAGE_MOVE("Mueven las #name_color:"),
    ERROR("Error!!!");

    private String message;
    static final String[] NAME_COLORS = {"blancas", "negras"};
    public static final String[] PIECE_COLORS = {"b", "n", " "};
    private static Console console = new Console();

    private MessageView(String message){
        this.message = message;
    }

    void write(){
        MessageView.console.write(this.message);
    }

    void writeln(){
        MessageView.console.writeln(this.message);
    }

    String getMessage(){
        return this.message;
    }

}