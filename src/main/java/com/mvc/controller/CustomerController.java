package com.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.model.Customer;
import com.mvc.model.Response;
import com.mvc.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> get(@PathVariable(required = true, name = "id") int id) {
		Customer customer = customerService.get(id);
		return ResponseEntity.ok(customer);
	}

	@PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> register(@Valid @RequestBody Customer customer) {
		boolean isRegistered = customerService.register(customer);
		if (isRegistered) {
			return ResponseEntity.ok(new Response(HttpStatus.NO_CONTENT, "Registration Failed "));
		}
		return ResponseEntity.ok(new Response(HttpStatus.CREATED, "Registered SuccessFully"));
	}
	
	@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> update(@RequestBody Customer customer) {
		boolean isUpdated = customerService.update(customer);
		if (isUpdated) {
			return ResponseEntity.ok(new Response(HttpStatus.NOT_MODIFIED, "Update Failed "));
		}
		return ResponseEntity.ok(new Response(HttpStatus.CREATED, "Updated SuccessFully"));
	}
	
	@DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> delete(@PathVariable(required = true, name = "id") int id) {
		boolean isDeleted = customerService.delete(id);
		if (isDeleted) {
			return ResponseEntity.ok(new Response(HttpStatus.NO_CONTENT, "Delete Failed "));
		}
		return ResponseEntity.ok(new Response(HttpStatus.valueOf(200), "Deleted SuccessFully"));
	}
}
