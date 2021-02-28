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
 * shop_goods_share_linkEntity
 * @author 高峰
 * @version 2021-02-16
 */
@Table(name="shop_goods_share_link", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="rowid", isPK=true),
		@Column(name="user_id", attrName="userId", label="用户编号"),
		@Column(name="good_id", attrName="goodId", label="产品编号"),
		@Column(name="share_link", attrName="shareLink", label="分享链接"),
		@Column(name="viewlength", attrName="viewlength", label="查看量"),
		@Column(name="paylength", attrName="paylength", label="购买量"),
	}, orderBy="a.rowid DESC"
)
public class ShopGoodsShareLink extends DataEntity<ShopGoodsShareLink> {
	
	private static final long serialVersionUID = 1L;
	private String rowid;		// rowid
	private String userId;		// 用户编号
	private String goodId;		// 产品编号
	private String shareLink;		// 分享链接
	private Long viewlength;		// 查看量
	private Long paylength;		// 购买量
	
	public ShopGoodsShareLink() {
		this(null);
	}

	public ShopGoodsShareLink(String id){
		super(id);
	}
	
	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	@Length(min=0, max=45, message="用户编号长度不能超过 45 个字符")
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Length(min=0, max=45, message="产品编号长度不能超过 45 个字符")
	public String getGoodId() {
		return goodId;
	}

	public void setGoodId(String goodId) {
		this.goodId = goodId;
	}
	
	@Length(min=0, max=45, message="分享链接长度不能超过 45 个字符")
	public String getShareLink() {
		return shareLink;
	}

	public void setShareLink(String shareLink) {
		this.shareLink = shareLink;
	}
	
	public Long getViewlength() {
		return viewlength;
	}

	public void setViewlength(Long viewlength) {
		this.viewlength = viewlength;
	}
	
	public Long getPaylength() {
		return paylength;
	}

	public void setPaylength(Long paylength) {
		this.paylength = paylength;
	}
	
}