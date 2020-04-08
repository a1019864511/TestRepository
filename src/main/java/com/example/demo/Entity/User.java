package com.example.demo.Entity;

/**
 * @author xing.liu
 * @Verion 1.0
 * @TIME 2020/3/2
 */
public class User {
    //
    private String userId;
    private String userEmail;
    private String userPwd;
    private String userName;
    private String userPhone;
    private double userMoney;
    private String userGender;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userEmail='" + userEmail + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userMoney=" + userMoney +
                ", userGender='" + userGender + '\'' +
                '}';
    }

    public User(String userId, String userEmail, String userPwd, String userName, String userPhone, String userGender) {
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPwd = userPwd;
        this.userName = userName;
        this.userPhone = userPhone;
        this.userGender = userGender;
    }
    //基础构造方法
    public User() {

    }
    //得到作者的id
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserName() {
        return userName;
    }
    //设置用户名字
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public double getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(double userMoney) {
        this.userMoney = userMoney;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }
}
