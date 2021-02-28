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
 * shop_good_view_logEntity
 * @author 商品浏览记录
 * @version 2021-02-16
 */
@Table(name="shop_good_view_log", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="rowid", isPK=true),
		@Column(name="good_id", attrName="goodId", label="商品编号"),
		@Column(name="user_id", attrName="userId", label="用户编号"),
		@Column(name="createtine", attrName="createtine", label="收藏时间"),
	}, orderBy="a.rowid DESC"
)
public class ShopGoodViewLog extends DataEntity<ShopGoodViewLog> {
	
	private static final long serialVersionUID = 1L;
	private String rowid;		// rowid
	private String goodId;		// 商品编号
	private String userId;		// 用户编号
	private Date createtine;		// 收藏时间
	
	public ShopGoodViewLog() {
		this(null);
	}

	public ShopGoodViewLog(String id){
		super(id);
	}
	
	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	@Length(min=0, max=45, message="商品编号长度不能超过 45 个字符")
	public String getGoodId() {
		return goodId;
	}

	public void setGoodId(String goodId) {
		this.goodId = goodId;
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