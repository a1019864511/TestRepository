package com.example.demo.Entity;


public class Admin {

  private String adminUsername;
  private String adminPassword;
  private String adminCompetence;
  private long adminId;

  @Override
  public String toString() {
    return "Admin{" +
            "adminUsername='" + adminUsername + '\'' +
            ", adminPassword='" + adminPassword + '\'' +
            ", adminCompetence='" + adminCompetence + '\'' +
            ", adminId=" + adminId +
            '}';
  }

  public String getAdminUsername() {
    return adminUsername;
  }

  public void setAdminUsername(String adminUsername) {
    this.adminUsername = adminUsername;
  }


  public String getAdminPassword() {
    return adminPassword;
  }

  public void setAdminPassword(String adminPassword) {
    this.adminPassword = adminPassword;
  }


  public String getAdminCompetence() {
    return adminCompetence;
  }

  public void setAdminCompetence(String adminCompetence) {
    this.adminCompetence = adminCompetence;
  }


  public long getAdminId() {
    return adminId;
  }

  public void setAdminId(long adminId) {
    this.adminId = adminId;
  }

}
