/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 工人和锁扣配对Entity
 * @author 高峰
 * @version 2020-09-28
 */
@Table(name="tab_devices", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="编号", isPK=true),
		@Column(name="imei", attrName="imei", label="锁扣唯一标识符"),
		@Column(name="name", attrName="name", label="工人姓名", queryType=QueryType.LIKE),
		@Column(name="id_card", attrName="idCard", label="身份证号"),
		@Column(name="age", attrName="age", label="工人年龄"),
		@Column(name="phone", attrName="phone", label="手机号"),
		@Column(name="work_id", attrName="workId", label="工号"),
		@Column(name="blood_type", attrName="bloodType", label="血型"),
		@Column(name="sex", attrName="sex", label="性别"),
		@Column(name="userid", attrName="userid", label="APP账号"),
		@Column(name="logincode", attrName="logincode", label="后台账号"),
		@Column(name="createtime", attrName="createtime", label="创建时间"),
	}, orderBy="a.rowid DESC"
)
public class TabDevices extends DataEntity<TabDevices> {
	
	private static final long serialVersionUID = 1L;
	private String rowid;		// 编号
	private String imei;		// 锁扣唯一标识符
	private String name;		// 工人姓名
	private String idCard;		// 身份证号
	private String age;		// 工人年龄
	private String phone;		// 手机号
	private String workId;		// 工号
	private String bloodType;		// 血型
	private Integer sex;		// 性别
	private String userid;		// APP账号
	private String logincode;		// 后台账号
	private Date createtime;		// 创建时间
	
	public TabDevices() {
		this(null);
	}

	public TabDevices(String id){
		super(id);
	}
	
	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	@Length(min=0, max=200, message="锁扣唯一标识符长度不能超过 200 个字符")
	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}
	
	@Length(min=0, max=200, message="工人姓名长度不能超过 200 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=200, message="身份证号长度不能超过 200 个字符")
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	@Length(min=0, max=50, message="工人年龄长度不能超过 50 个字符")
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	@Length(min=0, max=200, message="手机号长度不能超过 200 个字符")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=200, message="工号长度不能超过 200 个字符")
	public String getWorkId() {
		return workId;
	}

	public void setWorkId(String workId) {
		this.workId = workId;
	}
	
	@Length(min=0, max=20, message="血型长度不能超过 20 个字符")
	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}
	
	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	@Length(min=0, max=45, message="APP账号长度不能超过 45 个字符")
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@Length(min=0, max=45, message="后台账号长度不能超过 45 个字符")
	public String getLogincode() {
		return logincode;
	}

	public void setLogincode(String logincode) {
		this.logincode = logincode;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
}