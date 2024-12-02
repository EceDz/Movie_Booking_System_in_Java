public class VIP extends TicketBooking{
    public VIP(String movieName, String showDate, String showTime, int ticketCount) {
        super(movieName, showDate, showTime, 20, ticketCount, "loungeAccess");
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
