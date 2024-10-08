package model;

import java.io.Serializable;
import java.util.Date;

import utils.Gender;

public class DepartmentManager extends Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date appointmentDate;
	private double bonus;

	public DepartmentManager(String iD, String firstName, String lastName, String phoneNumber, Gender gender,
			Date dateOfStartWork, double salary, Department dep, int yearOfBirth,String userName,String password, Date appointmentDate, double bonus) {
		super(iD, firstName, lastName, phoneNumber, gender, dateOfStartWork, salary, dep, yearOfBirth,userName,password);
		this.appointmentDate = appointmentDate;
		this.bonus = bonus;
	}
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public double getBonus() {
		return bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	@Override
	public String toString() {
		return super.toString()+" , bonus=" + bonus;
	}
	public DepartmentManager() {
		super();
		
	}
	
	

}
