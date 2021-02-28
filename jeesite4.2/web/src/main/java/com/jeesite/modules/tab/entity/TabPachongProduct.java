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
 * tab_pachong_productEntity
 * @author 高峰
 * @version 2020-10-03
 */
@Table(name="tab_pachong_product", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="rowid", isPK=true),
		@Column(name="name", attrName="name", label="商品名称", queryType=QueryType.LIKE),
		@Column(name="sj", attrName="sj", label="商家"),
		@Column(name="dq", attrName="dq", label="地区"),
		@Column(name="lb", attrName="lb", label="类别"),
		@Column(name="pp", attrName="pp", label="品牌"),
		@Column(name="chandi", attrName="chandi", label="产地"),
		@Column(name="xinghao", attrName="xinghao", label="型号"),
		@Column(name="lxxm", attrName="lxxm", label="联系姓名"),
		@Column(name="lxdz", attrName="lxdz", label="联系地址"),
		@Column(name="dzyx", attrName="dzyx", label="电子邮箱"),
		@Column(name="sjgw", attrName="sjgw", label="商家主页"),
		@Column(name="createtime", attrName="createtime", label="创建时间"),
		@Column(name="links", attrName="links", label="链接地址"),
	}, orderBy="a.createtime DESC"
)
public class TabPachongProduct extends DataEntity<TabPachongProduct> {
	
	private static final long serialVersionUID = 1L;
	private String rowid;		// rowid
	private String name;		// 商品名称
	private String sj;		// 商家
	private String dq;		// 地区
	private String lb;		// 类别
	private String pp;		// 品牌
	private String chandi;		// 产地
	private String xinghao;		// 型号
	private String lxxm;		// 联系姓名
	private String lxdz;		// 联系地址
	private String dzyx;		// 电子邮箱
	private String sjgw;		// 商家主页
	private Date createtime;		// 创建时间
	private String links;		// 链接地址
	
	public TabPachongProduct() {
		this(null);
	}

	public TabPachongProduct(String id){
		super(id);
	}
	
	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	@Length(min=0, max=45, message="商品名称长度不能超过 45 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=45, message="商家长度不能超过 45 个字符")
	public String getSj() {
		return sj;
	}

	public void setSj(String sj) {
		this.sj = sj;
	}
	
	@Length(min=0, max=45, message="地区长度不能超过 45 个字符")
	public String getDq() {
		return dq;
	}

	public void setDq(String dq) {
		this.dq = dq;
	}
	
	@Length(min=0, max=45, message="类别长度不能超过 45 个字符")
	public String getLb() {
		return lb;
	}

	public void setLb(String lb) {
		this.lb = lb;
	}
	
	@Length(min=0, max=45, message="品牌长度不能超过 45 个字符")
	public String getPp() {
		return pp;
	}

	public void setPp(String pp) {
		this.pp = pp;
	}
	
	@Length(min=0, max=45, message="产地长度不能超过 45 个字符")
	public String getChandi() {
		return chandi;
	}

	public void setChandi(String chandi) {
		this.chandi = chandi;
	}
	
	@Length(min=0, max=45, message="型号长度不能超过 45 个字符")
	public String getXinghao() {
		return xinghao;
	}

	public void setXinghao(String xinghao) {
		this.xinghao = xinghao;
	}
	
	@Length(min=0, max=45, message="联系姓名长度不能超过 45 个字符")
	public String getLxxm() {
		return lxxm;
	}

	public void setLxxm(String lxxm) {
		this.lxxm = lxxm;
	}
	
	@Length(min=0, max=45, message="联系地址长度不能超过 45 个字符")
	public String getLxdz() {
		return lxdz;
	}

	public void setLxdz(String lxdz) {
		this.lxdz = lxdz;
	}
	
	@Length(min=0, max=45, message="电子邮箱长度不能超过 45 个字符")
	public String getDzyx() {
		return dzyx;
	}

	public void setDzyx(String dzyx) {
		this.dzyx = dzyx;
	}
	
	@Length(min=0, max=45, message="商家主页长度不能超过 45 个字符")
	public String getSjgw() {
		return sjgw;
	}

	public void setSjgw(String sjgw) {
		this.sjgw = sjgw;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	@Length(min=0, max=45, message="链接地址长度不能超过 45 个字符")
	public String getLinks() {
		return links;
	}

	public void setLinks(String links) {
		this.links = links;
	}
	
}