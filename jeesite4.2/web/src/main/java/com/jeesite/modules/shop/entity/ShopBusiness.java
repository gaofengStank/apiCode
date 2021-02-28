/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.shop.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import java.util.List;

import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * shop_businessEntity
 * @author 高峰
 * @version 2021-02-19
 */
@Table(name="shop_business", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="rowid", isPK=true),
		@Column(name="name", attrName="name", label="商家名称", queryType=QueryType.LIKE),
		@Column(name="picurl", attrName="picurl", label="图片"),
		@Column(name="fenlei", attrName="fenlei", label="分类"),
		@Column(name="address", attrName="address", label="详细地址"),
		@Column(name="likes", attrName="likes", label="关注数"),
		@Column(name="collls", attrName="collls", label="收藏数"),
		@Column(name="totalmoney", attrName="totalmoney", label="当前余额"),
		@Column(name="citys", attrName="citys", label="城市"),
		@Column(name="createtime", attrName="createtime", label="创建时间"),
		@Column(name="urls", attrName="urls", label="urls"),
	}, orderBy="a.rowid DESC"
)
public class ShopBusiness extends DataEntity<ShopBusiness> {
	
	private  List<ShopGoods>  shopGoods ;
	
	
	
	public List<ShopGoods> getShopGoods() {
		return shopGoods;
	}

	public void setShopGoods(List<ShopGoods> shopGoods) {
		this.shopGoods = shopGoods;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;
	private String rowid;		// rowid
	private String name;		// 商家名称
	private String picurl;		// 图片
	private String fenlei;		// 分类
	private String address;		// 详细地址
	private Long likes;		// 关注数
	private Long collls;		// 收藏数
	private Double totalmoney;		// 当前余额
	private String citys;		// 城市
	private Date createtime;		// 创建时间
	private String urls;		// urls
	
	public ShopBusiness() {
		this(null);
	}

	public ShopBusiness(String id){
		super(id);
	}
	
	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	@Length(min=0, max=50, message="商家名称长度不能超过 50 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=451, message="图片长度不能超过 451 个字符")
	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	
	@Length(min=0, max=45, message="分类长度不能超过 45 个字符")
	public String getFenlei() {
		return fenlei;
	}

	public void setFenlei(String fenlei) {
		this.fenlei = fenlei;
	}
	
	@Length(min=0, max=500, message="详细地址长度不能超过 500 个字符")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public Long getLikes() {
		return likes;
	}

	public void setLikes(Long likes) {
		this.likes = likes;
	}
	
	public Long getCollls() {
		return collls;
	}

	public void setCollls(Long collls) {
		this.collls = collls;
	}
	
	public Double getTotalmoney() {
		return totalmoney;
	}

	public void setTotalmoney(Double totalmoney) {
		this.totalmoney = totalmoney;
	}
	
	@Length(min=0, max=45, message="城市长度不能超过 45 个字符")
	public String getCitys() {
		return citys;
	}

	public void setCitys(String citys) {
		this.citys = citys;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	@Length(min=0, max=4511, message="urls长度不能超过 4511 个字符")
	public String getUrls() {
		return urls;
	}

	public void setUrls(String urls) {
		this.urls = urls;
	}
	
	public Long getLikes_gte() {
		return sqlMap.getWhere().getValue("likes", QueryType.GTE);
	}

	public void setLikes_gte(Long likes) {
		sqlMap.getWhere().and("likes", QueryType.GTE, likes);
	}
	
	public Long getLikes_lte() {
		return sqlMap.getWhere().getValue("likes", QueryType.LTE);
	}

	public void setLikes_lte(Long likes) {
		sqlMap.getWhere().and("likes", QueryType.LTE, likes);
	}
	
}