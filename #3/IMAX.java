public class IMAX extends TicketBooking{
    public IMAX(String movieName, String showDate, String showTime, int ticketCount) {
        super(movieName, showDate, showTime, 35, ticketCount, "largeFormat");
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
