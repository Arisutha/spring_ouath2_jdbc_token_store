package com.example.demo.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.User;
import com.example.demo.repository.UserDetailRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDetailRepository userDetailRepository;

	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return this.userDetailRepository.findAll();
	}

	@Override
	public void insertUser(User user) {
		this.userDetailRepository.save(user);
	}

	@Override
	public void updateUser(User user) {
		User temp = this.getUserById(user);
		if(temp!= null) {
			temp.setFirstName(user.getFirstName());
			temp.setLastName(user.getLastName());
			temp.setAge(user.getAge());
			temp.setSalary(user.getSalary());
			temp.setChangeBy("SISTEM");
			temp.setChangeDate(new Date(new java.util.Date().getTime()));
			
			this.userDetailRepository.save(temp);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public User getUserById(User user) {
		return this.userDetailRepository.getOne(user.getId());
	}

	@Override
	public void deleteUserById(Integer id) {
		User temp = this.userDetailRepository.getOne(id);
		if(temp!= null) {
			temp.setDeletedby("SISTEM");
			temp.setDeletedDate(new Date(new java.util.Date().getTime()));
			this.userDetailRepository.save(temp);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<User> findAllUser() {
		return this.userDetailRepository.findAllUser();
	}

}
