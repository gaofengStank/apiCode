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
 * tab_sys_contactEntity
 * @author 高峰
 * @version 2021-02-26
 */
@Table(name="tab_sys_contact", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="rowid", isPK=true),
		@Column(name="phone", attrName="phone", label="官方电话"),
		@Column(name="weixin", attrName="weixin", label="官方微信"),
		
		@Column(name="detail", attrName="detail", label="detail"),

		@Column(name="createtime", attrName="createtime", label="createtime"),
	}, orderBy="a.rowid DESC"
)
public class TabSysContact extends DataEntity<TabSysContact> {
	
	private static final long serialVersionUID = 1L;
	private String rowid;		// rowid
	private String phone;		// 官方电话
	private String weixin;		// 官方微信
	private Date createtime;		// createtime
	private String detail ;
	
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TabSysContact() {
		this(null);
	}

	public TabSysContact(String id){
		super(id);
	}
	
	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	@Length(min=0, max=20, message="官方电话长度不能超过 20 个字符")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=451, message="官方微信长度不能超过 451 个字符")
	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
}