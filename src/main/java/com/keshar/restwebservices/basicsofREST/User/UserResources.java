package com.keshar.restwebservices.basicsofREST.User;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

		User singleUser = serviceDao.getSingleUser(id);
		
		if(singleUser==null) {
			throw new UserNotFoundException("id-"+id);
		}
		return singleUser;

	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {

		User user = serviceDao.deleteUser(id);
		
		if(user==null) {
			throw new UserNotFoundException("id-"+id);
		}
	

	}
	
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User saveUser = serviceDao.saveUser(user);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(saveUser.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
//		return saveUser;
	}
	

}
