package model;

import java.util.Comparator;

public class VehicleTransportationsCompare implements Comparator<VehicleTransportation>{
	
	
	public int compare(VehicleTransportation o1, VehicleTransportation o2) {
		if(o1.getPollutionLevel() == o2.getPollutionLevel()) {
			if(Double.compare(o1.getPrice(), o2.getPrice())==0)
				return o1.compareTo(o2);
			return  Double.compare(o1.getPrice(), o2.getPrice());
		}
		return -1*Integer.compare(o1.getPollutionLevel(), o2.getPollutionLevel());
	}
	


}
