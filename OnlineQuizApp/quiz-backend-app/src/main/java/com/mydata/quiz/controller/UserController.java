package com.mydata.quiz.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mydata.quiz.dto.UserDto;
import com.mydata.quiz.exception.ResourceNotFoundException;
import com.mydata.quiz.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/user")
public class UserController {
	
	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	//building rest api
	@PostMapping
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
	{
		UserDto savedUser = userService.createUser(userDto);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Long id) throws ResourceNotFoundException
	{
		UserDto savedUser = userService.getUserById(id);
		return ResponseEntity.ok(savedUser);
		
	}
	
	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUsers()
	{
		List<UserDto> allUser = userService.getAllUSers();
		return ResponseEntity.ok(allUser);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<UserDto> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) throws ResourceNotFoundException
	{
		UserDto updatedUser = userService.updateUser(id, userDto);
		return ResponseEntity.ok(updatedUser);	
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) throws ResourceNotFoundException
	{
		userService.deleteUser(id);
		return ResponseEntity.ok("User Deleted Successfully!!!");
		
	}
	
	/*@PostMapping("/login")
	public ResponseEntity<UserDto> loginUser(@RequestBody UserDto userDto)throws ResourceNotFoundException
	{
		UserDto loginUser = userService.loginUser(userDto);
		return ResponseEntity.ok(loginUser);
	}*/
}
