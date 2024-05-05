package com.jsp.user5.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.user5.dao.UserDao;
import com.jsp.user5.dto.User;
import com.jsp.user5.service.UserService;
import com.jsp.user5.util.ResponseStructure;

@RestController
public class UserController {
	
	
	@Autowired
	private UserDao dao;
	
	
	@Autowired
	private UserService service;
	
	// for output on console
	
//	@RequestMapping("/save")		// config url
//	public User saveUser(@RequestBody User user)
//	{
//		System.out.println("Yes Created api");
//		dao.saveUser(user);
//		return user;
//	}
	
	
	public User finduser(@RequestParam int id)
	{
	
		return dao.findUser(id);
	}
	
	
	
	// for output on postman
	
	@PostMapping("/save")		// config url
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user)
	{
		//System.out.println("Yes Created api");
		return service.saveUser(user);
	}
	
	@GetMapping("/find")		
	public ResponseEntity<ResponseStructure<User>> findUser(@RequestParam int id)
	{
		return service.findUser(id);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<User>> deleteUser(@RequestParam int id)
	{
		return service.deleteUser(id);
		
	}
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<User>> updateUser(@RequestParam int id , @RequestBody User user)
	{
		return service.updateUser(id,user);
	}
	
	@GetMapping("/findall")
	public ResponseEntity<ResponseStructure<List<User>>> findAll()
	{
		return service.findAllUser();
	}
	

}
