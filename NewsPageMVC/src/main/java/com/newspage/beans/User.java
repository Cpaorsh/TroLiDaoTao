package com.newspage.beans;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

public class User {

  private String max;
  private String username;
  private String password;
  
  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "msv")
  private Sinhvien sinhvien;
  
  public Sinhvien getSinhvien() {
    return sinhvien;
  }
  public void setSinhvien(Sinhvien sinhvien) {
    this.sinhvien = sinhvien;
  }


  @OneToOne(cascade = CascadeType.PERSIST)
  @JoinColumn(name = "mgv")
  private Giangvien giangvien;
  
  public Giangvien getGiangvien() {
    return giangvien;
  }

  public void setGiangvien(Giangvien giangvien) {
    this.giangvien = giangvien;
  }
  
  public String getMax() {
    return max;
  }
  public void setMax(String max) {
    this.max = max;
  }

  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

}
