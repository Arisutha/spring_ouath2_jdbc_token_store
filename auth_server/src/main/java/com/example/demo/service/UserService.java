package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {
	List<User> findAll();
	List<User> findAllUser();
	void insertUser(User user);
	void updateUser(User user);
	User getUserById(User user);
	void deleteUserById(Integer id);
}
