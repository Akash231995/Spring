package com.mvc.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

public class Customer {

	private @Min(1) int id;
	private @NonNull @Size(min = 4, max = 10) String name;
	private @NonNull @Email String email;
	private @NonNull Contact contact;

	public Customer(@Min(1) int id, @Size(min = 4, max = 10) String name, @Email String email, Contact contact) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.contact = contact;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", contact=" + contact + "]";
	}
}
