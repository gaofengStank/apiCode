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
 * shop_serach_configEntity
 * @author 高峰
 * @version 2021-02-17
 */
@Table(name="shop_serach_config", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="rowid", isPK=true),
		@Column(name="usertype", attrName="usertype", label="用户类型"),
		@Column(name="content", attrName="content", label="搜索内容"),
		@Column(name="createtime", attrName="createtime", label="生成日期"),
		@Column(name="userid", attrName="userid", label="用户编号"),
	}, orderBy="a.rowid DESC"
)
public class ShopSerachConfig extends DataEntity<ShopSerachConfig> {
	
	private static final long serialVersionUID = 1L;
	private String rowid;		// rowid
	private String usertype;		// 用户类型
	private String content;		// 搜索内容
	private Date createtime;		// 生成日期
	private String userid;		// 用户编号
	
	public ShopSerachConfig() {
		this(null);
	}

	public ShopSerachConfig(String id){
		super(id);
	}
	
	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	@Length(min=0, max=45, message="用户类型长度不能超过 45 个字符")
	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	@Length(min=0, max=451, message="搜索内容长度不能超过 451 个字符")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	@Length(min=0, max=45, message="用户编号长度不能超过 45 个字符")
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
}