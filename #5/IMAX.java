package AssignmentV;

public class IMAX extends TicketBooking{
    public IMAX(int customerId, String movieName, String cinemaName, String showDate, String showTime, int ticketCount) {
        super( customerId,movieName, cinemaName, showDate, showTime, 35, ticketCount, "largeFormat");
    }
    @Override
    public int getTicketPrice() {
        return 35; 
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
