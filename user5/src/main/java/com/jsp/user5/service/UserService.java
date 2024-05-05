package com.jsp.user5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jsp.user5.dao.UserDao;
import com.jsp.user5.dto.User;
import com.jsp.user5.exception.UserIdNotFoundException;
import com.jsp.user5.util.ResponseStructure;

@Service
public class UserService {

	@Autowired
	private UserDao dao;

	public ResponseEntity<ResponseStructure<User>> saveUser(User user) {
		User dbuser = dao.saveUser(user);
		ResponseStructure<User> structure = new ResponseStructure<User>();
		structure.setMessage("User data saved successfully");
		structure.setHttpstatus(HttpStatus.CREATED.value());
		structure.setData(dbuser);
		return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<User>> findUser(int id) {
		User dbUser = dao.findUser(id);
		if (dbUser != null) {
//			id is present
			ResponseStructure<User> structure = new ResponseStructure<>();
			structure.setMessage("User Data fetched successfully");
			structure.setHttpstatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
			// return new ResponseEntity<ResponseStructure<User>>(structure,
			// HttpStatus.FOUND);
		} else {
//			ResponseStructure<User> structure = new ResponseStructure<>();
//			structure.setMessage("User Data Not found");
//			structure.setHttpstatus(HttpStatus.NOT_FOUND.value());
//			structure.setData(null);
//			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.NOT_FOUND);
			
			throw new UserIdNotFoundException("sorry fail to fetch data");
		}
	}

	public ResponseEntity<ResponseStructure<User>> deleteUser(int id) {

		User dbUser = dao.deleteUser(id);
		if (dbUser != null) {
//			id is present
			ResponseStructure<User> structure = new ResponseStructure<>();
			structure.setMessage("Data deleted successfully");
			structure.setHttpstatus(HttpStatus.FOUND.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
			// return new ResponseEntity<ResponseStructure<User>>(structure,
			// HttpStatus.FOUND);
		} else {
//			ResponseStructure<User> structure = new ResponseStructure<>();
//			structure.setMessage("User Data Not found");
//			structure.setHttpstatus(HttpStatus.NOT_FOUND.value());
//			structure.setData(null);
//			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.NOT_FOUND);
			
			throw new UserIdNotFoundException("sorry fail to delete data");
		}

	}

	public ResponseEntity<ResponseStructure<User>> updateUser(int id, User user) {

		User dbUser = dao.deleteUser(id);
		if (dbUser != null) {
//			id is present
			ResponseStructure<User> structure = new ResponseStructure<>();
			structure.setMessage("Data updated successfully");
			structure.setHttpstatus(HttpStatus.OK.value());
			structure.setData(dbUser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
			// return new ResponseEntity<ResponseStructure<User>>(structure,
			// HttpStatus.FOUND);
		} else {
//			ResponseStructure<User> structure = new ResponseStructure<>();
//			structure.setMessage("User Data Not found");
//			structure.setHttpstatus(HttpStatus.NOT_FOUND.value());
//			structure.setData(null);
//			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.NOT_FOUND);
			
			throw new UserIdNotFoundException("Sorry fail to update");
		}
	}

	public ResponseEntity<ResponseStructure<List<User>>> findAllUser() {
		List<User> list = dao.findAllUser();
		ResponseStructure<List<User>> structure = new ResponseStructure<>();
		structure.setMessage("User Data found");
		structure.setHttpstatus(HttpStatus.FOUND.value());
		structure.setData(list);
		return new ResponseEntity<ResponseStructure<List<User>>>(structure,HttpStatus.FOUND);
	}

}
