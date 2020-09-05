package com.mindex.challenge.data;

import java.util.Date;

public class Compensation {
	
	private String compensationID;
	private Employee employee;
	private double salary;
	private Date effectiveDate;
	
	public Compensation() {
		
	}

	public Compensation(Employee employee, double salary, Date effectiveDate) {
		this.employee = employee;
		this.salary = salary;
		this.effectiveDate = effectiveDate;
	}
	
	
	
	/**
	 * @return the compensationID
	 */
	public String getCompensationID() {
		return compensationID;
	}

	/**
	 * @param compensationID the compensationID to set
	 */
	public void setCompensationID(String compensationID) {
		this.compensationID = compensationID;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}
	
	/**
	 * set the salary
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the effectiveDate
	 */
	public Date getEffectiveDate() {
		return effectiveDate;
	}

	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(Date effectiveDate) {
		this.effectiveDate = effectiveDate;
	}

	@Override
	public String toString() {
		return "Compensation [employee=" + employee + ", salary=" + salary + ", effectiveDate=" + effectiveDate + "]";
	}

}
