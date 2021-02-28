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
 * tab_shouhuanEntity
 * @author 高峰
 * @version 2020-09-26
 */
@Table(name="tab_shouhuan", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="rowid", isPK=true),
		@Column(name="imei", attrName="imei", label="手环imei号",queryType=QueryType.LIKE),
		@Column(name="jhdx", attrName="jhdx", label="监护对象",queryType=QueryType.LIKE),
		@Column(name="xinlv", attrName="xinlv", label="心率"),
		@Column(name="xueya", attrName="xueya", label="血压"),
		@Column(name="xueyang", attrName="xueyang", label="血氧"),
		@Column(name="tw", attrName="tw", label="体温"),
		@Column(name="bjnr", attrName="bjnr", label="报警内容"),
				@Column(name="bushu", attrName="bushu", label="报警内容"),
				@Column(name="fgcs", attrName="fgcs", label="报警内容"),
				@Column(name="dianl", attrName="dianl", label="报警内容"),
				@Column(name="lon", attrName="lon", label="报警内容"),
				@Column(name="lat", attrName="lat", label="报警内容"),
				@Column(name="logincode", attrName="logincode", label="登录用户"),

		@Column(name="createtime", attrName="createtime", label="创建时间"),
	}, orderBy="a.rowid DESC"
)
public class TabShouhuan extends DataEntity<TabShouhuan> {
	private String bushu ;
	private String fgcs;
	private String dianl;
	private String lon;
	private String lat;
private String logincode; 


	public String getLogincode() {
	return logincode;
}

public void setLogincode(String logincode) {
	this.logincode = logincode;
}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	private static final long serialVersionUID = 1L;
	private String rowid;		// rowid
	private String imei;		// 手环imei号
	private String jhdx;		// 监护对象
	private Double xinlv;		// 心率
	private String xueya;		// 血压
	private Double xueyang;		// 血氧
	private Double tw;		// 体温
	private String bjnr;		// 报警内容
	private Date createtime;		// 创建时间
	
	public String getBushu() {
		return bushu;
	}

	public void setBushu(String bushu) {
		this.bushu = bushu;
	}

	public String getFgcs() {
		return fgcs;
	}

	public void setFgcs(String fgcs) {
		this.fgcs = fgcs;
	}

	public String getDianl() {
		return dianl;
	}

	public void setDianl(String dianl) {
		this.dianl = dianl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TabShouhuan() {
		this(null);
	}

	public TabShouhuan(String id){
		super(id);
	}
	
	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	@Length(min=0, max=45, message="手环imei号长度不能超过 45 个字符")
	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}
	
	@Length(min=0, max=45, message="监护对象长度不能超过 45 个字符")
	public String getJhdx() {
		return jhdx;
	}

	public void setJhdx(String jhdx) {
		this.jhdx = jhdx;
	}
	
	public Double getXinlv() {
		return xinlv;
	}

	public void setXinlv(Double xinlv) {
		this.xinlv = xinlv;
	}
	
	@Length(min=0, max=111, message="血压长度不能超过 111 个字符")
	public String getXueya() {
		return xueya;
	}

	public void setXueya(String xueya) {
		this.xueya = xueya;
	}
	
	public Double getXueyang() {
		return xueyang;
	}

	public void setXueyang(Double xueyang) {
		this.xueyang = xueyang;
	}
	
	public Double getTw() {
		return tw;
	}

	public void setTw(Double tw) {
		this.tw = tw;
	}
	
	@Length(min=0, max=45, message="报警内容长度不能超过 45 个字符")
	public String getBjnr() {
		return bjnr;
	}

	public void setBjnr(String bjnr) {
		this.bjnr = bjnr;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
}