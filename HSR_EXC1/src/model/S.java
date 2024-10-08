package model;

import java.util.Comparator;

public class S implements Comparator<Customer>{

	public int compare(Customer o1, Customer o2) {
		// TODO Auto-generated method stub
		if(o1.getArea().compareTo(o2.getArea()) == 1)
			o1.getID().compareTo(o2.getID());
		return 0;
	}

}
