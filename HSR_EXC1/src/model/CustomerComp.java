package model;

import java.util.Comparator;

public class CustomerComp  implements Comparator<Customer>{

	public int compare(Customer o1, Customer o2) {
		if(o1.getAllDeals().size() == o2.getAllDeals().size()) {
			Integer numOfO1=0,numOfO2=0;
			for(Deal d : o1.getAllDeals()) {
				numOfO1=numOfO1+ d.getAllVehicleTransportation().size();
			}
			for(Deal d : o2.getAllDeals()) {
				numOfO2= numOfO2+d.getAllVehicleTransportation().size();
			}
			if(numOfO1.compareTo(numOfO2)==0)
				return o1.compareTo(o2);
			return -1*numOfO1.compareTo(numOfO2);
		}
		Integer s1 =o1.getAllDeals().size();
		Integer s2 =o2.getAllDeals().size();

		return s1.compareTo(s2);
	}


}
