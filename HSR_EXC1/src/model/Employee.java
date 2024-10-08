package model;

import java.io.Serializable;
import java.util.Date;

import utils.Gender;

public class Employee extends Person implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date dateOfStartWork;
	private Double salary;
	private Department dep;
	private String userName;
	private String password;

	public Employee() {
		super();
		
	}

	public Employee(String iD, String firstName, String lastName, String phoneNumber, Gender gender,
			Date dateOfStartWork, Double salary, Department dep, int yearOfBirth , String userName , String password) {
		super(iD, firstName, lastName, phoneNumber, gender,yearOfBirth);
		this.dateOfStartWork = dateOfStartWork;
		this.salary = salary;
		this.dep = dep;
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getDateOfStartWork() {
		return dateOfStartWork;
	}
	public void setDateOfStartWork(Date dateOfStartWork) {
		this.dateOfStartWork = dateOfStartWork;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Department getDep() {
		return dep;
	}
	public void setDep(Department dep) {
		this.dep = dep;
	} 
	@Override
	public String toString() {
		return super.toString() + ", salary= " + salary  +" Department= " +getDep().getDepartmentID()+" userName= "+this.userName + ", password= "+this.password;
	}

	
	
	
	

}
