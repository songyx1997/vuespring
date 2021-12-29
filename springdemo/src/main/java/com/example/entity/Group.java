package com.example.entity;

import java.io.Serializable;

/**
 * <p>Title: Group</p>
 * <p>Description: 小组类</p>
 * @author songy
 * @date 2021/12/14
 */
public class Group implements Serializable {
    /**
    * 小组编号
    */
    private String groupId;
    /**
    * 小组名称
    */
    private String groupName;
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
    private String creationTime;
    /**
    * 更新时间
    */
    private String updateTime;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
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

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}
