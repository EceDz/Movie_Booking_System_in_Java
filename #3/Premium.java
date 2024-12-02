public class Premium extends TicketBooking {
    public Premium(String movieName, String showDate, String showTime, int ticketCount) {
        super(movieName, showDate, showTime, 15, ticketCount, "better");
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
