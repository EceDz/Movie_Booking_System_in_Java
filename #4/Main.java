package Assignment4;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

	public class Main {
		    public static void main(String[] args) {
		        Scanner ticketScanner = new Scanner(System.in);
		        TicketBooking.totalNumOfBookings=0;
		        TicketBooking[] Bookings = new TicketBooking[3];
		        ArrayList<TicketBooking> BookingList= new ArrayList<TicketBooking>();		        
		        int choice;

		        while (true) {
		        	while(true) {
			            System.out.println("\nMovie Ticket Booking System");
			            MenuOptions.displayMenu();
			            System.out.print("Enter your choice (1-7): ");
			            
			            if (ticketScanner.hasNextInt()) {  
			                choice = ticketScanner.nextInt();
			                ticketScanner.nextLine(); 
	
			                if (choice >= 1 && choice <= 7) {
			                    break;  
			                } else {
			                    System.out.println("\nInvalid choice. Please enter a choice between 1 and 7.");
			                }
			            } else {
			                System.out.println("\nInvalid choice. Please enter a integer.");
			                ticketScanner.nextLine(); 
			            }
			        }	        
		            switch (choice) {
		                case 1: //Create new Ticket Booking		                	

		                	String movieName = getUserMovieName(ticketScanner);
		                    String cinemaName = getUserCinemaName(ticketScanner);
		                    String showDate = getUserShowDate(ticketScanner);
		                    String showTime = getUserShowTime(ticketScanner);
		                    int ticketCount=getUserTicketCount(ticketScanner);
		                	
		                    if (TicketBooking.totalNumOfBookings < Bookings.length) {	        	        
		                    Bookings[TicketBooking.totalNumOfBookings] = new Regular(movieName, cinemaName, showDate, showTime, ticketCount);
		                    TicketBooking.totalNumOfBookings++;
		                    System.out.println("Booking created successfully!");
		                    break;	                    
			                }        	        
			        	    else {
			        	        if (BookingList.size() < Bookings.length) {
			        	            BookingList.addAll(Arrays.asList(Bookings));
			        	        }
			                    BookingList.add(new Regular(movieName, cinemaName, showDate, showTime, ticketCount));
			                    TicketBooking.totalNumOfBookings++;
			                    System.out.println("Booking created successfully!");
		                        break;
		                    }
		                    
		                case 2: //Create new Ticket Booking with Ticket Type	                	
		                	
	                        System.out.print("Enter ticket type (Regular, Premium, VIP, Balcony, Box, IMAX): ");
	                        String seatType = ticketScanner.nextLine().toUpperCase();
	                          
	                        while (true) {                          
	                            if (seatType.equals("REGULAR") || seatType.equals("PREMIUM") 
	                            	|| seatType.equals("VIP") || seatType.equals("BALCONY") 
	                            	|| seatType.equals("BOX") || seatType.equals("IMAX")) {
	                                break; 
	                            } 
	                            else {
		                            System.out.println("\nInvalid ticket type.Please try again.");
		                            System.out.print("Enter ticket type (Regular, Premium, VIP, Balcony, Box, IMAX): ");
		                            seatType = ticketScanner.nextLine().toUpperCase();
	                            }
	                        }	                        
		                	movieName = getUserMovieName(ticketScanner);
		                    cinemaName = getUserCinemaName(ticketScanner);
		                    showDate = getUserShowDate(ticketScanner);
		                    showTime = getUserShowTime(ticketScanner);
		                    ticketCount=getUserTicketCount(ticketScanner);
	  	        	        
	  	        	        if((TicketBooking.totalNumOfBookings <= Bookings.length)) {	
	  		                    if (seatType.equals("REGULAR")) {
	  		                    	Bookings[TicketBooking.totalNumOfBookings]=new Regular(movieName, cinemaName, showDate, showTime, ticketCount);
	  		                    }
	  	                        else if (seatType.equals("PREMIUM")) {
	  		                    	Bookings[TicketBooking.totalNumOfBookings]=new Premium(movieName, cinemaName, showDate, showTime, ticketCount);
	  		                    }
	  	                        else if (seatType.equals("VIP")) {
	  		                    	Bookings[TicketBooking.totalNumOfBookings]=new VIP(movieName, cinemaName, showDate, showTime, ticketCount);
	  		                    }
	  	                        else if (seatType.equals("BALCONY")) {
	  		                    	Bookings[TicketBooking.totalNumOfBookings]=new Balcony(movieName, cinemaName, showDate, showTime, ticketCount);
	  		                    }
	  	                        else if (seatType.equals("BOX")) {
	  		                    	Bookings[TicketBooking.totalNumOfBookings]=new Box(movieName, cinemaName, showDate, showTime, ticketCount);
	  		                    }
	  	                        else if (seatType.equals("IMAX")) {
	  		                    	Bookings[TicketBooking.totalNumOfBookings]=new IMAX(movieName, cinemaName, showDate, showTime, ticketCount);
	  		                    }
	  		                    	                                                         	                            
	  		                    TicketBooking.totalNumOfBookings++;
	  		                    System.out.println("\nBooking created successfully!");
	  		                    break;
	  	  	        	        }	        		                  
	  	        	        
	  	        	        else {
	  	        	        	
			        	    if (BookingList.size() < Bookings.length) {
			        	        BookingList.addAll(Arrays.asList(Bookings));
			        	    }
	  	        	        
		                    if (seatType.equals("REGULAR")) {
		                    	BookingList.add(new Regular(movieName, cinemaName, showDate, showTime, ticketCount));
		                    }
	                        else if (seatType.equals("PREMIUM")) {
	                        	BookingList.add(new Premium(movieName, cinemaName, showDate, showTime, ticketCount));
	                        }
	                        else if (seatType.equals("VIP")) {
	                        	BookingList.add(new VIP(movieName, cinemaName, showDate, showTime, ticketCount));
	                        }
	                        else if (seatType.equals("BALCONY")) {
	                        	BookingList.add(new Balcony(movieName, cinemaName, showDate, showTime, ticketCount));
	                        }
	                        else if (seatType.equals("BOX")) {
	                        	BookingList.add(new Box(movieName, cinemaName, showDate, showTime, ticketCount));
	                        }
	                        else if (seatType.equals("IMAX")) {
	                        	BookingList.add(new IMAX(movieName, cinemaName, showDate, showTime, ticketCount));
	                        }
		                    	                                                         	                            
		                    TicketBooking.totalNumOfBookings++;
		                    System.out.println("\nBooking created successfully!");
		                    break;
	  	        	        }
	                        
		                case 3: // Display all Ticket Bookings
		                	if (TicketBooking.totalNumOfBookings <=0) {
		                        System.out.println("\nNo bookings available to display.");
		                        break;
		                	}
		                    else {
		                        System.out.println("\nTicket Booking Information:");

		                        for (int i = 0; i <TicketBooking.totalNumOfBookings; i++) {
		                        	TicketBooking booking;		                        	
		                            if (i < Bookings.length) {
		                                booking = Bookings[i];
		                                booking.displayInfo();		                                
		                            } 
		                            else{
		                                booking = BookingList.get(i);
		                                booking.displayInfo();
		                            }
		                        }
		                    break;
		                    }
		                	                   	                    
		                case 4: //Display the total number of bookings
		                	System.out.println("\nTotal number of bookings:" + TicketBooking.totalNumOfBookings);	                	
		                	break;
		                	
		                case 5: // List the bookings for a specific cinema
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
		                        TicketBooking booking = iterator.next();
		                        if (booking != null && booking.getCinemaName().equals(userCinema)) {
		                        	cinemaCount ++;
		                        	System.out.printf("\n%d. booking for %s.\n", cinemaCount, userCinema);
		                        	booking.displayInfo();	
		                        }	                        
		                    }
                        	if(cinemaCount==0) {
                        		System.out.printf("\nNo bookings found for %s.\n", userCinema);
                        	}
		                    break;

		                case 6: // Remove bookings in a specific cinema
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
		                        TicketBooking booking = removeIterator.next();
		                        if (booking != null && booking.getCinemaName().equals(removeCinema)) {
		                        	removeIterator.remove();
		                        	removeCount++;		                        	
		                        }
		                    }		                    
		                    TicketBooking.totalNumOfBookings -= removeCount;
		                    
		                    if (removeCount>0) {
		                    	System.out.printf("\n%d booking(s) for %s removed.\n", removeCount, removeCinema);
		                        Bookings = BookingList.toArray(new TicketBooking[0]);
		                        
		                    } else {
		                        System.out.printf("\nNo bookings found for %s.\n", removeCinema);
		                        System.out.println("Enter cinema name: ");
		                        removeCinema = ticketScanner.nextLine().trim();
		                    }
		                    break;
	
		                case 7: //Exit
		                    System.out.println("\nExiting the system. Goodbye!");
		                    ticketScanner.close();
		                    return;	                
		            }
		            
		        }
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
	








