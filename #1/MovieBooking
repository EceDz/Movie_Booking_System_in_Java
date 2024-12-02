import java.util.Scanner;

public class MovieBooking {
	private static int id = 0;
	private static String[][] Bookings = new String[5][4]; 
	private static Scanner ticketScanner = new Scanner(System.in);

	public static void main(String[] args) {
	     int choice=-1;  
	     
	     while (choice != 0) {
	    	 
	    	 displayMenu();
	    	 choice = ticketScanner.nextInt();
	    	 ticketScanner.nextLine();
	    	 
	    	 switch (choice) {
		    	 case 1:
			    	 createBooking();
			    	 break;
		    	 case 2:
			    	 displayInfo();
			    	 break;
		    	 case 3:
		    	 System.out.println("Total number of bookings made: " + id);
		    	 	break;
		    	 case 0:
			    	 System.out.println("Exiting the system. Goodbye!");
			    	 break;
		    	 default:
			    	 System.out.println("Invalid choice. Please try again.");
			    	 break;
	    	 }
	    }
	}
	
    private static void displayMenu() {
        System.out.println("\nMovie Ticket Booking System");
        System.out.println("1. Create new Ticket Booking");
        System.out.println("2. Display all booking information");
        System.out.println("3. Display the total number of tickets booked");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
}


    private static void createBooking() {
        if (id == 5) {
            System.out.println("Maximum number of bookings reached. Cannot create new booking.");
            return;
        }

        System.out.print("Enter movie name: "); 
        String movieName = ticketScanner.nextLine();

        System.out.print("Enter ticket price: "); 
        int ticketPrice = ticketScanner.nextInt();
        ticketScanner.nextLine(); 

        System.out.print("Enter number of tickets: ");
        int ticketCount = ticketScanner.nextInt();
        ticketScanner.nextLine(); 

        Bookings[id][0] = String.valueOf(id + 1); 
        Bookings[id][1] = movieName; 
        Bookings[id][2] = String.valueOf(ticketPrice);
        Bookings[id][3] = String.valueOf(ticketCount);

        id++;
        System.out.println("Booking created successfully!");
    }

    
    private static void displayInfo() {
        if (id == 0) {
            System.out.println("No bookings found.");
        }
        else {
        System.out.println("Booking Information:");   
        for (int i = 0; i < id; i++) {   	
            System.out.println("Booking ID: " + Integer.parseInt(Bookings[i][0]));
            System.out.println("Movie Name: " + Bookings[i][1]);
            System.out.println("Ticket Price: $" + Integer.parseInt(Bookings[i][2]));
            System.out.println("Number of Tickets: " + Integer.parseInt(Bookings[i][3]));
            System.out.println("Total Price: $" + calculatePrice(Integer.parseInt(Bookings[i][2]), Integer.parseInt(Bookings[i][3])));
            System.out.println("------------------------------");
        	}
        }
    }

    private static int calculatePrice(int ticketPrice, int ticketCount) {
        return ticketPrice * ticketCount;
    }
}
