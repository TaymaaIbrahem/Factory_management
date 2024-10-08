package model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;



public class Deal implements Comparable<Deal> ,Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int counter=0;
	private String dealID;
	private Customer customer;
	private Date dealDate;
	private HashSet<VehicleTransportation> allVehicleTransportation; 
	private double shippingCost;
	private double totalDealPrice;

	public Deal(Customer customer, Date dealDate,
			HashSet<VehicleTransportation> allVehicleTransportation, double shippingCost) {
		super();
		this.dealID = ++counter +"";
		this.customer = customer;
		this.dealDate = dealDate;
		this.allVehicleTransportation = allVehicleTransportation;
		this.shippingCost = shippingCost;
		this.totalDealPrice = totalDealPrice();
	}

	public double totalDealPrice() {
		double temp=0,x=0.0; 
		for(VehicleTransportation c : allVehicleTransportation) {
			if(c!=null)
			temp = temp+ c.getPrice();
		}
		x = temp +getShippingCost();
		if(customer instanceof VIPCustomer)	{	
			VIPCustomer v= (VIPCustomer)customer;
			x=(1-v.getDiscountPercentage())*x;
		
		}
		return x;

	}
	public double GetScore(ScoreCalculator calculator) {
		return calculator.calculate(this.allVehicleTransportation);
		
	}
	
	public static int getCounter() {
		return counter;
	}
	public static void setCounter(int counter) {
		Deal.counter = counter;
	}
	public String getDealID() {
		return dealID;
	}
	public void setDealID(String dealID) {
		this.dealID = dealID;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Date getDealDate() {
		return dealDate;
	}
	public void setDealDate(Date dealDate) {
		this.dealDate = dealDate;
	}
	
	
	public HashSet<VehicleTransportation> getAllVehicleTransportation() {
		return allVehicleTransportation;
	}
	public void setAllVehicleTransportation(HashSet<VehicleTransportation> allVehicleTransportation) {
		this.allVehicleTransportation = allVehicleTransportation;
	}
	public double getShippingCost() {
		return shippingCost;
	}
	public void setShippingCost(double shippingCost) {
		this.shippingCost = shippingCost;
	}
	public double getTotalDealPrice() {
		return totalDealPrice;
	}
	public void setTotalDealPrice(double totalDealPrice) {
		this.totalDealPrice = totalDealPrice;
	}
	@Override
	public String toString() {
		return  "dealID= " + dealID + ", customer= " + customer + " deal Date= "+dealDate +" , totalDealPrice= " + totalDealPrice ;
	}

	@Override
	public int compareTo(Deal o) {
		// TODO Auto-generated method stub
		return this.dealID.compareTo(o.getDealID());
	}
	
	
	
	
	
	

}
