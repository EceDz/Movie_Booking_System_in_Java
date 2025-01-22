package Assignment6;

import java.util.Comparator;

public class CustomerNameComparator implements Comparator<Customer> {
	@Override
    public int compare(Customer first, Customer second) {
        return first.getName().compareTo(second.getName());
    }
}
