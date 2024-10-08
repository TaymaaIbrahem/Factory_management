package model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class GeometricMean implements ScoreCalculator , Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public float calculate(HashSet<VehicleTransportation> allVehicleTransportation) {


		// declare product variable and 
        // initialize it to 1. 
        float product = 1;
  
        // Compute the product of all the 
        // elements in the array.
        int n = allVehicleTransportation.size();
		for(VehicleTransportation r : allVehicleTransportation) 
			product = product * r.getPollutionLevel();
		

  
        // compute geometric mean through  
        // formula pow(product, 1/n) and 
        // return the value to main function. 
        float gm = (float)Math.pow(product, (float)1 / n); 
        return gm; 
	}

}
