package com.ajel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajel.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
