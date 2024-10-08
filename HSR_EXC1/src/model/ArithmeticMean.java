package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
// calculate arthimetc mean
public class ArithmeticMean implements ScoreCalculator , Serializable {

	
	private static final long serialVersionUID = 1L;

	public float calculate(HashSet<VehicleTransportation> allVehicleTransportation) {
		int count=0;
		if(allVehicleTransportation.size() == 0)
			return 0;
		for(VehicleTransportation r : allVehicleTransportation) {
			count+=r.getPollutionLevel();
		}
		return (float)count/(allVehicleTransportation.size());
	}

}
