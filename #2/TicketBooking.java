public class TicketBooking {
	private  String movieName;
	private  String showDate;
	private  String showTime;
	private int ticketPrice;
	private int ticketCount;
    private SeatType seatType; 
    
    public enum SeatType {
        REGULAR, PREMIUM, VIP;
    }
	
    public TicketBooking(String movieName, String showDate, String showTime, int ticketPrice, int ticketCount, SeatType seatType) {
        this.movieName = movieName;
        this.showDate = showDate;
        this.showTime = showTime;
        this.ticketPrice = ticketPrice;
        this.ticketCount = ticketCount;
        this.seatType = seatType;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }
    
    public String getSeatTypePrint() {
        switch (seatType) {
            case REGULAR:
                return "Regular";
            case PREMIUM:
                return "Premium";
            case VIP:
                return "VIP";
            default:
                return "Unknown Type";
        }
    }

    public int calculateTotalPrice() {
        return ticketPrice * ticketCount;
    }
    
    public void displayInfo() {
        System.out.println("Movie Name: " + getMovieName());
        System.out.println("Show Date: " + getShowDate());
        System.out.println("Show Time: " + getShowTime());
        System.out.println("Ticket Price: $" + getTicketPrice());
        System.out.println("Ticket Count: " + getTicketCount());
        System.out.println("Seat Type: " + getSeatTypePrint());
        System.out.println("Total Price: $" + calculateTotalPrice());
        System.out.println("------------------------------");
    }
    
}

	


