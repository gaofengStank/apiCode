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
 * shop_orderEntity
 * @author 高峰
 * @version 2021-02-16
 */
@Table(name="shop_order", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="rowid", isPK=true),
		@Column(name="userid", attrName="userid", label="userid"),
		@Column(name="orderids", attrName="orderids", label="orderids"),
		@Column(name="orderstatus", attrName="orderstatus", label="orderstatus"),
		@Column(name="createtime", attrName="createtime", label="createtime"),
		@Column(name="ordermoney", attrName="ordermoney", label="ordermoney"),
		@Column(name="yunfei", attrName="yunfei", label="yunfei"),
		@Column(name="addresstext", attrName="addresstext", label="addresstext"),
		@Column(name="phones", attrName="phones", label="phones"),
		@Column(name="names", attrName="names", label="names"),
		@Column(name="paytype", attrName="paytype", label="paytype"),
		@Column(name="callbackid", attrName="callbackid", label="callbackid"),
		@Column(name="notes", attrName="notes", label="notes"),
		@Column(name="parame1", attrName="parame1", label="parame1"),
		@Column(name="parame2", attrName="parame2", label="parame2"),
		@Column(name="parame3", attrName="parame3", label="parame3"),
		@Column(name="updatetime", attrName="updatetime", label="updatetime"),
		@Column(name="istixing", attrName="istixing", label="istixing"),
		@Column(name="wuliuname", attrName="wuliuname", label="wuliuname"),
		@Column(name="wuno", attrName="wuno", label="wuno"),
		@Column(name="senddate", attrName="senddate", label="senddate"),
		@Column(name="xuniorderid", attrName="xuniorderid", label="商家留言"),
		@Column(name="xunimonry", attrName="xunimonry", label="xunimonry"),
		@Column(name="isjiesuan", attrName="isjiesuan", label="城市"),
		@Column(name="isjiesuan2", attrName="isjiesuan2", label="isjiesuan2"),
		@Column(name="ysfs", attrName="ysfs", label="ysfs"),
		@Column(name="ips", attrName="ips", label="ips"),
		@Column(name="yhjid", attrName="yhjid", label="yhjid"),
		@Column(name="yhjbh", attrName="yhjbh", label="yhjbh"),
		@Column(name="miusmoney", attrName="miusmoney", label="miusmoney"),
		@Column(name="bussinessid", attrName="bussinessid", label="bussinessid"),
		@Column(name="paytime", attrName="paytime", label="paytime"),
		@Column(name="peijian1", attrName="peijian1", label="peijian1"),
		@Column(name="peijian2", attrName="peijian2", label="peijian2"),
		@Column(name="serverlist", attrName="serverlist", label="serverlist"),
		@Column(name="servertime", attrName="servertime", label="servertime"),
		@Column(name="zhaopian", attrName="zhaopian", label="zhaopian"),
		@Column(name="kaipiao", attrName="kaipiao", label="kaipiao"),
		@Column(name="isservice", attrName="isservice", label="isservice"),
		@Column(name="delstatus", attrName="delstatus", label="delstatus"),
		@Column(name="kangzzhongcall", attrName="kangzzhongcall", label="的"),
		@Column(name="lon", attrName="lon", label="lon"),
		@Column(name="lat", attrName="lat", label="lat"),
		@Column(name="wcsj", attrName="wcsj", label="wcsj"),
		@Column(name="wcdd", attrName="wcdd", label="wcdd"),
		@Column(name="isprints", attrName="isprints", label="isprints"),
	}, orderBy="a.createtime DESC"
)
public class ShopOrder extends DataEntity<ShopOrder> {
	
