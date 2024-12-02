package Assignment4;

public class TicketBooking {
	private  String movieName;
	private  String showDate;
	private  String showTime;
	private int ticketPrice;
	private int ticketCount;
	private String seatType;
	private String cinemaName;
	public static int totalNumOfBookings;
    
	
    public TicketBooking(String movieName,String cinemaName, String showDate, String showTime, int ticketPrice, int ticketCount,  String seatType) {
        this.movieName = movieName;
        this.cinemaName=cinemaName;
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
    public String getCinemaName() {
		return cinemaName;
	}

	public void setCinemaName(String cinemaName) {
		this.cinemaName = cinemaName;
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

    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public int calculateTotalPrice() {
        return getTicketPrice() * getTicketCount();
    }
    public int calculateTotalPrice(int multiplier) {
        return getTicketPrice() * getTicketCount() * multiplier;
    }
    
    public void displayInfo() {
        System.out.println("Movie Name: " + getMovieName());
        System.out.println("Cinema Name: " + getCinemaName());
        System.out.println("Show Date: " + getShowDate());
        System.out.println("Show Time: " + getShowTime());
        System.out.println("Ticket Price: $" + getTicketPrice());
        System.out.println("Ticket Count: " + getTicketCount());
        System.out.println("Seat Type: " +  getSeatType());
        
        String month = getShowDate().toUpperCase().split(" ")[0];       
        if (month.equals("JUNE") || month.equals("DECEMBER")){
        	System.out.println("Total Price: $" + calculateTotalPrice(2));
        }
        else {
        	System.out.println("Total Price: $" + calculateTotalPrice());
        }       
        System.out.println("------------------------------");
    }
    
}




