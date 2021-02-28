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
 * tab_productEntity
 * @author 高峰
 * @version 2020-12-24
 */
@Table(name="tab_product", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="rowid", isPK=true),
		@Column(name="bussid", attrName="bussid", label="商家编号"),
		@Column(name="productname", attrName="productname", label="产品名称"),
		@Column(name="selllength", attrName="selllength", label="销售量"),
		@Column(name="price1", attrName="price1", label="原价"),
		@Column(name="price2", attrName="price2", label="销售价"),
		@Column(name="tyoe", attrName="tyoe", label="分类"),
		@Column(name="chandi", attrName="chandi", label="产地"),
		@Column(name="imgsrc", attrName="imgsrc", label="图集"),
		@Column(name="productimg", attrName="productimg", label="缩略图"),
		@Column(name="miaoshu", attrName="miaoshu", label="描述"),
		@Column(name="createtime", attrName="createtime", label="创建时间"),
		@Column(name="bussname", attrName="bussname", label="商家名称"),
		@Column(name="videourl", attrName="videourl", label="视频集"),
	}, orderBy="a.rowid DESC"
)
public class TabProduct extends DataEntity<TabProduct> {
	
	private static final long serialVersionUID = 1L;
	private String rowid;		// rowid
	private String bussid;		// 商家编号
	private String productname;		// 产品名称
	private Long selllength;		// 销售量
	private Double price1;		// 原价
	private Double price2;		// 销售价
	private String tyoe;		// 分类
	private String chandi;		// 产地
	private String imgsrc;		// 图集
	private String productimg;		// 缩略图
	private String miaoshu;		// 描述
	private Date createtime;		// 创建时间
	private String bussname;		// 商家名称
	private String videourl;		// 视频集
	
	public TabProduct() {
		this(null);
	}

	public TabProduct(String id){
		super(id);
	}
	
	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	@Length(min=0, max=451, message="商家编号长度不能超过 451 个字符")
	public String getBussid() {
		return bussid;
	}

	public void setBussid(String bussid) {
		this.bussid = bussid;
	}
	
	@Length(min=0, max=45, message="产品名称长度不能超过 45 个字符")
	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}
	
	public Long getSelllength() {
		return selllength;
	}

	public void setSelllength(Long selllength) {
		this.selllength = selllength;
	}
	
	public Double getPrice1() {
		return price1;
	}

	public void setPrice1(Double price1) {
		this.price1 = price1;
	}
	
	public Double getPrice2() {
		return price2;
	}

	public void setPrice2(Double price2) {
		this.price2 = price2;
	}
	
	@Length(min=0, max=45, message="分类长度不能超过 45 个字符")
	public String getTyoe() {
		return tyoe;
	}

	public void setTyoe(String tyoe) {
		this.tyoe = tyoe;
	}
	
	@Length(min=0, max=451, message="产地长度不能超过 451 个字符")
	public String getChandi() {
		return chandi;
	}

	public void setChandi(String chandi) {
		this.chandi = chandi;
	}
	
	@Length(min=0, max=451, message="图集长度不能超过 451 个字符")
	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
	
	@Length(min=0, max=451, message="缩略图长度不能超过 451 个字符")
	public String getProductimg() {
		return productimg;
	}

	public void setProductimg(String productimg) {
		this.productimg = productimg;
	}
	
	public String getMiaoshu() {
		return miaoshu;
	}

	public void setMiaoshu(String miaoshu) {
		this.miaoshu = miaoshu;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	@Length(min=0, max=45, message="商家名称长度不能超过 45 个字符")
	public String getBussname() {
		return bussname;
	}

	public void setBussname(String bussname) {
		this.bussname = bussname;
	}
	
	@Length(min=0, max=451, message="视频集长度不能超过 451 个字符")
	public String getVideourl() {
		return videourl;
	}

	public void setVideourl(String videourl) {
		this.videourl = videourl;
	}
	
}