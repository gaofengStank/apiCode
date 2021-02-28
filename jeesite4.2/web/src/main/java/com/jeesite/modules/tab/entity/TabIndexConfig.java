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
 * tab_index_configEntity
 * @author 高峰
 * @version 2020-12-23
 */
@Table(name="tab_index_config", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="rowid", isPK=true),
		@Column(name="type", attrName="type", label="类型"),
		@Column(name="links", attrName="links", label="链接"),
		@Column(name="productid", attrName="productid", label="产品编号"),
		@Column(name="title", attrName="title", label="标题", queryType=QueryType.LIKE),
		@Column(name="createtime", attrName="createtime", label="创建时间"),
		@Column(name="orderindex", attrName="orderindex", label="排序"),
		@Column(name="imgsrc", attrName="imgsrc", label="图片"),
		
		@Column(name="leval", attrName="leval", label="级别"),

	}, orderBy="a.rowid DESC"
)
public class TabIndexConfig extends DataEntity<TabIndexConfig> {
	
	private static final long serialVersionUID = 1L;
	private String rowid;		// rowid
	private String type;		// 类型
	private String links;		// 链接
	private String productid;		// 产品编号
	private String title;		// 标题
	private Date createtime;		// 创建时间
	private Long orderindex;		// 排序
	private String imgsrc;		// 图片
	private Long  leval ;
	
	
	
	public Long getLeval() {
		return leval;
	}

	public void setLeval(Long leval) {
		this.leval = leval;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TabIndexConfig() {
		this(null);
	}

	public TabIndexConfig(String id){
		super(id);
	}
	
	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	@Length(min=0, max=451, message="类型长度不能超过 451 个字符")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=451, message="链接长度不能超过 451 个字符")
	public String getLinks() {
		return links;
	}

	public void setLinks(String links) {
		this.links = links;
	}
	
	@Length(min=0, max=451, message="产品编号长度不能超过 451 个字符")
	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}
	
	@Length(min=0, max=451, message="标题长度不能超过 451 个字符")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	public Long getOrderindex() {
		return orderindex;
	}

	public void setOrderindex(Long orderindex) {
		this.orderindex = orderindex;
	}
	
	@Length(min=0, max=451, message="图片长度不能超过 451 个字符")
	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
	
}