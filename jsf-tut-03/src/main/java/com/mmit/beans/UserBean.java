package com.mmit.beans;

import com.mmit.services.UserService;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped
public class UserBean {
	private String email;
	private String password;
	//@Inject
	private UserService service = new UserService();
	@Inject
	private FacesContext context;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void checkEmail() {
		//System.out.println("This is action listener method");
		if(service.validateEmail(email)) { // error
			FacesMessage message = new FacesMessage("Email is already used");
			//formId:componentId
			context.addMessage("reg-form:email", message);
			context.validationFailed();
		}
		
	}
	public String register() {
		// save
		if(context.isValidationFailed())
			return null;
		service.save(email, password);
		return "/list?faces-redirect=true";
	}
}
