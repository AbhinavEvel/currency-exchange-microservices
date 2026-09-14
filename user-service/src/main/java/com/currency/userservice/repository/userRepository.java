package com.currency.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.currency.userservice.entity.Users;

public interface  userRepository extends JpaRepository<Users,Long> {
	Optional<Users> findByUsername(String username);
	boolean existsByUsername(String username);
	boolean existsByEmail(String email);

}
