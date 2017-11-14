/**
 * @filename Employee.java
 * @directory /src/main/java/com/jzxtech/web/app/entity
 * @package com.jzxtech.web.app.entity
 * @description 文件描述
 * @author 胡正卫
 * @date 2017-10-29 15:56:44
 * @version v0.1
 */
package com.jzxtech.web.app.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author 胡正卫
 */
@Table(name = "t_org_employee")
public class Employee {

	/** 主键序号 */
	@Id
	private Integer id;

	/** 姓名 */
	@Column
	private String name;

	/** 性别 */
	@Column
	private Integer gender;

	/** 出生日期 */
	@Column
	private Date birthdate;

	/** 电话号码 */
	@Column
	private String phone;

	/** QQ号码 */
	@Column
	private String qq;

	/** 电子邮箱 */
	@Column
	private String email;

	/** 居住地址 */
	@Column
	private String address;

	/** 身份证号 */
	@Column
	private String idcard;

	/** 学历 */
	@Column
	private Integer education;

	/** 入职日期 */
	@Column
	private Date hiredate;

	/** 离职日期 */
	@Column
	private Date leavedate;

	/** 账号 */
	@Column
	private String account;

	/** 密码 */
	@Column
	private String password;

	/** 微信OPENID */
	@Column
	private String openid;


	/** 
	 * 获取[主键序号]
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置[主键序号]
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/** 
	 * 获取[姓名]
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置[姓名]
	 */
	public void setName(String name) {
		this.name = name;
	}

	/** 
	 * 获取[性别]
	 */
	public Integer getGender() {
		return gender;
	}

	/**
	 * 设置[性别]
	 */
	public void setGender(Integer gender) {
		this.gender = gender;
	}

	/** 
	 * 获取[出生日期]
	 */
	public Date getBirthdate() {
		return birthdate;
	}

	/**
	 * 设置[出生日期]
	 */
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	/** 
	 * 获取[电话号码]
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 设置[电话号码]
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/** 
	 * 获取[QQ号码]
	 */
	public String getQq() {
		return qq;
	}

	/**
	 * 设置[QQ号码]
	 */
	public void setQq(String qq) {
		this.qq = qq;
	}

	/** 
	 * 获取[电子邮箱]
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置[电子邮箱]
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/** 
	 * 获取[居住地址]
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置[居住地址]
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/** 
	 * 获取[身份证号]
	 */
	public String getIdcard() {
		return idcard;
	}

	/**
	 * 设置[身份证号]
	 */
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	/** 
	 * 获取[学历]
	 */
	public Integer getEducation() {
		return education;
	}

	/**
	 * 设置[学历]
	 */
	public void setEducation(Integer education) {
		this.education = education;
	}

	/** 
	 * 获取[入职日期]
	 */
	public Date getHiredate() {
		return hiredate;
	}

	/**
	 * 设置[入职日期]
	 */
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	/** 
	 * 获取[离职日期]
	 */
	public Date getLeavedate() {
		return leavedate;
	}

	/**
	 * 设置[离职日期]
	 */
	public void setLeavedate(Date leavedate) {
		this.leavedate = leavedate;
	}

	/** 
	 * 获取[账号]
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * 设置[账号]
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/** 
	 * 获取[密码]
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 设置[密码]
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/** 
	 * 获取[微信OPENID]
	 */
	public String getOpenid() {
		return openid;
	}

	/**
	 * 设置[微信OPENID]
	 */
	public void setOpenid(String openid) {
		this.openid = openid;
	}


}
