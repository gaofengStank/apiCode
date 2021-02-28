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
 * tab_user_addressEntity
 * @author 高峰
 * @version 2021-02-21
 */
@Table(name="tab_user_address", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="userid", attrName="userid", label="用户昵称"),
		@Column(name="names", attrName="names", label="联系人"),
		@Column(name="phone", attrName="phone", label="联系电话"),
		@Column(name="address", attrName="address", label="联系地址"),
		@Column(name="createtime", attrName="createtime", label="创建时间"),
		@Column(name="isdefau", attrName="isdefau", label="是否默认"),
		@Column(name="details", attrName="details", label="详情"),
		@Column(name="provice", attrName="provice", label="省份"),
		@Column(name="area", attrName="area", label="地区"),
		@Column(name="city", attrName="city", label="城市"),
	}, orderBy="a.isdefau DESC"
)
public class TabUserAddress extends DataEntity<TabUserAddress> {
	private String token = "";
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;
	private String userid;		// 用户昵称
	private String names;		// 联系人
	private String phone;		// 联系电话
	private String address;		// 联系地址
	private Date createtime;		// 创建时间
	private String isdefau;		// 是否默认
	private String details;		// 详情
	private String provice;		// 省份
	private String area;		// 地区
	private String city;		// 城市
	
	public TabUserAddress() {
		this(null);
	}

	public TabUserAddress(String id){
		super(id);
	}
	
	@Length(min=0, max=45, message="用户昵称长度不能超过 45 个字符")
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@Length(min=0, max=451, message="联系人长度不能超过 451 个字符")
	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}
	
	@Length(min=0, max=45, message="联系电话长度不能超过 45 个字符")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=451, message="联系地址长度不能超过 451 个字符")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	@Length(min=0, max=45, message="是否默认长度不能超过 45 个字符")
	public String getIsdefau() {
		return isdefau;
	}

	public void setIsdefau(String isdefau) {
		this.isdefau = isdefau;
	}
	
	@Length(min=0, max=45, message="详情长度不能超过 45 个字符")
	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	@Length(min=0, max=45, message="省份长度不能超过 45 个字符")
	public String getProvice() {
		return provice;
	}

	public void setProvice(String provice) {
		this.provice = provice;
	}
	
	@Length(min=0, max=45, message="地区长度不能超过 45 个字符")
	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	@Length(min=0, max=45, message="城市长度不能超过 45 个字符")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}