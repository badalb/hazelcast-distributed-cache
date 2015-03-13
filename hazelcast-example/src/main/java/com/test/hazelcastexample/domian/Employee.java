package com.test.hazelcastexample.domian;

import java.io.Serializable;

public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1370355392731490984L;

	private String firstName;

	public Employee() {

	}

	public Employee(String name) {
		this.firstName = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

}
