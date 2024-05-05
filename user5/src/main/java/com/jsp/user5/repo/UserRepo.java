package com.jsp.user5.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.user5.dto.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
