package Assignment4;

public class Balcony extends TicketBooking{
    public Balcony(String movieName,String cinemaName, String showDate, String showTime, int ticketCount) {
        super(movieName, cinemaName, showDate, showTime, 25, ticketCount, "elevated");
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