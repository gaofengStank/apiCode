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
 * tab_pachong_dataEntity
 * @author 高峰
 * @version 2020-10-02
 */
@Table(name="tab_pachong_data", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="rowid", isPK=true),
		@Column(name="name", attrName="name", label="商家名称", queryType=QueryType.LIKE),
		@Column(name="zsfw", attrName="zsfw", label="招商范围"),
		@Column(name="gspp", attrName="gspp", label="公司品牌"),
		@Column(name="fbsj", attrName="fbsj", label="发布时间", comment="发布时间："),
		@Column(name="zycp", attrName="zycp", label="主营产品"),
		@Column(name="gsdz", attrName="gsdz", label="公司地址"),
		@Column(name="jmrx", attrName="jmrx", label="加盟热线"),
		@Column(name="lxxm", attrName="lxxm", label="联系姓名"),
		@Column(name="fenlei", attrName="fenlei", label="分类"),
	}, orderBy="a.rowid DESC"
)
public class TabPachongData extends DataEntity<TabPachongData> {
	
	private static final long serialVersionUID = 1L;
	private String rowid;		// rowid
	private String name;		// 商家名称
	private String zsfw;		// 招商范围
	private String gspp;		// 公司品牌
	private Date fbsj;		// 发布时间：
	private String zycp;		// 主营产品
	private String gsdz;		// 公司地址
	private String jmrx;		// 加盟热线
	private String lxxm;		// 联系姓名
	private String fenlei;		// 分类
	
	public TabPachongData() {
		this(null);
	}

	public TabPachongData(String id){
		super(id);
	}
	
	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	@Length(min=0, max=45, message="商家名称长度不能超过 45 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=45, message="招商范围长度不能超过 45 个字符")
	public String getZsfw() {
		return zsfw;
	}

	public void setZsfw(String zsfw) {
		this.zsfw = zsfw;
	}
	
	@Length(min=0, max=45, message="公司品牌长度不能超过 45 个字符")
	public String getGspp() {
		return gspp;
	}

	public void setGspp(String gspp) {
		this.gspp = gspp;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getFbsj() {
		return fbsj;
	}

	public void setFbsj(Date fbsj) {
		this.fbsj = fbsj;
	}
	
	@Length(min=0, max=451, message="主营产品长度不能超过 451 个字符")
	public String getZycp() {
		return zycp;
	}

	public void setZycp(String zycp) {
		this.zycp = zycp;
	}
	
	@Length(min=0, max=45, message="公司地址长度不能超过 45 个字符")
	public String getGsdz() {
		return gsdz;
	}

	public void setGsdz(String gsdz) {
		this.gsdz = gsdz;
	}
	
	@Length(min=0, max=100, message="加盟热线长度不能超过 100 个字符")
	public String getJmrx() {
		return jmrx;
	}

	public void setJmrx(String jmrx) {
		this.jmrx = jmrx;
	}
	
	@Length(min=0, max=45, message="联系姓名长度不能超过 45 个字符")
	public String getLxxm() {
		return lxxm;
	}

	public void setLxxm(String lxxm) {
		this.lxxm = lxxm;
	}
	
	@Length(min=0, max=45, message="分类长度不能超过 45 个字符")
	public String getFenlei() {
		return fenlei;
	}

	public void setFenlei(String fenlei) {
		this.fenlei = fenlei;
	}
	
}