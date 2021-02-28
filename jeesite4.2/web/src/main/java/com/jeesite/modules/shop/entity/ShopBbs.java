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
 * shop_bbsEntity
 * @author 高峰
 * @version 2021-02-17
 */
@Table(name="shop_bbs", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="rowid", isPK=true),
		@Column(name="fenlei", attrName="fenlei", label="分类"),
		@Column(name="remarks", attrName="remarks", label="内容", queryType=QueryType.LIKE),
		@Column(name="title", attrName="title", label="标题", queryType=QueryType.LIKE),
		@Column(name="admin_tag", attrName="adminTag", label="标签",queryType = QueryType.LIKE),
		@Column(name="nick", attrName="nick", label="昵称"),
		@Column(name="avatar", attrName="avatar", label="头像"),
		@Column(name="pic_url", attrName="picUrl", label="图片"),
		@Column(name="image_list", attrName="imageList", label="图集"),
		@Column(name="createtime", attrName="createtime", label="创建时间"),
	}, orderBy="a.rowid DESC"
)
public class ShopBbs extends DataEntity<ShopBbs> {
	
	private static final long serialVersionUID = 1L;
	private String rowid;		// rowid
	private String fenlei;		// 分类
	private String title;		// 标题
	private String adminTag;		// 标签
	private String nick;		// 昵称
	private String avatar;		// 头像
	private String picUrl;		// 图片
	private String imageList;		// 图集
	private Date createtime;		// 创建时间
	
	public ShopBbs() {
		this(null);
	}

	public ShopBbs(String id){
		super(id);
	}
	
	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	@Length(min=0, max=45, message="分类长度不能超过 45 个字符")
	public String getFenlei() {
		return fenlei;
	}

	public void setFenlei(String fenlei) {
		this.fenlei = fenlei;
	}
	
	@Length(min=0, max=45, message="标题长度不能超过 45 个字符")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Length(min=0, max=45, message="标签长度不能超过 45 个字符")
	public String getAdminTag() {
		return adminTag;
	}

	public void setAdminTag(String adminTag) {
		this.adminTag = adminTag;
	}
	
	@Length(min=0, max=45, message="昵称长度不能超过 45 个字符")
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}
	
	@Length(min=0, max=500, message="头像长度不能超过 500 个字符")
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	@Length(min=0, max=451, message="图片长度不能超过 451 个字符")
	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	
	@Length(min=0, max=8000, message="图集长度不能超过 8000 个字符")
	public String getImageList() {
		return imageList;
	}

	public void setImageList(String imageList) {
		this.imageList = imageList;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
}