package model;

import java.io.Serializable;

import utils.Color;
import utils.MyFileLogWriter;

public class HybridMotorcycle extends Motorcycle implements Hybrid ,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double numOfKMElectricBasis;

public HybridMotorcycle(String licensePlate, double price, double costOfManufacturing, Color color,
			int yearOfManufacture, double engineCapacity, int pollutionLevel, boolean isOffRoad) {
		super(licensePlate, price, costOfManufacturing, color, yearOfManufacture, engineCapacity, pollutionLevel,
				isOffRoad);
		setHybridProperty();
	}

public HybridMotorcycle(double price, double costOfManufacturing, Color color, int yearOfManufacture,
			double engineCapacity, int pollutionLevel, boolean isOffRoad) {
		super(price, costOfManufacturing, color, yearOfManufacture, engineCapacity, pollutionLevel, isOffRoad);
		setHybridProperty();
	}

public double setHybridProperty() {
	numOfKMElectricBasis = getEngineCapacity()*1.5;
			return numOfKMElectricBasis;
}

public double getNumOfKMElectricBasis() {
	return numOfKMElectricBasis;
}

public void setNumOfKMElectricBasis(double numOfKMElectricBasis) {
	this.numOfKMElectricBasis = numOfKMElectricBasis;
}
public void describeSpecialProperties() {
	// TODO Auto-generated method stub
	MyFileLogWriter.println("number of km electric basis <"+ numOfKMElectricBasis +">" );

}

}
