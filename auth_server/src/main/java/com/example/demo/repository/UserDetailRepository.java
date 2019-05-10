package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.model.User;

public interface UserDetailRepository extends JpaRepository<User, Integer>{

	Optional<User> findByUsername(String username);
	
	@Modifying
	@Query("update User u set u.firstName = ?1, u.lastName = ?2 where u.id = ?3")
	void setUserById(String firstName, String lastName, Integer id);
	
	@Query("select user from User user where user.deletedDate is null ")
	List<User> findAllUser();
	
}
