package com.example.entity;

import java.io.Serializable;

/**
 * <p>Title: StandUpItemRecord</p>
 * <p>Description: 站会项目记录类</p>
 * @author songy
 * @date 2021/12/14
 */
public class StandUpItemRecord implements Serializable {
    /**
    * 无意义主键
    */
    private String id;
    /**
    * 当前用户小组编号
    */
    private String currentUserGroupId;
    /**
    * 提出人编号
    */
    private String proposerUserId;
    /**
    * 负责人编号
    */
    private String principalUserId;
    /**
    * 项目类型(0-风险项、1-待改进项、2-跟进项)
    */
    private String itemStyle;
    /**
    * 项目说明
    */
    private String itemDescription;
    /**
    * 措施
    */
    private String measure;
    /**
    * 状态(0-待处理、1-活动中、2-已关闭)
    */
    private String state;
    /**
    * 优先级(0-低、1-中、2-高)
    */
    private String priority;
    /**
    * 备注
    */
    private String remark;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCurrentUserGroupId() {
        return currentUserGroupId;
    }

    public void setCurrentUserGroupId(String currentUserGroupId) {
        this.currentUserGroupId = currentUserGroupId;
    }

    public String getProposerUserId() {
        return proposerUserId;
    }

    public void setProposerUserId(String proposerUserId) {
        this.proposerUserId = proposerUserId;
    }

    public String getPrincipalUserId() {
        return principalUserId;
    }

    public void setPrincipalUserId(String principalUserId) {
        this.principalUserId = principalUserId;
    }

    public String getItemStyle() {
        return itemStyle;
    }

    public void setItemStyle(String itemStyle) {
        this.itemStyle = itemStyle;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
