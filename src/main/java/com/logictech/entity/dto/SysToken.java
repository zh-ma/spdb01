package com.logictech.entity.dto;

import java.util.Date;

public class SysToken {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_token.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_token.access_token
     *
     * @mbggenerated
     */
    private String accessToken;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_token.expiration
     *
     * @mbggenerated
     */
    private Long expiration;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_token.user_id
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_token.deleted
     *
     * @mbggenerated
     */
    private String deleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_token.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_token.create_user
     *
     * @mbggenerated
     */
    private String createUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_token.update_time
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_token.update_user
     *
     * @mbggenerated
     */
    private String updateUser;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_token.id
     *
     * @return the value of sys_token.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_token.id
     *
     * @param id the value for sys_token.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_token.access_token
     *
     * @return the value of sys_token.access_token
     *
     * @mbggenerated
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_token.access_token
     *
     * @param accessToken the value for sys_token.access_token
     *
     * @mbggenerated
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken == null ? null : accessToken.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_token.expiration
     *
     * @return the value of sys_token.expiration
     *
     * @mbggenerated
     */
    public Long getExpiration() {
        return expiration;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_token.expiration
     *
     * @param expiration the value for sys_token.expiration
     *
     * @mbggenerated
     */
    public void setExpiration(Long expiration) {
        this.expiration = expiration;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_token.user_id
     *
     * @return the value of sys_token.user_id
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_token.user_id
     *
     * @param userId the value for sys_token.user_id
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_token.deleted
     *
     * @return the value of sys_token.deleted
     *
     * @mbggenerated
     */
    public String getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_token.deleted
     *
     * @param deleted the value for sys_token.deleted
     *
     * @mbggenerated
     */
    public void setDeleted(String deleted) {
        this.deleted = deleted == null ? null : deleted.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_token.create_time
     *
     * @return the value of sys_token.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_token.create_time
     *
     * @param createTime the value for sys_token.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_token.create_user
     *
     * @return the value of sys_token.create_user
     *
     * @mbggenerated
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_token.create_user
     *
     * @param createUser the value for sys_token.create_user
     *
     * @mbggenerated
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_token.update_time
     *
     * @return the value of sys_token.update_time
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_token.update_time
     *
     * @param updateTime the value for sys_token.update_time
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_token.update_user
     *
     * @return the value of sys_token.update_user
     *
     * @mbggenerated
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_token.update_user
     *
     * @param updateUser the value for sys_token.update_user
     *
     * @mbggenerated
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }
}