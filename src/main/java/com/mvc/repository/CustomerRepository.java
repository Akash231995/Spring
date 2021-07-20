package com.mvc.repository;

import java.sql.PreparedStatement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.mvc.exception.InsertFailedException;
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
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int contactInsertedCount = jdbcTemplate.update(connection -> {
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO CONTACT(contrycode,number) VALUES(?, ?)", new String[] { "id" });
			preparedStatement.setString(1, customer.getContact().getCountryCode());
			preparedStatement.setString(1, customer.getContact().getNumber());
			return preparedStatement;
		}, keyHolder);
		if (contactInsertedCount == 0) {
			throw new InsertFailedException("Contact Insertion Failed");
		}
		int customerInsertedCount = jdbcTemplate.update("INSERT INTO CUSTOMER(name,email,contactid) VALUES(?,?,?)",
				new Object[] { customer.getName(), customer.getEmail(), keyHolder.getKey() });

		if (customerInsertedCount == 0) {
			throw new InsertFailedException("Contact Insertion Failed");
		}
		return true;
	}

	public boolean update(Customer customer) {
		int customerUpdated = jdbcTemplate.update("UPDATE CUSTOMER SET name = ?, email = ? WHERE id = ?",
				new Object[] { customer.getName(), customer.getEmail() });
		return customerUpdated != 0;
	}

	public boolean delete(int id) {
		int customerDeletedCount = jdbcTemplate.update("DELETE FROM CUSTOMER WHERE id = ?", new Object[] { id });
		if(customerDeletedCount == 0) throw new InsertFailedException();
		return false;
	}

}
