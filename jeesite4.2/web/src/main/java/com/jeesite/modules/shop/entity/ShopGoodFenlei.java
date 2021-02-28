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
 * shop_good_fenleiEntity
 * @author 高峰
 * @version 2021-02-17
 */
@Table(name="shop_good_fenlei", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="rowid", isPK=true),
		@Column(name="name", attrName="name", label="分类名称", queryType=QueryType.LIKE),
		@Column(name="orderindex", attrName="orderindex", label="排序"),
		@Column(name="parent_rowid", attrName="parentRowid", label="上级"),
		@Column(name="icon", attrName="icon", label="图标"),
		@Column(name="showindex", attrName="showindex", label="显示位置"),
	}, orderBy="a.orderindex ASC"
)
public class ShopGoodFenlei extends DataEntity<ShopGoodFenlei> {
	
	private static final long serialVersionUID = 1L;
	private String rowid;		// rowid
	private String name;		// 分类名称
	private Long orderindex;		// 排序
	private String parentRowid;		// 上级
	private String icon;		// 图标
	private String showindex;		// 显示位置
	
	public ShopGoodFenlei() {
		this(null);
	}

	public ShopGoodFenlei(String id){
		super(id);
	}
	
	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	@Length(min=0, max=45, message="分类名称长度不能超过 45 个字符")
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
	
	@Length(min=0, max=45, message="上级长度不能超过 45 个字符")
	public String getParentRowid() {
		return parentRowid;
	}

	public void setParentRowid(String parentRowid) {
		this.parentRowid = parentRowid;
	}
	
	@Length(min=0, max=451, message="图标长度不能超过 451 个字符")
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	
	@Length(min=0, max=45, message="显示位置长度不能超过 45 个字符")
	public String getShowindex() {
		return showindex;
	}

	public void setShowindex(String showindex) {
		this.showindex = showindex;
	}
	
}