	private static final long serialVersionUID = 1L;
	private String rowid;		// rowid
	private String userid;		// userid
	private String orderids;		// orderids
	private String orderstatus;		// orderstatus
	private Date createtime;		// createtime
	private Double ordermoney;		// ordermoney
	private Double yunfei;		// yunfei
	private String addresstext;		// addresstext
	private String phones;		// phones
	private String names;		// names
	private String paytype;		// paytype
	private String callbackid;		// callbackid
	private String notes;		// notes
	private String parame1;		// parame1
	private String parame2;		// parame2
	private String parame3;		// parame3
	private Date updatetime;		// updatetime
	private String istixing;		// istixing
	private String wuliuname;		// wuliuname
	private String wuno;		// wuno
	private Date senddate;		// senddate
	private String xuniorderid;		// 商家留言
	private Double xunimonry;		// xunimonry
	private String isjiesuan;		// 城市
	private String isjiesuan2;		// isjiesuan2
	private String ysfs;		// ysfs
	private String ips;		// ips
	private String yhjid;		// yhjid
	private String yhjbh;		// yhjbh
	private Double miusmoney;		// miusmoney
	private String bussinessid;		// bussinessid
	private Date paytime;		// paytime
	private String peijian1;		// peijian1
	private String peijian2;		// peijian2
	private String serverlist;		// serverlist
	private Date servertime;		// servertime
	private String zhaopian;		// zhaopian
	private String kaipiao;		// kaipiao
	private String isservice;		// isservice
	private String delstatus;		// delstatus
	private String kangzzhongcall;		// 的
	private Double lon;		// lon
	private Double lat;		// lat
	private Date wcsj;		// wcsj
	private String wcdd;		// wcdd
	private String isprints;		// isprints
	
	public ShopOrder() {
		this(null);
	}

	public ShopOrder(String id){
		super(id);
	}
	
	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	@Length(min=0, max=451, message="userid长度不能超过 451 个字符")
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@Length(min=0, max=111, message="orderids长度不能超过 111 个字符")
	public String getOrderids() {
		return orderids;
	}

	public void setOrderids(String orderids) {
		this.orderids = orderids;
	}
	
	@Length(min=0, max=4, message="orderstatus长度不能超过 4 个字符")
	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	public Double getOrdermoney() {
		return ordermoney;
	}

	public void setOrdermoney(Double ordermoney) {
		this.ordermoney = ordermoney;
	}
	
	public Double getYunfei() {
		return yunfei;
	}

	public void setYunfei(Double yunfei) {
		this.yunfei = yunfei;
	}
	
	@Length(min=0, max=451, message="addresstext长度不能超过 451 个字符")
	public String getAddresstext() {
		return addresstext;
	}

	public void setAddresstext(String addresstext) {
		this.addresstext = addresstext;
	}
	
	@Length(min=0, max=451, message="phones长度不能超过 451 个字符")
	public String getPhones() {
		return phones;
	}

	public void setPhones(String phones) {
		this.phones = phones;
	}
	
