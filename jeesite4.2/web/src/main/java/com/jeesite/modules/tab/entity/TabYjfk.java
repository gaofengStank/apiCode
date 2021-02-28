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
 * tab_yjfkEntity
 * @author 高峰
 * @version 2021-02-27
 */
@Table(name="tab_yjfk", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="rowid", isPK=true),
		@Column(name="userid", attrName="userid", label="用户编号"),
		@Column(name="fenlei", attrName="fenlei", label="分类"),
		@Column(name="contents", attrName="contents", label="分类"),
		@Column(name="createtime", attrName="createtime", label="创建时间"),
		@Column(name="imglist", attrName="imglist", label="图集"),
	}, orderBy="a.rowid DESC"
)
public class TabYjfk extends DataEntity<TabYjfk> {
	
	private static final long serialVersionUID = 1L;
	private String rowid;		// rowid
	private String userid;		// 用户编号
	private String fenlei;		// 分类
	private String contents;		// 分类
	private Date createtime;		// 创建时间
	private String imglist;		// 图集
	
	public TabYjfk() {
		this(null);
	}

	public TabYjfk(String id){
		super(id);
	}
	
	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	@Length(min=0, max=50, message="用户编号长度不能超过 50 个字符")
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@Length(min=0, max=45, message="分类长度不能超过 45 个字符")
	public String getFenlei() {
		return fenlei;
	}

	public void setFenlei(String fenlei) {
		this.fenlei = fenlei;
	}
	
	@Length(min=0, max=500, message="分类长度不能超过 500 个字符")
	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	@Length(min=0, max=4500, message="图集长度不能超过 4500 个字符")
	public String getImglist() {
		return imglist;
	}

	public void setImglist(String imglist) {
		this.imglist = imglist;
	}
	
}