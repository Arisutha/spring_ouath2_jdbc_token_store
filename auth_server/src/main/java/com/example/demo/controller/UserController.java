package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ApiResponse;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController{
	
	@Autowired
	private UserService userServiceImpl;
	
    @GetMapping("/listUser")
    @PreAuthorize("hasRole('ROLE_PRODUCT_ADMIN')")
    public ResponseEntity<ApiResponse> findAll() {
    	LOG.info("find All User");
    	try {
    		List<User> userList = this.userServiceImpl.findAllUser();
			return new ResponseEntity<ApiResponse>(new ApiResponse(200, "OK", userList), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST);
		}
    }
    
    @GetMapping("/getUserById")
    @PreAuthorize("hasRole('ROLE_PRODUCT_ADMIN')")
    public ResponseEntity<ApiResponse> getUserById(@RequestBody String data){
    	LOG.info("get User Id");
    	try {
    		User user = objectMapper.readValue(data, User.class);
			return new ResponseEntity<ApiResponse>(new ApiResponse(200, "OK", userServiceImpl.getUserById(user)), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST);
		}
    }
    
    @PostMapping("/deleteByUserId")
    @PreAuthorize("hasRole('ROLE_PRODUCT_ADMIN')")
    public ResponseEntity<ApiResponse> deleteByUserId(@RequestBody String data){
    	LOG.info("get User Id");
    	try {
    		User user = objectMapper.readValue(data, User.class);
    		this.userServiceImpl.deleteUserById(user.getId());
			return new ResponseEntity<ApiResponse>(new ApiResponse(200, "OK"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST);
		}
    }
    
    @PostMapping("/insertUser")
    @PreAuthorize("hasRole('ROLE_PRODUCT_ADMIN')")
    public ResponseEntity<ApiResponse> insertUser(@RequestBody String data){
    	LOG.info("get User Id");
    	try {
    		User user = objectMapper.readValue(data, User.class);
    		this.userServiceImpl.insertUser(user);
			return new ResponseEntity<ApiResponse>(new ApiResponse(200, "OK"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST);
		}
    }
    
    @GetMapping("/updateUser")
    @PreAuthorize("hasRole('ROLE_PRODUCT_ADMIN')")
    public ResponseEntity<ApiResponse> updateUser(@RequestBody String data){
    	LOG.info("get User Id");
    	try {
    		User temp = objectMapper.readValue(data, User.class);
    		this.userServiceImpl.updateUser(temp);
    		
			return new ResponseEntity<ApiResponse>(new ApiResponse(200, "OK"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ApiResponse>(HttpStatus.BAD_REQUEST);
		}
    }
    
}
