package com.restapi.assignment.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.assignment.model.User;
import com.restapi.assignment.repository.UserRespository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

   @Autowired
   private UserRespository userRespository;

   public List<User> getAllUser() {
      log.info("Getting all the users");
      return userRespository.findAll();
   }

   public User getUser(Integer id) throws Exception {
      log.info("Checking if the user exist or not with id " + id);
      User user = userRespository.findById(id).get();
      if (user == null)
         throw new Exception("User not found");
      return user;
   }

   public User registerUser(String name, String address, String pincode, String state) {
      log.info("Creating a new user.");
      User user = new User();
      user.setName(name);
      user.setAddress(address);
      user.setPincode(pincode);
      user.setState(state);
      user.setRegisterDate(LocalDateTime.now());
      return userRespository.save(user);
   }

   public User updateUser(Integer id, String name, String address, String pincode, String state) throws Exception {
      log.info("Checking if the user exist or not with id " + id);
      User user = userRespository.findById(id).get();
      if (user == null)
         throw new Exception("User not found");
      log.info("Updating the user credentials.");
      user.setName(name);
      user.setAddress(address);
      user.setPincode(pincode);
      user.setState(state);
      return userRespository.save(user);
   }

   public User deleteUser(Integer id) throws Exception {
      log.info("Checking if the user exist or not with id " + id);
      User user = userRespository.findById(id).get();
      if (user == null)
         throw new Exception("User not found");
      userRespository.deleteById(id);
      return user;
   }

}
