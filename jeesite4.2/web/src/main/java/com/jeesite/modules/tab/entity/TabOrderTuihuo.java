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
 * tab_order_tuihuoEntity
 * @author 高峰
 * @version 2021-02-16
 */
@Table(name="tab_order_tuihuo", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="rowid", isPK=true),
		@Column(name="userid", attrName="userid", label="userid"),
		@Column(name="orderid", attrName="orderid", label="orderid"),
		@Column(name="bussinessid", attrName="bussinessid", label="bussinessid"),
		@Column(name="productid", attrName="productid", label="productid"),
		@Column(name="createtime", attrName="createtime", label="createtime"),
		@Column(name="tkyy", attrName="tkyy", label="tkyy"),
		@Column(name="tkmoney", attrName="tkmoney", label="tkmoney"),
		@Column(name="updatetime", attrName="updatetime", label="updatetime"),
	}, orderBy="a.rowid DESC"
)
public class TabOrderTuihuo extends DataEntity<TabOrderTuihuo> {
	
	private static final long serialVersionUID = 1L;
	private String rowid;		// rowid
	private String userid;		// userid
	private String orderid;		// orderid
	private String bussinessid;		// bussinessid
	private String productid;		// productid
	private Date createtime;		// createtime
	private String tkyy;		// tkyy
	private Double tkmoney;		// tkmoney
	private Date updatetime;		// updatetime
	
	public TabOrderTuihuo() {
		this(null);
	}

	public TabOrderTuihuo(String id){
		super(id);
	}
	
	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	@Length(min=0, max=451, message="userid长度不能超过 451 个字符")
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@Length(min=0, max=45, message="orderid长度不能超过 45 个字符")
	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	
	@Length(min=0, max=451, message="bussinessid长度不能超过 451 个字符")
	public String getBussinessid() {
		return bussinessid;
	}

	public void setBussinessid(String bussinessid) {
		this.bussinessid = bussinessid;
	}
	
	@Length(min=0, max=451, message="productid长度不能超过 451 个字符")
	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	@Length(min=0, max=451, message="tkyy长度不能超过 451 个字符")
	public String getTkyy() {
		return tkyy;
	}

	public void setTkyy(String tkyy) {
		this.tkyy = tkyy;
	}
	
	public Double getTkmoney() {
		return tkmoney;
	}

	public void setTkmoney(Double tkmoney) {
		this.tkmoney = tkmoney;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	
}