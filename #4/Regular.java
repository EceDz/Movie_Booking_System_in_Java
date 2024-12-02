package Assignment4;

public class Regular extends TicketBooking{
    public Regular(String movieName,String cinemaName, String showDate, String showTime, int ticketCount) {
        super(movieName,cinemaName ,showDate, showTime, 10, ticketCount, "standard");
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

   