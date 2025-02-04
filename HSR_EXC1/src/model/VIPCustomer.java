package model;

import java.io.Serializable;
import java.util.Date;

import utils.Area;
import utils.Gender;

public class VIPCustomer extends Customer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double discountPercentage;

	public VIPCustomer(String iD, String firstName, String lastName, String phoneNumber, Gender gender, int yearOfBirth,
			Area area, Date dateOfJoining, double discountPercentage) {
		super(iD, firstName, lastName, phoneNumber, gender, yearOfBirth, area,  dateOfJoining);
		this.discountPercentage = discountPercentage;
	}
	public double getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	@Override
	public String toString() {
		return  super.toString()+" discountPercentage= " + discountPercentage;
	}
	
	
	
	
	

}
