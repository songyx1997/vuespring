package com.example.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>Title: User</p>
 * <p>Description: 用户表(User)实体类</p>
 * @author songy
 * @date 2021/9/24
 */
public class User implements Serializable {
    /**
    * 无意义主键
    */
    private String id;
    /**
    * 用户名
    */
    private String userName;
    /**
    * 密码
    */
    private String userPassword;
    /**
    * 手机号码
    */
    private String userPhone;
    /**
    * 用户邮箱
    */
    private String userEmail;
    /**
    * 创建时间
    */
    private Date creationTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}
