package model;






import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class HarmonicMean implements ScoreCalculator , Serializable{

	
	private static final long serialVersionUID = 1L;

	public float calculate(HashSet<VehicleTransportation> allVehicleTransportation) {
		// Declare sum variables and  
        // initialize with zero 
		int n = allVehicleTransportation.size();
        float sum = 0; 
       
		for(VehicleTransportation r : allVehicleTransportation) {
			sum = sum + (float)1/r.getPollutionLevel();
		}
		
        return (float)n/sum;
	}

	
}
