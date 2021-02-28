/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * tab_product_typeEntity
 * @author 产品分类
 * @version 2020-12-24
 */
@Table(name="tab_product_type", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="rowid", isPK=true),
		@Column(name="typename", attrName="typename", label="分类名称"),
		@Column(name="diqu", attrName="diqu", label="地区"),
		@Column(name="guige", attrName="guige", label="默认规格"),
		@Column(name="imgsrc", attrName="imgsrc", label="图片"),
		@Column(name="blength", attrName="blength", label="商家数量"),
		@Column(name="xse", attrName="xse", label="销售额"),
		@Column(name="orderindex", attrName="orderindex", label="排序"),
	}, orderBy="a.rowid DESC"
)
public class TabProductType extends DataEntity<TabProductType> {
	
	private static final long serialVersionUID = 1L;
	private String rowid;		// rowid
	private String typename;		// 分类名称
	private String diqu;		// 地区
	private String guige;		// 默认规格
	private String imgsrc;		// 图片
	private Long blength;		// 商家数量
	private Double xse;		// 销售额
	private Long orderindex;		// 排序
	
	public TabProductType() {
		this(null);
	}

	public TabProductType(String id){
		super(id);
	}
	
	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	@Length(min=0, max=45, message="分类名称长度不能超过 45 个字符")
	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}
	
	@Length(min=0, max=45, message="地区长度不能超过 45 个字符")
	public String getDiqu() {
		return diqu;
	}

	public void setDiqu(String diqu) {
		this.diqu = diqu;
	}
	
	@Length(min=0, max=45, message="默认规格长度不能超过 45 个字符")
	public String getGuige() {
		return guige;
	}

	public void setGuige(String guige) {
		this.guige = guige;
	}
	
	@Length(min=0, max=451, message="图片长度不能超过 451 个字符")
	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
	
	public Long getBlength() {
		return blength;
	}

	public void setBlength(Long blength) {
		this.blength = blength;
	}
	
	public Double getXse() {
		return xse;
	}

	public void setXse(Double xse) {
		this.xse = xse;
	}
	
	public Long getOrderindex() {
		return orderindex;
	}

	public void setOrderindex(Long orderindex) {
		this.orderindex = orderindex;
	}
	
}