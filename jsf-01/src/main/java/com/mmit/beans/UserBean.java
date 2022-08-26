package com.mmit.beans;

import java.io.Serializable;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class UserBean implements Serializable{ // userBean
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String password;
	private String message;
	
	public UserBean() {
		System.err.println("This is user bean constructor");
	}
	public void display() {
		System.out.println("This is display method");
	}
	public void login() {
		message = (name.equals("admin") && password.equals("123")
				? "Valid User"
				: "Invalid User");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
