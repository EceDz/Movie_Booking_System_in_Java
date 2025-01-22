package Assignment7;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class Main  {
    private static ArrayList<Customer> CustomerList = new ArrayList<>();
    private static TicketBooking[] Bookings = new TicketBooking[3];
    private static ArrayList<TicketBooking> BookingList = new ArrayList<>();

    public static void main(String[] args) throws InvalidTicketTypeException{
        TicketBooking.totalNumOfBookings = 0;
       
        JFrame frame = new JFrame("Movie Ticket Booking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Movie Ticket Booking System", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(titleLabel, BorderLayout.NORTH);

        JPanel mainPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton addCustomer = new JButton("Add Customer");
        JButton createBooking = new JButton("Create Booking");
        JButton displayCustomers = new JButton("Display All Customers");
        JButton displayBookings = new JButton("Display All Bookings");

        addCustomer.addActionListener(e -> {
            String[] customerTypes = {"Regular Customer", "Loyalty Member", "Corporate Client"};
            JComboBox<String> customerTypeCombo = new JComboBox<>(customerTypes);
           
            JPanel panel = new JPanel(new GridLayout(2, 1, 5, 5));
            panel.add(new JLabel("Select Customer Type:"));
            panel.add(customerTypeCombo);

            int result = JOptionPane.showConfirmDialog(frame, panel,
                "Add Customer", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
           
            if (result == JOptionPane.OK_OPTION) {
                int typeChoice = customerTypeCombo.getSelectedIndex();
                String name = getCustomerNameGUI(frame);
                if (name == null) return;

                String email = getCustomerEmailGUI(frame);
                if (email == null) return;

                Customer customer = null;
                int customerId = CustomerList.size() + 1;
               
                switch (typeChoice) {
                    case 0:
                        customer = new RegularCustomer(customerId, name, email);
                        break;
                    case 1:
                        customer = new LoyaltyMember(customerId, name, email);
                        break;
                    case 2:
                        customer = new CorporateClient(customerId, name, email);
                        break;
                }
               
                CustomerList.add(customer);
                JOptionPane.showMessageDialog(frame, "Customer added successfully!");
            }
        });
        
        createBooking.addActionListener(e -> {
            if (CustomerList.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No customers available. Please add a customer first.",
                    "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                String customerIdStr = JOptionPane.showInputDialog(frame, "Enter customer ID:");
                if (customerIdStr == null) return;
               
                try {
                    int customerId = getCustomerIdGUI(Integer.parseInt(customerIdStr), CustomerList);
                    
                    String movieName = getUserMovieNameGUI(frame);
                    if (movieName == null) return;
                   
                    String cinemaName = getUserCinemaNameGUI(frame);
                    if (cinemaName == null) return;
                   
                    String showDate = getUserShowDateGUI(frame);
                    if (showDate == null) return;
                   
                    String showTime = getUserShowTimeGUI(frame);
                    if (showTime == null) return;
                   
                    Integer ticketCount = getUserTicketCountGUI(frame);
                    if (ticketCount == null) return;

                    String[] ticketTypes = {"Regular", "Premium", "VIP", "Balcony", "Box", "IMAX"};
                    JComboBox<String> ticketTypeCombo = new JComboBox<>(ticketTypes);
                   
                    JPanel panel = new JPanel(new GridLayout(2, 1, 5, 5));
                    panel.add(new JLabel("Select Ticket Type:"));
                    panel.add(ticketTypeCombo);

                    int result = JOptionPane.showConfirmDialog(frame, panel,
                        "Create Booking", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                   
                    if (result != JOptionPane.OK_OPTION) return;
                    String selectedTicketType = (String) ticketTypeCombo.getSelectedItem();

                    // Create booking based on ticket type
                    TicketBooking booking = null;
                    switch (selectedTicketType) {
                        case "Regular":
                            booking = new Regular(customerId, movieName, cinemaName, showDate, showTime, ticketCount);
                            break;
                        case "Premium":
                            booking = new Premium(customerId, movieName, cinemaName, showDate, showTime, ticketCount);
                            break;
                        case "VIP":
                            booking = new VIP(customerId, movieName, cinemaName, showDate, showTime, ticketCount);
                            break;
                        case "Balcony":
                            booking = new Balcony(customerId, movieName, cinemaName, showDate, showTime, ticketCount);
                            break;
                        case "Box":
                            booking = new Box(customerId, movieName, cinemaName, showDate, showTime, ticketCount);
                            break;
                        case "IMAX":
                            booking = new IMAX(customerId, movieName, cinemaName, showDate, showTime, ticketCount);
                            break;
                    }

                    if (TicketBooking.totalNumOfBookings < Bookings.length) {
                        Bookings[TicketBooking.totalNumOfBookings] = booking;
                    } else {
                        if (BookingList.size() <= Bookings.length) {
                            BookingList.clear();
                            BookingList.addAll(java.util.Arrays.asList(Bookings));
                        }
                        BookingList.add(booking);
                    }

                    TicketBooking.totalNumOfBookings++;
                    double originalCost = booking.getTotalPrice();
                    Customer customer = getCustomerById(customerId, CustomerList);
                    double discountedCost = customer.calculateDiscountedPrice(originalCost);

                    JOptionPane.showMessageDialog(frame,
                        String.format("Booking created successfully!\nOriginal Cost: $%.2f\nDiscounted Cost: $%.2f",
                            originalCost, discountedCost));

                } catch (InvalidCustomerException ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        displayCustomers.addActionListener(e -> {
            if (CustomerList.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No customers added yet.");
                return;
            }

            StringBuilder customerList = new StringBuilder("Customers:\n\n");
            for (Customer c : CustomerList) {
                customerList.append(c.getCustomerId()).append(". ")
                       	  .append(c.getName())
                          .append(" (").append(c.getEmail())
                          .append(") ").append(c.getClass().getSimpleName())
                          .append("\n---------------------------------------------------------------------------------------------------\n");
            }

            JTextArea textArea = new JTextArea(customerList.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(400, 300));
           
            JOptionPane.showMessageDialog(frame, scrollPane, "Display All Customers",
                JOptionPane.INFORMATION_MESSAGE);
        });

        displayBookings.addActionListener(e -> {
            if (TicketBooking.totalNumOfBookings <= 0) {
                JOptionPane.showMessageDialog(frame, "No bookings available to display.");
                return;
            }

            StringBuilder bookingList = new StringBuilder("Bookings:\n\n");
            for (int i = 0; i < TicketBooking.totalNumOfBookings; i++) {
                TicketBooking booking;
                if (i < Bookings.length) {
                    booking = Bookings[i];
                } else {
                    booking = BookingList.get(i);
                }
                if (booking != null) {
                    bookingList.append("Customer ID: ").append(booking.getCustomerId())
                              .append("\nMovie: ").append(booking.getMovieName())
                              .append("\nCinema: ").append(booking.getCinemaName())
                              .append("\nDate: ").append(booking.getShowDate())
                              .append("\nTime: ").append(booking.getShowTime())
                              .append("\nTickets: ").append(booking.getTicketCount())
                              .append("\nSeat Type: ").append(booking.getSeatType())
                              .append("\nTotal Price: $").append(String.format("%.2f", booking.getTotalPrice()))
                              .append("\n---------------------------------------------------------------------------------------------------\n");
                }
            }

            JTextArea textArea = new JTextArea(bookingList.toString());
            textArea.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(400, 300));
           
            JOptionPane.showMessageDialog(frame, scrollPane, "Display All Bookings",
                JOptionPane.INFORMATION_MESSAGE);
        });

        mainPanel.add(addCustomer);
        mainPanel.add(createBooking);
        mainPanel.add(displayCustomers);
        mainPanel.add(displayBookings);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static Customer getCustomerById(int customerId, ArrayList<Customer> CustomerList) {
        for (Customer customer : CustomerList) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        return null;
    }
    
    private static String getCustomerNameGUI(JFrame frame) {
        while (true) {
            String name = JOptionPane.showInputDialog(frame, "Enter name:");
            if (name == null) {
            	return null; 
            }
            name = name.trim();
            if (!name.isEmpty()) {
                return name;
            }
            JOptionPane.showMessageDialog(frame, "Invalid name. Please try again.");
        }
    }

    private static String getCustomerEmailGUI(JFrame frame) {
        while (true) {
            String email = JOptionPane.showInputDialog(frame, "Enter email:");
            if (email == null) {
            	return null;
            }
            email = email.trim();
            if (!email.isEmpty()) {
                return email;
            }
            JOptionPane.showMessageDialog(frame, "Invalid email. Please try again.");
        }
    }

    private static Integer getUserTicketCountGUI(JFrame frame) {
        while (true) {
            String input = JOptionPane.showInputDialog(frame, "Enter number of tickets:");
            if (input == null) return null;
           
            try {
                int count = Integer.parseInt(input.trim());
                if (count > 0) {
                    return count;
                }
                JOptionPane.showMessageDialog(frame, "Invalid ticket number. Must be greater than 0.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Invalid ticket number. Please enter an integer.");
            }
        }
    }

    private static String getUserMovieNameGUI(JFrame frame) {
        while (true) {
            String movieName = JOptionPane.showInputDialog(frame, "Enter movie name:");
            if (movieName == null) return null;
            movieName = movieName.trim();
            if (!movieName.isEmpty()) {
                return movieName;
            }
            JOptionPane.showMessageDialog(frame, "Invalid movie name. Please try again.");
        }
    }

    private static String getUserCinemaNameGUI(JFrame frame) {
        while (true) {
            String cinemaName = JOptionPane.showInputDialog(frame, "Enter cinema name:");
            if (cinemaName == null) return null;
            cinemaName = cinemaName.trim();
            if (!cinemaName.isEmpty()) {
                return cinemaName;
            }
            JOptionPane.showMessageDialog(frame, "Invalid cinema name. Please try again.");
        }
    }

    private static int getCustomerIdGUI(int customerId, ArrayList<Customer> CustomerList)
            throws InvalidCustomerException {
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

    private static String getUserShowDateGUI(JFrame frame) {
        while (true) {
            String showDate = JOptionPane.showInputDialog(frame, "Enter show date (e.g., June 10):");
            if (showDate == null) return null;
            showDate = showDate.trim();
           
            if (showDate.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Invalid show date. Please try again.");
                continue;
            }

            String[] dateParts = showDate.split(" ");
            if (dateParts.length < 2) {
                JOptionPane.showMessageDialog(frame, "Invalid show date. Please try again.");
                continue;
            }

            try {
                String month = dateParts[0];
                month = month.substring(0, 1).toUpperCase() + month.substring(1).toLowerCase();
                int day = Integer.parseInt(dateParts[1]);

                if (checkDate(month, day)) {
                    return month + " " + day;
                }
                JOptionPane.showMessageDialog(frame, "Invalid date for " + month);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Invalid show date. Please enter a number.");
            }
        }
    }
    private static boolean checkDate(String month, int day) {
        if (month.equals("January") || month.equals("February") || month.equals("March") ||
            month.equals("April") || month.equals("May") || month.equals("June") ||
            month.equals("July") || month.equals("August") || month.equals("September") ||
            month.equals("October") || month.equals("November") || month.equals("December")) {

            if (month.equals("January") || month.equals("March") || month.equals("May") ||
                month.equals("July") || month.equals("August") || month.equals("October") ||
                month.equals("December")) {
                return day >= 1 && day <= 31;
            }
            else if (month.equals("April") || month.equals("June") ||
                     month.equals("September") || month.equals("November")) {
                return day >= 1 && day <= 30;
            } 
            else if (month.equals("February")) {
                return day >= 1 && day <= 29;
            }
        }
        return false;
    }

    private static String getUserShowTimeGUI(JFrame frame) {
        while (true) {
            String showTime = JOptionPane.showInputDialog(frame, "Enter show time (e.g., 18:00):");
            if (showTime == null) return null;
            showTime = showTime.trim();

            String[] timeParts = showTime.split(":");
            if (timeParts.length < 2) {
                JOptionPane.showMessageDialog(frame, "Invalid show time. Please try again.");
                continue;
            }

            try {
                int hour = Integer.parseInt(timeParts[0]);
                int minute = Integer.parseInt(timeParts[1]);
               
                if (hour >= 0 && hour < 24 && minute >= 0 && minute < 60) {
                    return showTime;
                }
                JOptionPane.showMessageDialog(frame, "Invalid show time. Please try again.");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(frame, "Invalid show time. Please try again.");
            }
        }
    }

}
