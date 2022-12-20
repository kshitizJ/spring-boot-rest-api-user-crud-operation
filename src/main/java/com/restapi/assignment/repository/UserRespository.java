package com.restapi.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.assignment.model.User;

/**
 * UserRespository
 */
public interface UserRespository extends JpaRepository<User, Integer> {

}