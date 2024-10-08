package model;

import java.io.Serializable;

import utils.Color;

public abstract class VehicleTransportation implements Comparable<VehicleTransportation> ,Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int counter=0;
	private String licensePlate;
	private double price;
	private double costOfManufacturing;
	private Color color;
	private int yearOfManufacture; 
	private double engineCapacity;
	private int pollutionLevel;
	
	
	public VehicleTransportation(String licensePlate, double price, double costOfManufacturing, Color color,
			int yearOfManufacture, double engineCapacity, int pollutionLevel) {
		super();
		this.licensePlate = licensePlate;
		this.price = price;
		this.costOfManufacturing = costOfManufacturing;
		this.color = color;
		this.yearOfManufacture = yearOfManufacture;
		this.engineCapacity = engineCapacity;
		this.pollutionLevel = pollutionLevel;
	}
	public VehicleTransportation(double price, double costOfManufacturing, Color color,
			int yearOfManufacture, double engineCapacity, int pollutionLevel1) {
		this.price = price;
		this.costOfManufacturing = costOfManufacturing;
		this.color = color;
		this.yearOfManufacture = yearOfManufacture;
		this.engineCapacity = engineCapacity;
		if(pollutionLevel1 > 15 )
			pollutionLevel1=15;
		else if (pollutionLevel1 <1 )
			pollutionLevel1=1;

		else {
			this.pollutionLevel = pollutionLevel1;
		}
		setCounter(getCounter()+1);
	}
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		VehicleTransportation.counter = counter;
	}
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getCostOfManufacturing() {
		return costOfManufacturing;
	}
	public void setCostOfManufacturing(double costOfManufacturing) {
		this.costOfManufacturing = costOfManufacturing;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public int getYearOfManufacture() {
		return yearOfManufacture;
	}
	public void setYearOfManufacture(int yearOfManufacture) {
		this.yearOfManufacture = yearOfManufacture;
	}
	public double getEngineCapacity() {
		return engineCapacity;
	}
	public void setEngineCapacity(double engineCapacity) {
		this.engineCapacity = engineCapacity;
	}
	public int getPollutionLevel() {
		return pollutionLevel;
	}
	public void setPollutionLevel(int pollutionLevel) {
		this.pollutionLevel = pollutionLevel;
	}
	@Override
	public String toString() {
		return "licensePlate= " + licensePlate + ", price= " + price  + ", yearOfManufacture= " + yearOfManufacture
				+ ", engineCapacity= " + engineCapacity ;
	}
	
	abstract public void describeSpecialProperties();
	@Override
	public int compareTo(VehicleTransportation o) {
		// TODO Auto-generated method stub
		return this.licensePlate.compareTo(o.licensePlate);
	}

	
}
