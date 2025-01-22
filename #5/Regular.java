package AssignmentV;

public class Regular extends TicketBooking{
    public Regular(int customerId,String movieName,String cinemaName, String showDate, String showTime, int ticketCount) {
        super( customerId,movieName,cinemaName ,showDate, showTime, 10, ticketCount, "standard");
    }  
    @Override
    public int getTicketPrice() {
        return 10; 
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

   