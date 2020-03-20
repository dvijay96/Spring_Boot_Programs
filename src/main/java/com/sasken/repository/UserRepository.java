package com.sasken.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sasken.model.User;

//@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);

}
