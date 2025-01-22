package Assignment6;

public class InvalidTicketTypeException extends Exception {
	private static final long serialVersionUID = 1L;
    public InvalidTicketTypeException(String message){
        super(message);
    }
}
