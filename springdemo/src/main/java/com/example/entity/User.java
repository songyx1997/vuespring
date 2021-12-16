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
    * 用户编号
    */
    private String userId;
    /**
    * 用户名
    */
    private String userName;
    /**
    * 小组编号
    */
    private String groupId;
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
    * 用户角色（0-admin、1-general）
    */
    private String userRole;
    /**
    * 最后登录时间
    */
    private Date lastLoginTime;
    /**
    * 备用字段
    */
    private String ext1;
    /**
    * 备用字段
    */
    private String ext2;
    /**
    * 备用字段
    */
    private String ext3;
    /**
    * 创建时间
    */
    private Date creationTime;
    /**
    * 更新时间
    */
    private Date updateTime;
    
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

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
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

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
