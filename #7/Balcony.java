package Assignment7;

public class Balcony extends TicketBooking{
    public Balcony(int customerId,String movieName,String cinemaName, String showDate, String showTime, int ticketCount) {
        super( customerId,movieName, cinemaName, showDate, showTime, 25, ticketCount, "elevated");
    }
    @Override
    public int getTicketPrice() {
        return 25; 
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