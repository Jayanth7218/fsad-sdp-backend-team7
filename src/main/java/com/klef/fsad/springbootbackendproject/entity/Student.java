package com.klef.fsad.springbootbackendproject.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "student_table")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false,unique = true)
    private String contact;
    private String resetToken;
    private Long tokenExpiry;

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  public String getContact() {
      return contact;  
  }

  public void setContact(String contact) {
      this.contact = contact;  
  }
  public int getId() {
    return id;
  }
  public String getResetToken() {
	return resetToken;
  }
  public void setResetToken(String resetToken) {
	this.resetToken = resetToken;
  }
  public Long getTokenExpiry() {
	return tokenExpiry;
  }
  public void setTokenExpiry(Long tokenExpiry) {
	this.tokenExpiry = tokenExpiry;
  }
  
    
}