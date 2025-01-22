package Assignment6;

public class CorporateClient implements Customer {
    private int customerId;
    private String name;
    private String email;
    private double totalCost;

    public CorporateClient(int customerId, String name, String email) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
    }

    public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
    public int getCustomerId() {
        return customerId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public double calculateDiscountedPrice(double totalCost) {
    	if (totalCost>500) {
    		return totalCost* 0.85;
    	}
    	return totalCost;

    }

    @Override
    public void displayInfo() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Type: Corporate Client ");
        System.out.println("------------------------------");
    }
}



