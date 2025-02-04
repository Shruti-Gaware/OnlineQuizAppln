package com.mydata.quiz.service;

import java.util.List;


import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.mydata.quiz.dto.UserDto;
import com.mydata.quiz.entity.User;
import com.mydata.quiz.exception.ResourceNotFoundException;
import com.mydata.quiz.mapper.UserMapper;
import com.mydata.quiz.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	//inject user repository using constructor
	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDto createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		User user = UserMapper.mapToUser(userDto);
		User savedUser = userRepository.save(user);
		UserDto newUser = UserMapper.mapToUserDto(savedUser);
		return newUser;
	}

	@Override
	public UserDto getUserById(Long id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findById(id)
				.orElseThrow(() ->
				new ResourceNotFoundException("User is not exists with given id : "+ id));
		return UserMapper.mapToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUSers() {
		// TODO Auto-generated method stub
		List<User> allUser = userRepository.findAll();
		List<UserDto> savedUser = allUser.stream()
				.map(user -> UserMapper.mapToUserDto(user))
				.collect(Collectors.toList());
		return savedUser;
		
		//List<UserDto> savedUser = new ArrayList<>();
		/*for(User user : allUser)
		{
			UserDto userDto = UserMapper.mapToUserDto(user);
			savedUser.add(userDto);
		}*/	
	}

	
	@Override
	public UserDto updateUser(Long id, UserDto userDto) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		User u = userRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("User is not exists with given id :" + id));
		u.setUsername(userDto.getUsername());
		u.setPassword(userDto.getPassword());
				
		User updatedUser = userRepository.save(u);
		return UserMapper.mapToUserDto(updatedUser);
	}

	@Override
	public void deleteUser(Long id) throws ResourceNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findById(id).orElseThrow(
				()-> new ResourceNotFoundException("User is not exists with given id :" + id));
		userRepository.deleteById(id);
	}
}
