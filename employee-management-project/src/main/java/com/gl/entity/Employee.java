package com.gl.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	// define fields

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "employee_first_name")
	private String empFName;

	@Column(name = "employee_last_name")
	private String empLName;

	@Column(name = "employee_email")
	private String empEmail;

	public Employee() {

	}

	public Employee(int id, String empfName, String emplName, String empMail) {
		this.id = id;
		this.empFName = empfName;
		this.empLName = emplName;
		this.empEmail = empMail;
	}

	public Employee(String empfName, String emplName, String empMail) {
		this.empFName = empfName;
		this.empLName = emplName;
		this.empEmail = empMail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpFName() {
		return empFName;
	}

	public void setEmpFName(String empFName) {
		this.empFName = empFName;
	}

	public String getEmpLName() {
		return empLName;
	}

	public void setEmpLName(String empLName) {
		this.empLName = empLName;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

}
