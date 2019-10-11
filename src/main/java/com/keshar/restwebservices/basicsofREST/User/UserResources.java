package com.keshar.restwebservices.basicsofREST.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResources {
	
	@Autowired
	private UserServiceDao serviceDao;

	@GetMapping(path = "/users")
	public List<User> retriveAllUsers(){
		return serviceDao.getUsers();
	}
	@GetMapping("/users/{id}")
	public User retriveUser(@PathVariable int id) {

		return serviceDao.getSingleUser(id);

	}
	
	

}
