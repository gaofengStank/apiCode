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
 * tab_fenleiEntity
 * @author 高峰
 * @version 2020-12-24
 */
@Table(name="tab_fenlei", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="rowid", isPK=true),
		@Column(name="name", attrName="name", label="名称", queryType=QueryType.LIKE),
		@Column(name="orderindex", attrName="orderindex", label="排序"),
		@Column(name="createtime", attrName="createtime", label="创建时间"),
		@Column(name="isbbs", attrName="isbbs", label="是否是社区"),
		@Column(name="leval", attrName="leval", label="级别"),

	}, orderBy="a.rowid DESC"
)
public class TabFenlei extends DataEntity<TabFenlei> {
	
	private static final long serialVersionUID = 1L;
	private String rowid;		// rowid
	private String name;		// 名称
	private Long orderindex;		// 排序
	private Date createtime;		// 创建时间
	private Long isbbs;		// 是否是社区
private Long  leval ;
	
	
	
	public Long getLeval() {
		return leval;
	}

	public void setLeval(Long leval) {
		this.leval = leval;
	}
	public TabFenlei() {
		this(null);
	}

	public TabFenlei(String id){
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
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	public Long getIsbbs() {
		return isbbs;
	}

	public void setIsbbs(Long isbbs) {
		this.isbbs = isbbs;
	}
	
}