package Assignment4;

public enum MenuOptions {
	Option1( "1. Create new Ticket Booking" ),
	Option2( "2. Create new Ticket Booking with Ticket Type" ),
	Option3( "3. Display all Ticket Bookings" ),
	Option4( "4. Display the total number of bookings" ),
	Option5( "5. List the bookings for a specific cinema" ),
	Option6( "6. Remove bookings in a specific cinema" ),
	Option7( "7. Exit" );
	
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


