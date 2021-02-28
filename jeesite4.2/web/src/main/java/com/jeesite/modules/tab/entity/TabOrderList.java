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
 * tab_order_listEntity
 * @author 高峰
 * @version 2021-02-16
 */
@Table(name="tab_order_list", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="rowid", isPK=true),
		@Column(name="orderid", attrName="orderid", label="orderid"),
		@Column(name="productid", attrName="productid", label="productid"),
		@Column(name="nums", attrName="nums", label="nums"),
		@Column(name="createtime", attrName="createtime", label="createtime"),
		@Column(name="guige", attrName="guige", label="guige"),
		@Column(name="parame1", attrName="parame1", label="parame1"),
		@Column(name="parame2", attrName="parame2", label="parame2"),
		@Column(name="parame3", attrName="parame3", label="parame3"),
		@Column(name="bussinessid", attrName="bussinessid", label="bussinessid"),
		@Column(name="pirce", attrName="pirce", label="pirce"),
		@Column(name="orderstatus", attrName="orderstatus", label="orderstatus"),
		@Column(name="address", attrName="address", label="address"),
		@Column(name="phone", attrName="phone", label="phone"),
		@Column(name="userid", attrName="userid", label="111"),
		@Column(name="names", attrName="names", label="names"),
		@Column(name="tuihuostatus", attrName="tuihuostatus", label="1"),
		@Column(name="sourcetype", attrName="sourcetype", label="sourcetype"),
	}, orderBy="a.rowid DESC"
)
public class TabOrderList extends DataEntity<TabOrderList> {
	private  ShopGoods shopGoods  ; 
	
	
	
	
	public ShopGoods getShopGoods() {
		return shopGoods;
	}

	public void setShopGoods(ShopGoods shopGoods) {
		this.shopGoods = shopGoods;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private static final long serialVersionUID = 1L;
	private String rowid;		// rowid
	private String orderid;		// orderid
	private String productid;		// productid
	private Double nums;		// nums
	private Date createtime;		// createtime
	private String guige;		// guige
	private String parame1;		// parame1
	private String parame2;		// parame2
	private String parame3;		// parame3
	private String bussinessid;		// bussinessid
	private Double pirce;		// pirce
	private String orderstatus;		// orderstatus
	private String address;		// address
	private String phone;		// phone
	private String userid;		// 111
	private String names;		// names
	private String tuihuostatus;		// 1
	private String sourcetype;		// sourcetype
	
	public TabOrderList() {
		this(null);
	}

	public TabOrderList(String id){
		super(id);
	}
	
	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	@Length(min=0, max=451, message="orderid长度不能超过 451 个字符")
	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	
	@Length(min=0, max=451, message="productid长度不能超过 451 个字符")
	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}
	
	public Double getNums() {
		return nums;
	}

	public void setNums(Double nums) {
		this.nums = nums;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	@Length(min=0, max=45, message="guige长度不能超过 45 个字符")
	public String getGuige() {
		return guige;
	}

	public void setGuige(String guige) {
		this.guige = guige;
	}
	
	@Length(min=0, max=451, message="parame1长度不能超过 451 个字符")
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
	
	@Length(min=0, max=451, message="parame3长度不能超过 451 个字符")
	public String getParame3() {
		return parame3;
	}

	public void setParame3(String parame3) {
		this.parame3 = parame3;
	}
	
	@Length(min=0, max=45, message="bussinessid长度不能超过 45 个字符")
	public String getBussinessid() {
		return bussinessid;
	}

	public void setBussinessid(String bussinessid) {
		this.bussinessid = bussinessid;
	}
	
	public Double getPirce() {
		return pirce;
	}

	public void setPirce(Double pirce) {
		this.pirce = pirce;
	}
	
	@Length(min=0, max=4, message="orderstatus长度不能超过 4 个字符")
	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
	
	@Length(min=0, max=451, message="address长度不能超过 451 个字符")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@Length(min=0, max=451, message="phone长度不能超过 451 个字符")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=451, message="111长度不能超过 451 个字符")
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@Length(min=0, max=451, message="names长度不能超过 451 个字符")
	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}
	
	@Length(min=0, max=451, message="1长度不能超过 451 个字符")
	public String getTuihuostatus() {
		return tuihuostatus;
	}

	public void setTuihuostatus(String tuihuostatus) {
		this.tuihuostatus = tuihuostatus;
	}
	
	@Length(min=0, max=45, message="sourcetype长度不能超过 45 个字符")
	public String getSourcetype() {
		return sourcetype;
	}

	public void setSourcetype(String sourcetype) {
		this.sourcetype = sourcetype;
	}
	
}