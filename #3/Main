import java.util.Scanner;
import java.util.ArrayList;

	public class Main {
	    public static void main(String[] args) {
	        Scanner ticketScanner = new Scanner(System.in);
	        ArrayList<TicketBooking> Bookings = new ArrayList<>();
	        TicketBooking.totalNumOfBookings=0;
	        int choice;

	        while (true) {
	        	while(true) {
	            System.out.println("\nMovie Ticket Booking System");
	            MenuOptions.displayMenu();
	            System.out.print("Enter your choice (1-5): ");
	            
	            if (ticketScanner.hasNextInt()) {  
	                choice = ticketScanner.nextInt();
	                ticketScanner.nextLine(); 

	                if (choice >= 1 && choice <= 5) {
	                    break;  
	                } else {
	                    System.out.println("\nInvalid choice. Please enter a choice between 1 and 5.");
	                }
	            } else {
	                System.out.println("\nInvalid choice. Please enter a integer.");
	                ticketScanner.nextLine(); 
	            }
	        }	        
	            switch (choice) {
	                case 1: //Create new Ticket Booking
	                	
	                    System.out.print("Enter movie name: ");
	                    String movieName = ticketScanner.nextLine().trim();

	                    while (movieName.isEmpty()) {
	                        System.out.println("\nInvalid movie name.Please try again. Please try again.");
	                        System.out.print("Enter movie name: ");
	                        movieName = ticketScanner.nextLine().trim();
	                    }

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
	                                        	                  
	                                                         	                            
	                    Bookings.add(new Regular(movieName, showDate, showTime, ticketCount));
	                    TicketBooking.totalNumOfBookings++;
	                    System.out.println("Booking created successfully!");
	                    break;


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
                        
	                    System.out.print("Enter movie name: ");
	                    movieName = ticketScanner.nextLine();

	                    System.out.print("Enter show date (e.g., June 10): ");
	                    showDate = ticketScanner.nextLine();
	                    
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
                        	String month= dateParts[0].toLowerCase();
                        	month= month.substring(0, 1).toUpperCase() + month.substring(1);
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
                        
	                    System.out.print("Enter show time (e.g., 18:00): ");
	                    showTime = ticketScanner.nextLine();
	                    
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
                    	                    	
	                    if (seatType.equals("REGULAR")) {
                        	Bookings.add(new Regular(movieName, showDate, showTime, ticketCount));
	                    }
                        else if (seatType.equals("PREMIUM")) {
                        	Bookings.add(new Premium(movieName, showDate, showTime, ticketCount));
                        }
                        else if (seatType.equals("VIP")) {
                        	Bookings.add(new VIP(movieName, showDate, showTime, ticketCount));
                        }
                        else if (seatType.equals("BALCONY")) {
                        	Bookings.add(new Balcony(movieName, showDate, showTime, ticketCount));
                        }
                        else if (seatType.equals("BOX")) {
                        	Bookings.add(new Box(movieName, showDate, showTime, ticketCount));
                        }
                        else if (seatType.equals("IMAX")) {
                        	Bookings.add(new IMAX(movieName, showDate, showTime, ticketCount));
                        }
	                    	                                                         	                            
	                    TicketBooking.totalNumOfBookings++;
	                    System.out.println("\nBooking created successfully!");
	                    break;
                        
	                case 3: // Display all Ticket Bookings
	                    if (Bookings.isEmpty()) {
	                        System.out.println("\nNo bookings available to display.");
	                    } else {
	                        System.out.println("\nTicket Booking Information:");
	                        for (TicketBooking booking : Bookings) {
	                            booking.displayInfo();
	                        }	                    	
	                    }
	                    break;
	                    
	                case 4: //Display the total number of bookings
	                	System.out.println("\nTotal number of bookings:" + TicketBooking.totalNumOfBookings);	                	
	                	break;

	                case 5: //Exit
	                    System.out.println("\nExiting the system. Goodbye!");
	                    ticketScanner.close();
	                    return;
	            }
	        }
	    }
	}
