/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.shop.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * shop_top_configEntity
 * @author 高峰
 * @version 2021-02-17
 */
@Table(name="shop_top_config", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="rowid", isPK=true),
		@Column(name="name", attrName="name", label="名称", queryType=QueryType.LIKE),
		@Column(name="orderindex", attrName="orderindex", label="排序"),
		@Column(name="isbbs", attrName="isbbs", label="是否社区"),
	}, orderBy="a.rowid ASC"
)
public class ShopTopConfig extends DataEntity<ShopTopConfig> {
	
	private static final long serialVersionUID = 1L;
	private String rowid;		// rowid
	private String name;		// 名称
	private Long orderindex;		// 排序
	private String isbbs;		// 是否社区
	
	public ShopTopConfig() {
		this(null);
	}

	public ShopTopConfig(String id){
		super(id);
	}
	
	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	@Length(min=0, max=45, message="名称长度不能超过 45 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Long getOrderindex() {
		return orderindex;
	}

	public void setOrderindex(Long orderindex) {
		this.orderindex = orderindex;
	}
	
	@Length(min=0, max=45, message="是否社区长度不能超过 45 个字符")
	public String getIsbbs() {
		return isbbs;
	}

	public void setIsbbs(String isbbs) {
		this.isbbs = isbbs;
	}
	
}