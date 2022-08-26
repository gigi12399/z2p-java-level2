package com.mmit.services;

import java.util.List;

import jakarta.ejb.Stateless;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named
@ApplicationScoped
public class UserService {
	private List<String> emails = List.of(
			"user1@gmail.com",
			"user2@gmail.com"
			);
	
	public boolean validateEmail(String email) {
		if(emails.contains(email))
			return true;
		return false;
	}

	public void save(String email, String password) {
		// TODO Auto-generated method stub
		System.out.println("Save to database");
	}
}
