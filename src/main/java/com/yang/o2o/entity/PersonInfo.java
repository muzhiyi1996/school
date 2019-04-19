package com.yang.o2o.entity;

import java.util.Date;

public class PersonInfo {

	private Long userId;		//用户ID
	private String name;		//姓名
	private Date birthday;		//生日
	private String gender;		//性别 
	
	/* private String phone; */
	
	private String email;		//邮箱
	private String profileImg;	//头像地址
	
	/*
	 * private Integer customerFlag; 
	 * private Integer shopOwnerFlag;
	 * private Integer adminFlag;
	 */
	
	private Date createTime;	//创建时间
	private Date lastEditTime;	//操作时间
	private Integer enableStatus;
	private Integer userType;	//用户类别    1.顾客 2.店家  3.超级管理员

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	/*
	 * public String getPhone() { return phone; }
	 * 
	 * public void setPhone(String phone) { this.phone = phone; }
	 */

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProfileImg() {
		return profileImg;
	}

	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}

	/*
	 * public Integer getCustomerFlag() { return customerFlag; }
	 * 
	 * public void setCustomerFlag(Integer customerFlag) { this.customerFlag =
	 * customerFlag; }
	 * 
	 * public Integer getShopOwnerFlag() { return shopOwnerFlag; }
	 * 
	 * public void setShopOwnerFlag(Integer shopOwnerFlag) { this.shopOwnerFlag =
	 * shopOwnerFlag; }
	 * 
	 * public Integer getAdminFlag() { return adminFlag; }
	 * 
	 * public void setAdminFlag(Integer adminFlag) { this.adminFlag = adminFlag; }
	 */

	public Date getCreateTime() {
		return createTime;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

	public Integer getEnableStatus() {
		return enableStatus;
	}

	public void setEnableStatus(Integer enableStatus) {
		this.enableStatus = enableStatus;
	}

}
