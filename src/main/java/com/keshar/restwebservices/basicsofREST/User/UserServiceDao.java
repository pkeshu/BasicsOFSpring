package com.keshar.restwebservices.basicsofREST.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserServiceDao {

	private static List<User> users=new ArrayList<>();
	private static int userCount=3;

	static {
		users.add(new User(1,"Keshar paudel",new Date()));
		users.add(new User(2,"Krishna paudel",new Date()));
		users.add(new User(3,"Hari bahadur Thapa",new Date()));
	}

	public  List<User> getUsers() {
		return users;
	}

	public  User saveUser(User user) {
		if(user.getId()==null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}

	public User getSingleUser(int id) {
		for(User user:users) {
			if(user.getId()==id) {
				return user;

			}
		}
		return null;
	}



}
