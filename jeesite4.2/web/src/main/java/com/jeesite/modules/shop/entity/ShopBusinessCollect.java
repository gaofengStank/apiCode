/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.shop.entity;

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
 * shop_business_collectEntity
 * @author 高峰
 * @version 2021-02-23
 */
@Table(name="shop_business_collect", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="rowid", isPK=true),
		@Column(name="buss_id", attrName="bussId", label="商家编号"),
		@Column(name="user_id", attrName="userId", label="用户编号"),
		@Column(name="createtine", attrName="createtine", label="关注时间"),
	}, orderBy="a.rowid DESC"
)
public class ShopBusinessCollect extends DataEntity<ShopBusinessCollect> {
	
	private static final long serialVersionUID = 1L;
	private String rowid;		// rowid
	private String bussId;		// 商家编号
	private String userId;		// 用户编号
	private Date createtine;		// 关注时间
	private  ShopBusiness shopBusiness ;
	
	
	public ShopBusiness getShopBusiness() {
		return shopBusiness;
	}

	public void setShopBusiness(ShopBusiness shopBusiness) {
		this.shopBusiness = shopBusiness;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ShopBusinessCollect() {
		this(null);
	}

	public ShopBusinessCollect(String id){
		super(id);
	}
	
	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	@Length(min=0, max=45, message="商家编号长度不能超过 45 个字符")
	public String getBussId() {
		return bussId;
	}

	public void setBussId(String bussId) {
		this.bussId = bussId;
	}
	
	@Length(min=0, max=45, message="用户编号长度不能超过 45 个字符")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetine() {
		return createtine;
	}

	public void setCreatetine(Date createtine) {
		this.createtine = createtine;
	}
	
}