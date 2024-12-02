public enum MenuOptions {
	Option1( "1. Create new Ticket Booking" ),
	Option2( "2. Create new Ticket Booking with Ticket Type" ),
	Option3( "3. Display all Ticket Bookings" ),
	Option4( "4. Display the total number of bookings" ),
	Option5( "5. Exit" );
	
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
