package com.restapi.assignment.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.assignment.model.User;
import com.restapi.assignment.service.UserService;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

   @Autowired
   private UserService userService;

   @GetMapping()
   public List<User> getAllUsers() {
      return userService.getAllUser();
   }

   @GetMapping("/find/{id}")
   public User getUser(@PathVariable("id") Integer id) throws Exception {
      return userService.getUser(id);
   }

   @PostMapping("/register")
   public User registerUser(@RequestBody Map<String, Object> addUserDetails) {
      return userService.registerUser((String) addUserDetails.get("name"), (String) addUserDetails.get("address"),
            (String) addUserDetails.get("pincode"), (String) addUserDetails.get("state"));
   }

   @PostMapping("/update")
   public User updateUser(@RequestBody Map<String, Object> addUserDetails) throws Exception {
      return userService.updateUser((Integer) addUserDetails.get("id"), (String) addUserDetails.get("name"),
            (String) addUserDetails.get("address"), (String) addUserDetails.get("pincode"),
            (String) addUserDetails.get("state"));
   }

   @DeleteMapping("/delete/{id}")
   public User deleteUser(@PathVariable("id") Integer id) throws Exception {
      return userService.deleteUser(id);
   }

}
