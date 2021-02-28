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
 * tab_weilanEntity
 * @author 高峰
 * @version 2020-09-26
 */
@Table(name="tab_weilan", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="rowid", isPK=true),
		@Column(name="imei", attrName="imei", label="设备号",queryType=QueryType.LIKE),
		@Column(name="lon", attrName="lon", label="精度"),
		@Column(name="lat", attrName="lat", label="纬度"),
		@Column(name="lines2", attrName="lines2", label="距离"),
		@Column(name="guize", attrName="guize", label="规则名称"),
		@Column(name="name", attrName="name", label="规则名称"),
		@Column(name="createtime", attrName="createtime", label="创建时间"),
	}, orderBy="a.createtime DESC"
)
public class TabWeilan extends DataEntity<TabWeilan> {
	
	private static final long serialVersionUID = 1L;
	private String rowid;		// rowid
	private String imei;		// 设备号
	private String  name; 
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private Double lon;		// 精度
	private Double lat;		// 纬度
	private Double lines2;		// 距离
	private String guize;		// 规则名称
	private Date createtime;		// 创建时间
	
	public TabWeilan() {
		this(null);
	}

	public TabWeilan(String id){
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
	
	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}
	
	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}
	
	public Double getLines2() {
		return lines2;
	}

	public void setLines2(Double lines2) {
		this.lines2 = lines2;
	}
	
	@Length(min=0, max=45, message="规则名称长度不能超过 45 个字符")
	public String getGuize() {
		return guize;
	}

	public void setGuize(String guize) {
		this.guize = guize;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
}