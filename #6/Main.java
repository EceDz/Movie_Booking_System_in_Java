package Assignment6;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) throws InvalidTicketTypeException {
        Scanner ticketScanner = new Scanner(System.in);
        ArrayList<Customer> CustomerList= new ArrayList<Customer>();	
        TicketBooking.totalNumOfBookings=0;
        TicketBooking[] Bookings = new TicketBooking[3];
        ArrayList<TicketBooking> BookingList= new ArrayList<TicketBooking>();			        
        int choice;		        
		while (true) {
		      while(true) {
			        System.out.println("\nMovie Ticket Booking System");
		            MenuOptions.displayMenu();
		            System.out.print("Enter your choice (1-11): ");
		            
		            if (ticketScanner.hasNextInt()) {  
		                choice = ticketScanner.nextInt();
		                ticketScanner.nextLine(); 

		                if (choice >= 1 && choice <= 11) {
		                    break;  
		                } 
		                else {
		                    System.out.println("\nInvalid choice. Please enter a number between 1 and 7.");
		                }
		            } 
		            else {
		                System.out.println("\nInvalid choice. Please enter a integer.");
		                ticketScanner.nextLine(); 
		            }
		        }	        
				switch (choice) {
				
	            	case 1: //Add a new customer to the system.
	            		while(true) {
		            		System.out.println("Select Customer Type:");
	            			System.out.println("1. Regular Customer");
	            			System.out.println("2. Loyalty Member");	
	            			System.out.println("3. Corporate Client ");
	            			System.out.print("Enter your choice: ");	            			
	            			int customerChoice;	            			
				            if (ticketScanner.hasNextInt()) {  
				            	customerChoice = ticketScanner.nextInt();
				                ticketScanner.nextLine(); 
					            		
				                if (customerChoice >= 1 && customerChoice <= 3) {	
				                	Customer customer = null;
				            	    String customerName=getCustomerName(ticketScanner);
				            	    String customerEmail=getCustomerEmail(ticketScanner);	
				                	
				                	if(customerChoice==1) {
				            	    customer = new RegularCustomer(CustomerList.size() + 1, customerName,customerEmail);	
				                	}
				                	else if(customerChoice==2) {
				            	    customer = new LoyaltyMember(CustomerList.size() + 1, customerName,customerEmail);
				                	}
				                	else if(customerChoice==3) {
				                	customer = new CorporateClient(CustomerList.size() + 1, customerName,customerEmail);
				                	}	
				                	CustomerList.add(customer);				                	
				                	System.out.print("Customer added successfully!\n ");
				                	break;
				                } 
				                else {
				                    System.out.println("\nInvalid choice. Please enter a number between 1 and 3.");
				                }
				            } 
				            else {
				                System.out.println("\nInvalid choice. Please enter a integer.");
				                ticketScanner.nextLine(); 
				            }
		            	}
	            		break;
	                
	                case 2: //Create a new ticket booking associated with a specific customer    		                	                    
	                    try {	                    
		                    int customerId = getCustomerId(ticketScanner, CustomerList);
		                	String movieName = getUserMovieName(ticketScanner);
		                    String cinemaName = getUserCinemaName(ticketScanner);
		                    String showDate = getUserShowDate(ticketScanner);
		                    String showTime = getUserShowTime(ticketScanner);
		                    int ticketCount=getUserTicketCount(ticketScanner);		                    
		                    Regular regular = new Regular(customerId, movieName, cinemaName, showDate, showTime, ticketCount);
		                    
		                    if (TicketBooking.totalNumOfBookings < Bookings.length) {	        	        
		                    Bookings[TicketBooking.totalNumOfBookings] = regular;                    
			                }        	        
			        	    else {
			        	        if (BookingList.size() <= Bookings.length) {
			        	        	BookingList.clear(); 
			        	            BookingList.addAll(Arrays.asList(Bookings));
			        	        }
			                    BookingList.add(regular);
			        	    }
		                    TicketBooking.totalNumOfBookings++;
		                    System.out.println("Booking created successfully!");
		                    double originalCost = regular.getTotalPrice();
		                    System.out.println("Original Cost: " + originalCost );	
		                    	 
		                    Customer customer = getCustomerById(customerId, CustomerList);
		                     if (customer == null) {
		                         throw new InvalidCustomerException("");
		                     }
			                    if (customer instanceof RegularCustomer) {
			                        RegularCustomer regularCustomer = (RegularCustomer) customer;
			                        System.out.println("Discounted Cost: " + regularCustomer.calculateDiscountedPrice(originalCost));
			                    } 
			                    else if (customer instanceof LoyaltyMember) {
			                        LoyaltyMember loyaltyCustomer = (LoyaltyMember) customer;
			                        System.out.println("Discounted Cost: " + loyaltyCustomer.calculateDiscountedPrice(originalCost));
			                    } 
			                    else if (customer instanceof CorporateClient) {
			                        CorporateClient corporateClient = (CorporateClient) customer;
			                        System.out.println("Discounted Cost: " + corporateClient.calculateDiscountedPrice(originalCost));
			                    }
		                }
	                    catch (InvalidCustomerException e) {
			                        System.err.println("Error:" + e.getMessage());
			            }
	                    break;
		                
                case 3: //Create a new ticket booking with a user-specified ticket type.   
                	try {
                		System.out.print("Enter ticket type (Regular, Premium, VIP, Balcony, Box, IMAX): ");
                		String seatType = ticketScanner.nextLine().toUpperCase();	                    
                    	        if (!seatType.equals("REGULAR") && !seatType.equals("PREMIUM") && !seatType.equals("VIP") &&
                    	            !seatType.equals("BALCONY") && !seatType.equals("BOX") && !seatType.equals("IMAX")) {
                    	        	throw new InvalidTicketTypeException("Invalid ticket type: " + seatType);
                    	        }
	                    int customerId = getCustomerId(ticketScanner,CustomerList);	
	                	String movieName = getUserMovieName(ticketScanner);
	                    String cinemaName = getUserCinemaName(ticketScanner);
	                    String showDate = getUserShowDate(ticketScanner);
	                    String showTime = getUserShowTime(ticketScanner);
	                    int ticketCount = getUserTicketCount(ticketScanner);
	                    
	                    TicketBooking booking = null;
	                    if (seatType.equals("REGULAR")) {
	                        booking = new Regular(customerId, movieName, cinemaName, showDate, showTime, ticketCount);
	                    } 
	                    else if (seatType.equals("PREMIUM")) {
	                        booking = new Premium(customerId, movieName, cinemaName, showDate, showTime, ticketCount);
	                    } 
	                    else if (seatType.equals("VIP")) {
	                        booking = new VIP(customerId, movieName, cinemaName, showDate, showTime, ticketCount);
	                    } 
	                    else if (seatType.equals("BALCONY")) {
	                        booking = new Balcony(customerId, movieName, cinemaName, showDate, showTime, ticketCount);
	                    } 
	                    else if (seatType.equals("BOX")) {
	                        booking = new Box(customerId, movieName, cinemaName, showDate, showTime, ticketCount);
	                    } 
	                    else if (seatType.equals("IMAX")) {
	                        booking = new IMAX(customerId, movieName, cinemaName, showDate, showTime, ticketCount);
	                    }
	
	                    if (TicketBooking.totalNumOfBookings < Bookings.length) {	        	        
	                    Bookings[TicketBooking.totalNumOfBookings] = booking;                    
		                }        	        
		        	    else {
		        	        if (BookingList.size() <= Bookings.length) {
		        	        	BookingList.clear(); 
		        	            BookingList.addAll(Arrays.asList(Bookings));
		        	        }
		                    BookingList.add(booking);
		        	    }
	                    TicketBooking.totalNumOfBookings++;
	                    System.out.println("Booking created successfully!");                    
	                    double originalCost = booking.getTotalPrice();
	                    System.out.println("Original Cost: " + originalCost);
	
	                     Customer customer = getCustomerById(customerId, CustomerList);
	                     if (customer == null) {
	                         throw new InvalidCustomerException("");
	                     }
	                	    if (customer instanceof RegularCustomer) {
	                	        RegularCustomer regularCustomer = (RegularCustomer) customer;
	                	        System.out.println("Discounted Cost: " + regularCustomer.calculateDiscountedPrice(originalCost));
	                	    } 
	                	    else if (customer instanceof LoyaltyMember) {
	                	        LoyaltyMember loyaltyCustomer = (LoyaltyMember) customer;
	                	        System.out.println("Discounted Cost: " + loyaltyCustomer.calculateDiscountedPrice(originalCost));
	                	    } 
	                	    else if (customer instanceof CorporateClient) {
	                	        CorporateClient corporateClient = (CorporateClient) customer;
	                	        System.out.println("Discounted Cost: " + corporateClient.calculateDiscountedPrice(originalCost));                 	    
	                	    }
                		}
                		catch (InvalidTicketTypeException e) {
                			System.err.println("Error: " + e.getMessage());
						        
						} 
                		catch (InvalidCustomerException e) {
						    System.err.println("Error: " + e.getMessage());
						 }
						break;	
                    
                	case 4: //4. Display all Ticket Bookings
	                	if (TicketBooking.totalNumOfBookings <=0) {
	                        System.out.println("\nNo bookings available to display.");
	                	}
	                    else {
	                        System.out.println("\nTicket Booking Information:");

	                        for (int i = 0; i <TicketBooking.totalNumOfBookings; i++) {
	                        	TicketBooking bookings;		                        	
	                            if (i < Bookings.length) {
	                                bookings = Bookings[i];
	                                bookings.displayInfo();		                                
	                            } 
	                            else{
	                                bookings = BookingList.get(i);
	                                bookings.displayInfo();
	                            }
	                        }	                    
	                    }
	                	break;
	                	                   	                    
	                case 5: //Display the total number of bookings made so far.
	                	System.out.println("\nTotal number of bookings:" + TicketBooking.totalNumOfBookings);	                	
	                	break;
	                	
	                case 6: // List all bookings for a specific cinema.
	                    if (TicketBooking.totalNumOfBookings <= 0) {
	                        System.out.println("\nNo bookings available.");
	                        break;
	                    }
	        	        if (BookingList.size() <= Bookings.length) {
	        	        	BookingList.clear(); 
	        	        	BookingList.addAll(Arrays.asList(Bookings));
	        	        }
	                    String userCinema = getUserCinemaName(ticketScanner);		                    
	                    Iterator<TicketBooking> iterator = BookingList.iterator();
	                    int cinemaCount = 0;

	                    while (iterator.hasNext()) {
	                        TicketBooking iteratorbooking = iterator.next();
	                        if (iteratorbooking != null && iteratorbooking.getCinemaName().equals(userCinema)) {
	                        	cinemaCount ++;
	                        	System.out.printf("\n%d. booking for %s.\n", cinemaCount, userCinema);
	                        	iteratorbooking.displayInfo();	
	                        }	                        
	                    }
                    	if(cinemaCount==0) {
                    		System.out.printf("\nNo bookings found for %s.\n", userCinema);
                    	}
	                    break;

	                case 7: // Remove all bookings for a specific cinema.
	                    if (TicketBooking.totalNumOfBookings <= 0) {
	                        System.out.println("\nNo bookings available.");
	                        break;
	                    }
	                    if (BookingList.size() <= Bookings.length) {
	        	        	BookingList.clear(); 
	        	        	BookingList.addAll(Arrays.asList(Bookings));
	        	        }
	                    String removeCinema = getUserCinemaName(ticketScanner);
	                    Iterator<TicketBooking> removeIterator = BookingList.iterator();
	                    removeIterator = BookingList.iterator();
	                    int removeCount = 0;

	                    while (removeIterator.hasNext()) {
	                        TicketBooking iteratorbooking = removeIterator.next();
	                        if (iteratorbooking != null && iteratorbooking.getCinemaName().equals(removeCinema)) {
	                        	removeIterator.remove();
	                        	removeCount++;		                        	
	                        }
	                    }		                    
	                    TicketBooking.totalNumOfBookings -= removeCount;
	                    
	                    if (removeCount>0) {
	                    	System.out.printf("\n%d booking(s) for %s removed.\n", removeCount, removeCinema);
	                        Bookings = BookingList.toArray(new TicketBooking[0]);
	                        
	                    }
	                    else {
	                        System.out.printf("\nNo bookings found for %s.\n", removeCinema);
	                        System.out.println("Enter cinema name: ");
	                        removeCinema = ticketScanner.nextLine().trim();
	                    }
	                    break;
	                    
	                case 8: //Display all customers and their information.
	                	if (CustomerList.size() <=0) {
	                        System.out.println("\nNo Customer available to display.");
	                        break;
	                	}
	                    else {
	                        System.out.println("\nCustomer Information:");
	        		        for (Customer customers : CustomerList) {
	        		        	customers.displayInfo();
	        		        }
	                    }
	                    break;
	                    
	                case 9: // Sort Customers by Name
	                    if (CustomerList.isEmpty()) {
	                        System.out.println("\nNo customers available to sort.");
	                        break;
	                    }	                    
	                    Collections.sort(CustomerList, new CustomerNameComparator());
	                    
	                    System.out.println("\nCustomers sorted by name:");
	                    for (Customer customer : CustomerList) {
	                        customer.displayInfo();
	                    }
	                    break;

	                case 10: // Sort Bookings by Total Cost
	                    if (TicketBooking.totalNumOfBookings <= 0) {
	                        System.out.println("\nNo bookings available to sort.");
	                        break;
	                    }
	                    
	                    BookingList.clear();
	                    for (int i = 0; i < TicketBooking.totalNumOfBookings; i++) {
	                        if (Bookings[i] != null) {
	                            BookingList.add(Bookings[i]);
	                        }
	                    }

	                    if (BookingList.isEmpty()) {
	                        System.out.println("\nNo valid bookings to sort.");
	                        break;
	                    }
	                    Collections.sort(BookingList);
	                    System.out.println("\nBookings sorted by total cost:");
	                    for (TicketBooking booking : BookingList) {
	                        booking.displayInfo();
	                    }
	                    break;
	                    
	                case 11: //Exit
	                    System.out.println("\nExiting the system. Goodbye!");
	                    ticketScanner.close();
	                    return;	                
	            }		            
	        }
	    }
	    public static int getCustomerId(Scanner ticketScanner, ArrayList<Customer> CustomerList)throws InvalidCustomerException {		    	 
    	    while (true) {
    	        System.out.print("Enter customer ID:");
    	        
    	        if (!ticketScanner.hasNextInt()) {
    	            ticketScanner.nextLine();
    	            throw new InvalidCustomerException("Invalid input: Please enter an integer");
    	        }
    	        int customerId = ticketScanner.nextInt();
    	        ticketScanner.nextLine(); 
    	        
    	        if (customerId <= 0) {
    	            throw new InvalidCustomerException("Invalid customer ID: Must be greater than 0");
    	        }
    	        
    	        for (Customer customer : CustomerList) {
    	            if (customer.getCustomerId() == customerId) {
    	                return customerId; 
    	            }
    	        }		    	       
    	        throw new InvalidCustomerException("Customer ID not found: " + customerId);
    	    }
    	}
	    	
	    public static String getCustomerName(Scanner ticketScanner) {
            System.out.print("Enter name: ");
            String customerName = ticketScanner.nextLine().trim();

            while (customerName.isEmpty()) {
                System.out.println("\nInvalid name. Please try again.");
                System.out.print("Enter name: ");
                customerName = ticketScanner.nextLine().trim();
            	}
            	return customerName;
		    }
	    
	    public static String getCustomerEmail(Scanner ticketScanner) {
            System.out.print("Enter email: ");
            String customerEmail = ticketScanner.nextLine().trim();

            while (customerEmail.isEmpty()) {
                System.out.println("\nInvalid email. Please try again.");
                System.out.print("Enter email: ");
                customerEmail = ticketScanner.nextLine().trim();
            	}
            	return customerEmail;
		    }
	    
	    public static Customer getCustomerById(int customerId, ArrayList<Customer> CustomerList) {
	        for (Customer customer : CustomerList) {
	            if (customer.getCustomerId() == customerId) {
	                return customer; 
	            }
	        }
	        return null;
	    }
	    			    		    
	    public static String getUserMovieName(Scanner ticketScanner) {
        System.out.print("Enter movie name: ");
        String movieName = ticketScanner.nextLine().trim();

        while (movieName.isEmpty()) {
            System.out.println("\nInvalid movie name. Please try again.");
            System.out.print("Enter movie name: ");
            movieName = ticketScanner.nextLine().trim();
        	}
        	return movieName;
	    }
        
        public static String getUserCinemaName(Scanner ticketScanner) {
        System.out.print("Enter cinema name: ");
        String cinemaName = ticketScanner.nextLine().trim();

        while (cinemaName.isEmpty()) {
            System.out.println("\nInvalid cinema name. Please try again.");
            System.out.print("Enter cinema name: ");
            cinemaName = ticketScanner.nextLine().trim();
        	}
        	return cinemaName;
        }
        
        public static String getUserShowDate(Scanner ticketScanner) {
        System.out.print("Enter show date (e.g., June 10): ");
        String showDate = ticketScanner.nextLine();
        
        while (showDate.isEmpty()) {
            System.out.println("\nInvalid show date.Please try again.");
            System.out.print("Enter show date(e.g., June 10): ");
            showDate = ticketScanner.nextLine().trim();	                        
        }
        
        while (true) {
        	String[] dateParts = showDate.trim().split(" ");
            if (dateParts.length < 2) {
                System.out.println("\nInvalid show date format. Please try again.");
                System.out.print("Enter show date (e.g., June 10): ");
                showDate = ticketScanner.nextLine().trim();
                continue;
            }
            
        	String month= dateParts[0];
        	month= month.substring(0, 1).toUpperCase() + month.substring(1).toLowerCase();
        	int day= Integer.parseInt(dateParts[1]); 
        	showDate=month + " " + day;
        	
            if (month.equals("January") || month.equals("February")|| month.equals("March") || month.equals("April")||
            	month.equals("May") || month.equals("June")||month.equals("July") || month.equals("August")||
            	month.equals("September") || month.equals("October")|| month.equals("November") || month.equals("December")) { 
                	
                	if(month.equals("January")||month.equals("March") ||
                	   month.equals("May")|| month.equals("July")|| month.equals("August") ||
                	   month.equals("October")|| month.equals("December")){                           	   
                        if (day >= 1 && day <= 31) {
                            break;  
                        } 
                        else {
                            System.out.println("\nInvalid day for " + month + ". Please try again.");
    	                    System.out.print("Enter show date (e.g., June 10): ");
    	                    showDate = ticketScanner.nextLine();   
                        }
                	}
                	else if(month.equals("April") ||month.equals("June") ||
                			month.equals("September")|| month.equals("November")){  
                            if (day >= 1 && day <= 30) {
                                break;  
                            } 
                            else {
                                System.out.println("\nInvalid day for " + month + ". Please try again.");
        	                    System.out.print("Enter show date (e.g., June 10): ");
        	                    showDate = ticketScanner.nextLine();
                            }
                    	}                                
                	else if (month.equals("February")) {
                		if(day >= 1 && day <= 29) {
            			break;
            		}
                    else {
                         System.out.println("\nInvalid day for " + month + ". Please try again.");
 	                    System.out.print("Enter show date (e.g., June 10): ");
 	                    showDate = ticketScanner.nextLine();
                    }                                			
            	}
            }
            else {
            	System.out.println("\nInvalid show month.Please try again.");
                System.out.print("Enter show date (e.g., June 10): ");
                showDate = ticketScanner.nextLine();
            	} 
        	} 
        	return showDate;
        }
        
        public static String getUserShowTime(Scanner ticketScanner) {
        System.out.print("Enter show time (e.g., 18:00): ");
        String showTime = ticketScanner.nextLine();       
	        while (true) {
	        	String[] timeParts = showTime.trim().split(":");
	
	            if (timeParts.length < 2) {
	                System.out.println("\nInvalid show time format. Please try again.");
	                System.out.print("Enter show time (e.g., 18:00): ");
	                showTime = ticketScanner.nextLine().trim();
	                continue;
	            }                           
	        	int hour= Integer.parseInt(timeParts[0]);
	        	int minute= Integer.parseInt(timeParts[1]);
	            if (hour >= 0 && hour < 24 && minute >= 0 && minute < 60) {
	                break; 
	            }	 
	            else {
	            	System.out.println("\nInvalid show time.Please try again.");
	                System.out.print("Enter show time (e.g., 18:00): ");
	                showTime = ticketScanner.nextLine();
	            } 
	        }
        return showTime;
       }
        
        public static int getUserTicketCount(Scanner ticketScanner) {
        	int ticketCount;	                    
        	while (true) {	  
        		System.out.print("Enter number of tickets: ");
            
            		if (ticketScanner.hasNextInt()) {  
                    ticketCount = ticketScanner.nextInt();
                    ticketScanner.nextLine();

	                if (ticketCount<=0) {
                    	System.out.println("\nInvalid ticket number.Please try again.");	        	                     
	                	} 
	                else {
	                	break; 
	                	}
            		}
	                else {
	                System.out.println("\nInvalid ticket number. Please enter an integer.");
		                ticketScanner.nextLine();
		                	}
		        		}
	        	return ticketCount;
            }
}
            
	








