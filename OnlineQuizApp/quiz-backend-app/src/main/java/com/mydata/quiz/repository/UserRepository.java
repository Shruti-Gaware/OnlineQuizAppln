package com.mydata.quiz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mydata.quiz.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	
	Optional<User> findByUsername(String username);

}
