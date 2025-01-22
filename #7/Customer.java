package Assignment7;

public interface Customer {
    
    int getCustomerId();
    String getName();
    String getEmail();
    double calculateDiscountedPrice(double totalCost);
    void displayInfo();
    
}

