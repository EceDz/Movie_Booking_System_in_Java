import java.util.Scanner;

public class TicketBookingSystem {
    public static void main(String[] args) {
        Scanner ticketScanner = new Scanner(System.in);
        TicketBooking[] Bookings = new TicketBooking[5];
        int bookingCount = 0;

        while (true) {       	
            System.out.println("\nMovie Ticket Booking System");
            System.out.println("1. Create new Ticket Booking");
            System.out.println("2. Display all Ticket Bookings");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = ticketScanner.nextInt();
            ticketScanner.nextLine(); 

            switch (choice) {
                case 1: 
                    if (bookingCount >= Bookings.length) {
                        System.out.println("No more bookings can be added!");
                        break;
                    }

                    System.out.print("Enter movie name: ");
                    String movieName = ticketScanner.nextLine();

                    System.out.print("Enter show date (YYYY-MM-DD): ");
                    String showDate = ticketScanner.nextLine();

                    System.out.print("Enter show time (HH:MM): ");
                    String showTime = ticketScanner.nextLine();

                    System.out.print("Enter ticket price: ");
                    int ticketPrice = ticketScanner.nextInt();
                    ticketScanner.nextLine(); 

                    System.out.print("Enter number of tickets: ");
                    int ticketCount = ticketScanner.nextInt();
                    ticketScanner.nextLine(); 

                    TicketBooking.SeatType seatType = null;                   
                    while (seatType == null) {
                        System.out.print("Select seat type (Regular, Premium, VIP): ");
                        String seatTypeChoice = ticketScanner.nextLine().toUpperCase();
                                                         
                        switch (seatTypeChoice) {
                        case "REGULAR":
                            seatType = TicketBooking.SeatType.REGULAR;
                            break;
                        case "PREMIUM":
                            seatType = TicketBooking.SeatType.PREMIUM;
                            break;
                        case "VIP":
                            seatType = TicketBooking.SeatType.VIP;
                            break;
                        default:
                            System.out.println("\nInvalid seat type! Please choose Regular, Premium, or VIP.");
                            break;
                        }
                    }
                            
                    Bookings[bookingCount] = new TicketBooking(movieName, showDate, showTime, ticketPrice, ticketCount, seatType);
                    bookingCount++;
                    System.out.println("Booking created successfully!");
                    break;


                case 2: 
                    if (bookingCount == 0) {
                        System.out.println("\nNo bookings available to display.");
                    } else {
                        System.out.println("\nTicket Booking Information:");
                        for (int i = 0; i < bookingCount; i++) {
                            Bookings[i].displayInfo();
                        }
                    }
                    break;

                case 0: 
                    System.out.println("\nExiting the system. Goodbye!");
                    ticketScanner.close();
                    return;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }
}




