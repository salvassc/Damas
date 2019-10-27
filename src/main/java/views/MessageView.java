package views;

public enum MessageView {
	NUMBERS("12345678"),
	MOVE_BLACKS("Mueven negras:"),
	MOVE_WHITES("Mueven blancas:"),
	RESUME("Do you want to continue"),
	TITLE("----- THE LADIES -----"),
	WINNER("You've won!!! ;-)");

	private String message;
	
	private MessageView(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return this.message;
	}

}

