package Assignment4;

public class Premium extends TicketBooking {
    public Premium(String movieName,String cinemaName, String showDate, String showTime, int ticketCount) {
        super(movieName, cinemaName, showDate, showTime, 15, ticketCount, "better");
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


