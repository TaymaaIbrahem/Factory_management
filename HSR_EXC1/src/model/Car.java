package model;

import java.io.Serializable;

import utils.Color;
import utils.MyFileLogWriter;

public class Car extends VehicleTransportation implements Uprage , Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int numberOfSeats;
	private boolean isConvertible;
	
	

	public Car(String licensePlate, double price, double costOfManufacturing, Color color, int yearOfManufacture,
			double engineCapacity, int pollutionLevel, int numberOfSeats, boolean isConvertible) {
		super(licensePlate, price, costOfManufacturing, color, yearOfManufacture, engineCapacity, pollutionLevel);
		this.numberOfSeats = numberOfSeats;
		this.isConvertible = isConvertible;
	}

	public Car(double price, double costOfManufacturing, Color color, int yearOfManufacture, double engineCapacity,
			int pollutionLevel, int numberOfSeats, boolean isConvertible) {
		super(price, costOfManufacturing, color, yearOfManufacture, engineCapacity, pollutionLevel);
		setLicensePlate("c" +getCounter());
		this.numberOfSeats = numberOfSeats; 
		this.isConvertible = isConvertible;
	}
 
	public int getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	} 

	public boolean isConvertible() {
		return isConvertible;
	}

	public void setConvertible(boolean isConvertible) {
		this.isConvertible = isConvertible;
	}

	@Override
	public String toString() {
		return  super.toString() +" numberOfSeats= " + numberOfSeats;
	}


	@Override
	public void describeSpecialProperties() {
		// TODO Auto-generated method stub
		MyFileLogWriter.println("number of seats <" +numberOfSeats+">  is convertible <"+ isConvertible+">");

	}

	@Override
	public void upgrade() {
		// TODO Auto-generated method stub
		setEngineCapacity(getEngineCapacity()*1.1);
	}


}
