package com.mvc.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Contact {
	@Size(min = 2, max = 3, message = "Country Code Should in range 2 - 3")
	private String countryCode;
	@Pattern(regexp = "^\\d{10}$", message = "Invalid Contact Number")
	private String number;

	public Contact(String countryCode, String number) {
		this.countryCode = countryCode;
		this.number = number;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Contact [countryCode=" + countryCode + ", number=" + number + "]";
	}
}
