package Assignment7;

public class LoyaltyMember  implements Customer {
    private int customerId;
    private String name;
    private String email;
    private double totalCost;

    public LoyaltyMember(int customerId, String name, String email) {
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
        return totalCost* 0.9;
    }

    @Override
    public void displayInfo() {
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Type: Loyalty Member");
        System.out.println("------------------------------");
    }
}



