package com.mydata.quiz.mapper;

import com.mydata.quiz.dto.UserDto;
import com.mydata.quiz.entity.User;

public class UserMapper {
	
	//mapping of user dto to user
	public static User mapToUser(UserDto uDto)
	{
		return new User(uDto.getId(), uDto.getUsername(), uDto.getPassword(), uDto.getQuizzes());
	}
	
	//mapping of user to user dto
	public static UserDto mapToUserDto(User u) 
	{
		return new UserDto(u.getId(), u.getUsername(), u.getPassword() , u.getQuizzes());
	}
	
}
