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
 * tab_anquanyuanEntity
 * @author 高峰
 * @version 2020-09-30
 */
@Table(name="tab_anquanyuan", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="编号", isPK=true),
		@Column(name="contruction_id", attrName="contructionId", label="工地id"),
		@Column(name="contruction_name", attrName="contructionName", label="工地名称", queryType=QueryType.LIKE),
		@Column(name="bys", attrName="bys", label="承建方"),
		@Column(name="work_type", attrName="workType", label="工种"),
		@Column(name="name", attrName="name", label="人员姓名", queryType=QueryType.LIKE),
		@Column(name="work_id", attrName="workId", label="工号"),
		@Column(name="id_card", attrName="idCard", label="身份证号"),
		@Column(name="phone", attrName="phone", label="手机号"),
		@Column(name="address", attrName="address", label="地址"),
		@Column(name="company_id", attrName="companyId", label="所属公司"),
		@Column(name="userid", attrName="userid", label="用户编号"),
		@Column(name="createtime", attrName="createtime", label="createtime"),
		@Column(name="logincode", attrName="logincode", label="登录名称"),
	}, orderBy="a.rowid DESC"
)
public class TabAnquanyuan extends DataEntity<TabAnquanyuan> {
	
	private static final long serialVersionUID = 1L;
	private String rowid;		// 编号
	private String contructionId;		// 工地id
	private String contructionName;		// 工地名称
	private String bys;		// 承建方
	private String workType;		// 工种
	private String name;		// 人员姓名
	private String workId;		// 工号
	private String idCard;		// 身份证号
	private String phone;		// 手机号
	private String address;		// 地址
	private String companyId;		// 所属公司
	private String userid;		// 用户编号
	private Date createtime;		// createtime
	private String logincode;		// 登录名称
	
	public TabAnquanyuan() {
		this(null);
	}

	public TabAnquanyuan(String id){
		super(id);
	}
	
	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	@Length(min=0, max=111, message="工地id长度不能超过 111 个字符")
	public String getContructionId() {
		return contructionId;
	}

	public void setContructionId(String contructionId) {
		this.contructionId = contructionId;
	}
	
	@Length(min=0, max=200, message="工地名称长度不能超过 200 个字符")
	public String getContructionName() {
		return contructionName;
	}

	public void setContructionName(String contructionName) {
		this.contructionName = contructionName;
	}
	
	@Length(min=0, max=200, message="承建方长度不能超过 200 个字符")
	public String getBys() {
		return bys;
	}

	public void setBys(String bys) {
		this.bys = bys;
	}
	
	@Length(min=0, max=200, message="工种长度不能超过 200 个字符")
	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}
	
	@Length(min=0, max=200, message="人员姓名长度不能超过 200 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=200, message="工号长度不能超过 200 个字符")
	public String getWorkId() {
		return workId;
	}

	public void setWorkId(String workId) {
		this.workId = workId;
	}
	
	@Length(min=0, max=200, message="身份证号长度不能超过 200 个字符")
	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	
	@Length(min=0, max=200, message="手机号长度不能超过 200 个字符")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=200, message="地址长度不能超过 200 个字符")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Length(min=0, max=111, message="所属公司长度不能超过 111 个字符")
	public String getCompanyId() {
		return companyId;
	}

	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	
	@Length(min=0, max=45, message="用户编号长度不能超过 45 个字符")
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	@Length(min=0, max=45, message="登录名称长度不能超过 45 个字符")
	public String getLogincode() {
		return logincode;
	}

	public void setLogincode(String logincode) {
		this.logincode = logincode;
	}
	
}