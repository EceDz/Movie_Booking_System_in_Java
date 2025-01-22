package Assignment6;

public class TicketBooking implements Comparable<TicketBooking> {
	private int customerId;
	private  String movieName;
	private  String showDate;
	private  String showTime;
	private int ticketPrice;
	private int ticketCount;
	private String seatType;
	private String cinemaName;
	public static int totalNumOfBookings;
    
	
    public TicketBooking(int customerId,String movieName,String cinemaName, String showDate, String showTime, int ticketPrice, int ticketCount,  String seatType) {
        this.customerId=customerId;
    	this.movieName = movieName;
        this.cinemaName=cinemaName;
        this.showDate = showDate;
        this.showTime = showTime;
        this.ticketPrice = ticketPrice;
        this.ticketCount = ticketCount;
        this.seatType = seatType;
    }

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
    
    public double getTotalPrice() {   	
        String month = getShowDate().toUpperCase().split(" ")[0];       
        if (month.equals("JUNE") || month.equals("DECEMBER")){
        	 return calculateTotalPrice(2);
        }
        else {
        	return calculateTotalPrice();
        }  
    } 
    @Override
    public int compareTo(TicketBooking other) {
        return Double.compare(this.getTotalPrice(), other.getTotalPrice());
    }
    
    public void displayInfo() {
    	System.out.println("Movie Name: " + getCustomerId());
        System.out.println("Movie Name: " + getMovieName());
        System.out.println("Cinema Name: " + getCinemaName());
        System.out.println("Show Date: " + getShowDate());
        System.out.println("Show Time: " + getShowTime());
        System.out.println("Ticket Price: $" + getTicketPrice());
        System.out.println("Ticket Count: " + getTicketCount());
        System.out.println("Seat Type: " +  getSeatType());
        System.out.println("Total Price: $" + getTotalPrice());
        System.out.println("------------------------------");
    }
    
}




