public class Box extends TicketBooking{
    public Box(String movieName, String showDate, String showTime, int ticketCount) {
        super(movieName, showDate, showTime, 30, ticketCount, "privateBox");
    }
	
    @Override
    public int calculateTotalPrice() {
    	return super.calculateTotalPrice();
    }
    @Override
    public int calculateTotalPrice(int multiplier) {
    	return super.calculateTotalPrice(multiplier);    	
    }
    @Override
    public void displayInfo() {
        super.displayInfo(); 
    }  
}

