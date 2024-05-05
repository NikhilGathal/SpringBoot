
package com.jsp.user5.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.user5.dto.User;
import com.jsp.user5.repo.UserRepo;

@Repository
public class UserDao {

	// for output on console
//	@Autowired
//	private UserRepo repo;
//	
//	public void saveUser(User user)
//	{
//		repo.save(user);
//	}

	// to return saved object on postman

	@Autowired
	private UserRepo repo;

	public User saveUser(User user) {
		return repo.save(user);
	}
	
	
	
	public User findUser(int id) {
		Optional<User> optional = repo.findById(id);
		if (optional.isPresent()) {
			User user = optional.get();
			return user;
		}
		return null;
	}

	public User deleteUser(int id) {

		Optional<User> optional = repo.findById(id);
		if (optional.isPresent()) {
			User user = optional.get();
			repo.delete(user);
			return user;
		}
		return null;
	}

	public User updateUser(int id, User user) {
		Optional<User> optional = repo.findById(id);
		if (optional.isPresent()) {
			user.setId(id);
			return repo.save(user);
		}
		return null;
	}

	public List<User> findAllUser() {
		return repo.findAll();
	}

}
