package com.mvc.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mvc.model.Contact;
import com.mvc.model.Customer;

@Repository
public class CustomerRepository {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Customer get(int id) {
		return jdbcTemplate.queryForObject("SELECT * FROM CUSTOMER WHERE id = ?", (rs, rowNum) -> {
			return new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), new Contact("+91", "8056239080"));
		}, new Object[] { id });
	}

	public boolean register(Customer customer) {
		jdbcTemplate.update("INSERT INTO CONTACT(?,?,?)",
				new Object[] { customer.getContact().getCountryCode(), customer.getContact().getNumber() });
		return false;
	}

	public boolean update(Customer customer) {
		return false;
	}

	public boolean delete(int id) {
		return false;
	}

}
