package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;

enum MessageView {

    TITLE("Draughts"),
    MESSAGE_RESUME("¿Queréis jugar otra?"),
    MESSAGE_DERROTA("Derrota!!! No puedes mover tus fichas!!!");

    private String message;
    private static Console console = new Console();

    private MessageView(String message){
        this.message = message;
    }

    public void write(){
        MessageView.console.write(this.message);
    }

    public void writeln(){
        MessageView.console.writeln(this.message);
    }

    public String getMessage(){
        return this.message;
    }

}