	@Length(min=0, max=451, message="names长度不能超过 451 个字符")
	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}
	
	@Length(min=0, max=41, message="paytype长度不能超过 41 个字符")
	public String getPaytype() {
		return paytype;
	}

	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	
	@Length(min=0, max=451, message="callbackid长度不能超过 451 个字符")
	public String getCallbackid() {
		return callbackid;
	}

	public void setCallbackid(String callbackid) {
		this.callbackid = callbackid;
	}
	
	@Length(min=0, max=451, message="notes长度不能超过 451 个字符")
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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
	
	@Length(min=0, max=415, message="parame3长度不能超过 415 个字符")
	public String getParame3() {
		return parame3;
	}

	public void setParame3(String parame3) {
		this.parame3 = parame3;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
	
	@Length(min=0, max=451, message="istixing长度不能超过 451 个字符")
	public String getIstixing() {
		return istixing;
	}

	public void setIstixing(String istixing) {
		this.istixing = istixing;
	}
	
	@Length(min=0, max=45, message="wuliuname长度不能超过 45 个字符")
	public String getWuliuname() {
		return wuliuname;
	}

	public void setWuliuname(String wuliuname) {
		this.wuliuname = wuliuname;
	}
	
	@Length(min=0, max=451, message="wuno长度不能超过 451 个字符")
	public String getWuno() {
		return wuno;
	}

	public void setWuno(String wuno) {
		this.wuno = wuno;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getSenddate() {
		return senddate;
	}

	public void setSenddate(Date senddate) {
		this.senddate = senddate;
	}
	
	@Length(min=0, max=451, message="商家留言长度不能超过 451 个字符")
	public String getXuniorderid() {
		return xuniorderid;
	}

	public void setXuniorderid(String xuniorderid) {
		this.xuniorderid = xuniorderid;
	}
	
	public Double getXunimonry() {
		return xunimonry;
	}

	public void setXunimonry(Double xunimonry) {
		this.xunimonry = xunimonry;
	}
	
	@Length(min=0, max=45, message="城市长度不能超过 45 个字符")
	public String getIsjiesuan() {
		return isjiesuan;
	}

	public void setIsjiesuan(String isjiesuan) {
		this.isjiesuan = isjiesuan;
	}
	
	@Length(min=0, max=45, message="isjiesuan2长度不能超过 45 个字符")
	public String getIsjiesuan2() {
		return isjiesuan2;
	}

	public void setIsjiesuan2(String isjiesuan2) {
		this.isjiesuan2 = isjiesuan2;
	}
	
	@Length(min=0, max=45, message="ysfs长度不能超过 45 个字符")
	public String getYsfs() {
		return ysfs;
	}

	public void setYsfs(String ysfs) {
		this.ysfs = ysfs;
	}
	
	@Length(min=0, max=451, message="ips长度不能超过 451 个字符")
	public String getIps() {
		return ips;
	}

	public void setIps(String ips) {
		this.ips = ips;
	}
	
	@Length(min=0, max=451, message="yhjid长度不能超过 451 个字符")
	public String getYhjid() {
		return yhjid;
	}

	public void setYhjid(String yhjid) {
		this.yhjid = yhjid;
	}
	
	@Length(min=0, max=451, message="yhjbh长度不能超过 451 个字符")
	public String getYhjbh() {
		return yhjbh;
	}

	public void setYhjbh(String yhjbh) {
		this.yhjbh = yhjbh;
	}
	
	public Double getMiusmoney() {
		return miusmoney;
	}

	public void setMiusmoney(Double miusmoney) {
		this.miusmoney = miusmoney;
	}
	
	@Length(min=0, max=451, message="bussinessid长度不能超过 451 个字符")
	public String getBussinessid() {
		return bussinessid;
	}

	public void setBussinessid(String bussinessid) {
		this.bussinessid = bussinessid;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPaytime() {
		return paytime;
	}

	public void setPaytime(Date paytime) {
		this.paytime = paytime;
	}
	
	@Length(min=0, max=451, message="peijian1长度不能超过 451 个字符")
	public String getPeijian1() {
		return peijian1;
	}

	public void setPeijian1(String peijian1) {
		this.peijian1 = peijian1;
	}
	
	@Length(min=0, max=451, message="peijian2长度不能超过 451 个字符")
	public String getPeijian2() {
		return peijian2;
	}

	public void setPeijian2(String peijian2) {
		this.peijian2 = peijian2;
	}
	
	@Length(min=0, max=451, message="serverlist长度不能超过 451 个字符")
	public String getServerlist() {
		return serverlist;
	}

	public void setServerlist(String serverlist) {
		this.serverlist = serverlist;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getServertime() {
		return servertime;
	}

	public void setServertime(Date servertime) {
		this.servertime = servertime;
	}
	
	@Length(min=0, max=4511, message="zhaopian长度不能超过 4511 个字符")
	public String getZhaopian() {
		return zhaopian;
	}

	public void setZhaopian(String zhaopian) {
		this.zhaopian = zhaopian;
	}
	
	@Length(min=0, max=451, message="kaipiao长度不能超过 451 个字符")
	public String getKaipiao() {
		return kaipiao;
	}

	public void setKaipiao(String kaipiao) {
		this.kaipiao = kaipiao;
	}
	
	@Length(min=0, max=451, message="isservice长度不能超过 451 个字符")
	public String getIsservice() {
		return isservice;
	}

	public void setIsservice(String isservice) {
		this.isservice = isservice;
	}
	
	@Length(min=0, max=4, message="delstatus长度不能超过 4 个字符")
	public String getDelstatus() {
		return delstatus;
	}

	public void setDelstatus(String delstatus) {
		this.delstatus = delstatus;
	}
	
	@Length(min=0, max=451, message="的长度不能超过 451 个字符")
	public String getKangzzhongcall() {
		return kangzzhongcall;
	}

	public void setKangzzhongcall(String kangzzhongcall) {
		this.kangzzhongcall = kangzzhongcall;
	}
	
	public Double getLon() {
		return lon;
	}

	public void setLon(Double lon) {
		this.lon = lon;
	}
	
	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getWcsj() {
		return wcsj;
	}

	public void setWcsj(Date wcsj) {
		this.wcsj = wcsj;
	}
	
	@Length(min=0, max=111, message="wcdd长度不能超过 111 个字符")
	public String getWcdd() {
		return wcdd;
	}

	public void setWcdd(String wcdd) {
		this.wcdd = wcdd;
	}
	
	@Length(min=0, max=4, message="isprints长度不能超过 4 个字符")
	public String getIsprints() {
		return isprints;
	}

	public void setIsprints(String isprints) {
		this.isprints = isprints;
	}
	
}