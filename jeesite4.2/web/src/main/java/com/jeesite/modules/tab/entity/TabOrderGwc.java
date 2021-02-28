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
import com.jeesite.modules.shop.entity.ShopGoods;

/**
 * tab_order_gwcEntity
 * @author 高峰
 * @version 2021-02-16
 */
@Table(name="tab_order_gwc", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="rowid", isPK=true),
		@Column(name="userid", attrName="userid", label="userid"),
		@Column(name="productid", attrName="productid", label="productid"),
		@Column(name="nums", attrName="nums", label="nums"),
		@Column(name="parame1", attrName="parame1", label="parame1"),
		@Column(name="parame2", attrName="parame2", label="parame2"),
		@Column(name="createtime", attrName="createtime", label="createtime"),
		@Column(name="bussinessid", attrName="bussinessid", label="bussinessid"),
		@Column(name="guige", attrName="guige", label="guige"),
		@Column(name="ischeck", attrName="ischeck", label="ischeck"),
		@Column(name="gwctype", attrName="gwctype", label="gwctype"),
		@Column(name="itempirce", attrName="itempirce", label="itempirce"),
	}, orderBy="a.rowid DESC"
)
public class TabOrderGwc extends DataEntity<TabOrderGwc> {
	
	private static final long serialVersionUID = 1L;
	private String rowid;		// rowid
	private String userid;		// userid
	private String productid;		// productid
	private Long nums;		// nums
	private String parame1;		// parame1
	private String parame2;		// parame2
	private Date createtime;		// createtime
	private String bussinessid;		// bussinessid
	private String guige;		// guige
	private String ischeck;		// ischeck
	private String gwctype;		// gwctype
	private Double itempirce;		// itempirce
	private  ShopGoods shopGoods ;
	
	public ShopGoods getShopGoods() {
		return shopGoods;
	}

	public void setShopGoods(ShopGoods shopGoods) {
		this.shopGoods = shopGoods;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public TabOrderGwc() {
		this(null);
	}

	public TabOrderGwc(String id){
		super(id);
	}
	
	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	@Length(min=0, max=45, message="userid长度不能超过 45 个字符")
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@Length(min=0, max=45, message="productid长度不能超过 45 个字符")
	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}
	
	public Long getNums() {
		return nums;
	}

	public void setNums(Long nums) {
		this.nums = nums;
	}
	
	@Length(min=0, max=45, message="parame1长度不能超过 45 个字符")
	public String getParame1() {
		return parame1;
	}

	public void setParame1(String parame1) {
		this.parame1 = parame1;
	}
	
	@Length(min=0, max=451, message="parame2长度不能超过 451 个字符")
	public String getParame2() {
		return parame2;
	}

	public void setParame2(String parame2) {
		this.parame2 = parame2;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	@Length(min=0, max=451, message="bussinessid长度不能超过 451 个字符")
	public String getBussinessid() {
		return bussinessid;
	}

	public void setBussinessid(String bussinessid) {
		this.bussinessid = bussinessid;
	}
	
	@Length(min=0, max=45, message="guige长度不能超过 45 个字符")
	public String getGuige() {
		return guige;
	}

	public void setGuige(String guige) {
		this.guige = guige;
	}
	
	@Length(min=0, max=451, message="ischeck长度不能超过 451 个字符")
	public String getIscheck() {
		return ischeck;
	}

	public void setIscheck(String ischeck) {
		this.ischeck = ischeck;
	}
	
	@Length(min=0, max=451, message="gwctype长度不能超过 451 个字符")
	public String getGwctype() {
		return gwctype;
	}

	public void setGwctype(String gwctype) {
		this.gwctype = gwctype;
	}
	
	public Double getItempirce() {
		return itempirce;
	}

	public void setItempirce(Double itempirce) {
		this.itempirce = itempirce;
	}
	
}