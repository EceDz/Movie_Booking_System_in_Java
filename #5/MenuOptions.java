package AssignmentV;

public enum MenuOptions {
	Option1( "1. Add Customer" ),
	Option2( "2. Create new Ticket Booking" ),
	Option3( "3. Create new Ticket Booking with Ticket Type" ),
	Option4( "4. Display all Ticket Bookings" ),
	Option5( "5. Display the total number of bookings" ),
	Option6( "6. List the bookings for a specific cinema" ),
	Option7( "7. Remove bookings in a specific cinema" ),
	Option8( "8. Display all Customers" ),
	Option9( "9. Exit" );
	
	private final String menuOption;
	
	MenuOptions( String menuOption ) {
		this.menuOption = menuOption;
	}
	
	public String getMenuOptions() {
		return menuOption;
	}
	
	public static void displayMenu() {
		for ( MenuOptions menuOption : MenuOptions.values() ) {
			System.out.println( menuOption.getMenuOptions() );
		}
	}
}


