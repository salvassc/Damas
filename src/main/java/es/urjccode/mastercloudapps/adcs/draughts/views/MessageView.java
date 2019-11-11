package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;

public enum MessageView {

    TITLE("Draughts"),
    MESSAGE_RESUME("¿Queréis jugar otra?"),
    MESSAGE_END_GAME("Derrota!!! No puedes mover tus fichas!!!"),
    MESSAGE_MOVE("Mueven las #name_color:"),
    ERROR("Error!!!"),
    CONSOLE_ERROR_STRING("de cadena de caracteres"),
    CONSOLE_ERROR_INT("entero"),
    CONSOLE_ERROR_CHARACTER("caracter"),
    CONSOLE_ERROR_FORMAT("ERROR DE FORMATO! Introduzca un valor con formato ");

    private String message;
    static final String[] NAME_COLORS = {"blancas", "negras"};
    static final String[] PIECE_COLORS = {"b", "n", " "};
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

    public String getMessage(){
        return this.message;
    }

}