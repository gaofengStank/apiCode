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
 * tab_revice_logsEntity
 * @author 高峰
 * @version 2020-09-30
 */
@Table(name="tab_revice_logs", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="rowid", isPK=true),
		@Column(name="imei", attrName="imei", label="设备编号"),
		@Column(name="content", attrName="content", label="接收内容", isQuery=false),
		@Column(name="createtine", attrName="createtine", label="接收时间"),
		@Column(name="type", attrName="type", label="设备类型"),
		@Column(name="logincode", attrName="logincode", label="登录用户"),

	}, orderBy="a.rowid DESC"
)
public class TabReviceLogs extends DataEntity<TabReviceLogs> {
private String logincode ;
	
	public String getLogincode() {
		return logincode;
	}

	public void setLogincode(String logincode) {
		this.logincode = logincode;
	}
	private static final long serialVersionUID = 1L;
	private String rowid;		// rowid
	private String imei;		// 设备编号
	private String content;		// 接收内容
	private Date createtine;		// 接收时间
	private String type;		// 设备类型
	
	public TabReviceLogs() {
		this(null);
	}

	public TabReviceLogs(String id){
		super(id);
	}
	
	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	@Length(min=0, max=45, message="设备编号长度不能超过 45 个字符")
	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}
	
	@Length(min=0, max=4511, message="接收内容长度不能超过 4511 个字符")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetine() {
		return createtine;
	}

	public void setCreatetine(Date createtine) {
		this.createtine = createtine;
	}
	
	@Length(min=0, max=45, message="设备类型长度不能超过 45 个字符")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public Date getCreatetine_gte() {
		return sqlMap.getWhere().getValue("createtine", QueryType.GTE);
	}

	public void setCreatetine_gte(Date createtine) {
		sqlMap.getWhere().and("createtine", QueryType.GTE, createtine);
	}
	
	public Date getCreatetine_lte() {
		return sqlMap.getWhere().getValue("createtine", QueryType.LTE);
	}

	public void setCreatetine_lte(Date createtine) {
		sqlMap.getWhere().and("createtine", QueryType.LTE, createtine);
	}
	
}