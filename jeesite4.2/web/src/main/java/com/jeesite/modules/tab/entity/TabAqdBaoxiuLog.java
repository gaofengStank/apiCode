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
 * 报警日志Entity
 * @author 高峰
 * @version 2020-09-30
 */
@Table(name="tab_aqd_baoxiu_log", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="编号", isPK=true),
		@Column(name="imei", attrName="imei", label="设备IMEI号"),
		@Column(name="name", attrName="name", label="工人姓名", queryType=QueryType.LIKE),
		@Column(name="warning_type", attrName="warningType", label="报修类型"),
		@Column(name="status1", attrName="status1", label="处理状态"),
		@Column(name="createtime", attrName="createtime", label="创建时间"),
		@Column(name="logincode", attrName="logincode", label="logincode"),
	}, orderBy="a.rowid DESC"
)
public class TabAqdBaoxiuLog extends DataEntity<TabAqdBaoxiuLog> {
	
	private static final long serialVersionUID = 1L;
	private String rowid;		// 编号
	private String imei;		// 设备IMEI号
	private String name;		// 工人姓名
	private String warningType;		// 报修类型
	private Integer status1;		// 处理状态
	private Date createtime;		// 创建时间
	private String logincode;		// logincode
	
	public TabAqdBaoxiuLog() {
		this(null);
	}

	public TabAqdBaoxiuLog(String id){
		super(id);
	}
	
	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	@Length(min=0, max=200, message="设备IMEI号长度不能超过 200 个字符")
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
	
	@Length(min=0, max=200, message="报修类型长度不能超过 200 个字符")
	public String getWarningType() {
		return warningType;
	}

	public void setWarningType(String warningType) {
		this.warningType = warningType;
	}
	
	public Integer getStatus1() {
		return status1;
	}

	public void setStatus1(Integer status1) {
		this.status1 = status1;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	@Length(min=0, max=45, message="logincode长度不能超过 45 个字符")
	public String getLogincode() {
		return logincode;
	}

	public void setLogincode(String logincode) {
		this.logincode = logincode;
	}
	
}