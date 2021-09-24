package com.example.bean;

/**
 * <p>Title: User</p>
 * <p>Description: 用户类</p>
 * @author songy
 * @date 2021/9/24
 */
public class User {
    private String userId;
    private String userName;
    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
