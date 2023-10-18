package com.newspage.beans;

public class User {

  private int id;
  private String username;
  private String password;
  private String name;
  private String email;
  private String role;
  private int phone;

  
  
  public int getId() {
	    return id;
	  }
	  public void setId(int id) {
	    //System.out.println("id: " + id);
	    this.id = id;
	  }

  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    //System.out.println("username: " + username);
    this.username = username;
  }

  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    System.out.println("name: " + name);
    this.name = name;
  }

  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  public String getRole() {
    return role;
  }
  public void setRole(String role) {
    this.role = role;
  }

  public int getPhone() {
    return phone;
  }
  public void setPhone(int phone) {
    this.phone = phone;
  }
}
