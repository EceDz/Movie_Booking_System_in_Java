package AssignmentV;

public class VIP extends TicketBooking{
    public VIP(int customerId, String movieName,String cinemaName, String showDate, String showTime, int ticketCount) {
        super( customerId,movieName, cinemaName, showDate, showTime, 20, ticketCount, "loungeAccess");
    }
    @Override
    public int getTicketPrice() {
        return 20; 
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
    public double getTotalPrice() {
    	return super.getTotalPrice();
    }
    @Override
    public void displayInfo() {
        super.displayInfo(); 
    }  
}

