package com.restapi.assignment.model;

import static javax.persistence.GenerationType.AUTO;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "assignment")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
   @Id
   @GeneratedValue(strategy = AUTO)
   @Column(nullable = false, updatable = false)
   private Integer id;

   private String name;

   private String address;

   private String pincode;

   private String state;

   @Column(columnDefinition = "TIMESTAMP")
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss", timezone = "Asia/Kolkata")
   private LocalDateTime registerDate;
}
