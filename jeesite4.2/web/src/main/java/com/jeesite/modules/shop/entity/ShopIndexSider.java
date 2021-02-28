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
 * shop_index_siderEntity
 * @author 高峰
 * @version 2021-02-17
 */
@Table(name="shop_index_sider", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="rowid", isPK=true),
		@Column(name="imgsrc", attrName="imgsrc", label="图片"),
		@Column(name="title", attrName="title", label="名称", queryType=QueryType.LIKE),
		@Column(name="type", attrName="type", label="类型"),
		@Column(name="linkid", attrName="linkid", label="链接"),
		@Column(name="orderindex", attrName="orderindex", label="排序"),
		@Column(name="createtime", attrName="createtime", label="创建时间"),
	}, orderBy="a.orderindex asc"
)
public class ShopIndexSider extends DataEntity<ShopIndexSider> {
	
	private static final long serialVersionUID = 1L;
	private String rowid;		// rowid
	private String imgsrc;		// 图片
	private String title;		// 名称
	private String type;		// 类型
	private String linkid;		// 链接
	private Long orderindex;		// 排序
	private Date createtime;		// 创建时间
	
	public ShopIndexSider() {
		this(null);
	}

	public ShopIndexSider(String id){
		super(id);
	}
	
	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	@Length(min=0, max=451, message="图片长度不能超过 451 个字符")
	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
	
	@Length(min=0, max=45, message="名称长度不能超过 45 个字符")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=0, max=4, message="类型长度不能超过 4 个字符")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=451, message="链接长度不能超过 451 个字符")
	public String getLinkid() {
		return linkid;
	}

	public void setLinkid(String linkid) {
		this.linkid = linkid;
	}
	
	public Long getOrderindex() {
		return orderindex;
	}

	public void setOrderindex(Long orderindex) {
		this.orderindex = orderindex;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
}