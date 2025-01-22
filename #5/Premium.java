package AssignmentV;

public class Premium extends TicketBooking {
    public Premium(int customerId,String movieName,String cinemaName, String showDate, String showTime, int ticketCount) {
        super( customerId,movieName, cinemaName, showDate, showTime, 15, ticketCount, "better");
    }
    @Override
    public int getTicketPrice() {
        return 15; 
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


