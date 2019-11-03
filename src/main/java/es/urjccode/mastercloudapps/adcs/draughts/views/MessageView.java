package es.urjccode.mastercloudapps.adcs.draughts.views;

public enum MessageView {
	NUMBERS("12345678"),
	MOVE_BLACKS("Mueven negras:"),
	MOVE_WHITES("Mueven blancas:"),
	RESUME("Do you want to continue"),
	TITLE("Las Damas!!!"),
	WINNER("You've won!!! ;-)");

	private String message;
	
	private MessageView(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}

}

