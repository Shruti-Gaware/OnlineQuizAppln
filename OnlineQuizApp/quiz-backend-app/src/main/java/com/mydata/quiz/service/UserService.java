package com.mydata.quiz.service;

import java.util.List;

import com.mydata.quiz.dto.UserDto;
import com.mydata.quiz.exception.ResourceNotFoundException;

public interface UserService {

	public UserDto createUser(UserDto userDto);
	public UserDto getUserById(Long id) throws ResourceNotFoundException;
	public List<UserDto> getAllUSers();
	public UserDto updateUser(Long id, UserDto userDto) throws ResourceNotFoundException;
	public void deleteUser(Long id) throws ResourceNotFoundException;
		
}
