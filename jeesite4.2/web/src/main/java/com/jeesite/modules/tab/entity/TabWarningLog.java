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
 * tab_warning_logEntity
 * @author 高峰
 * @version 2020-09-27
 */
@Table(name="tab_warning_log", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="rowid", isPK=true),
		@Column(name="imei", attrName="imei", label="设备号", queryType=QueryType.LIKE),
		@Column(name="duixiang", attrName="duixiang", label="监护对象", queryType=QueryType.LIKE),
		@Column(name="types", attrName="types", label="报警内容", queryType=QueryType.LIKE),
		@Column(name="createtime", attrName="createtime", label="创建时间"),
		@Column(name="logincode", attrName="logincode", label="logincode"),

	}, orderBy="a.rowid DESC"
)
public class TabWarningLog extends DataEntity<TabWarningLog> {
	
	private static final long serialVersionUID = 1L;
	private String rowid;		// rowid
	private String imei;		// 设备号
	private String duixiang;		// 监护对象
	private String types;		// 报警内容
	private Date createtime;		// 创建时间
	private String logincode ;
	
	public String getLogincode() {
		return logincode;
	}

	public void setLogincode(String logincode) {
		this.logincode = logincode;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TabWarningLog() {
		this(null);
	}

	public TabWarningLog(String id){
		super(id);
	}
	
	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	@Length(min=0, max=45, message="设备号长度不能超过 45 个字符")
	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}
	
	@Length(min=0, max=45, message="监护对象长度不能超过 45 个字符")
	public String getDuixiang() {
		return duixiang;
	}

	public void setDuixiang(String duixiang) {
		this.duixiang = duixiang;
	}
	
	@Length(min=0, max=45, message="报警内容长度不能超过 45 个字符")
	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	public Date getCreatetime_gte() {
		return sqlMap.getWhere().getValue("createtime", QueryType.GTE);
	}

	public void setCreatetime_gte(Date createtime) {
		sqlMap.getWhere().and("createtime", QueryType.GTE, createtime);
	}
	
	public Date getCreatetime_lte() {
		return sqlMap.getWhere().getValue("createtime", QueryType.LTE);
	}

	public void setCreatetime_lte(Date createtime) {
		sqlMap.getWhere().and("createtime", QueryType.LTE, createtime);
	}
	
}