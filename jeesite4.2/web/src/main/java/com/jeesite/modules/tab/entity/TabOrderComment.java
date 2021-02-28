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
 * tab_order_commentEntity
 * @author 高峰
 * @version 2021-02-19
 */
@Table(name="tab_order_comment", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="rowid", isPK=true),
		@Column(name="userid", attrName="userid", label="userid"),
		@Column(name="orderid", attrName="orderid", label="orderid"),
		@Column(name="productid", attrName="productid", label="productid"),
		@Column(name="content", attrName="content", label="content"),
		@Column(name="createtime", attrName="createtime", label="createtime"),
		@Column(name="parame1", attrName="parame1", label="parame1"),
		@Column(name="parame2", attrName="parame2", label="parame2"),
		@Column(name="parame3", attrName="parame3", label="parame3"),
		@Column(name="leval", attrName="leval", label="leval"),
		@Column(name="bussinessid", attrName="bussinessid", label="bussinessid"),
		@Column(name="source", attrName="source", label="source"),
		@Column(name="replay", attrName="replay", label="replay"),
		@Column(name="replaydate", attrName="replaydate", label="replaydate"),
		@Column(name="orderlistid", attrName="orderlistid", label="orderlistid"),
		@Column(name="imgsrc", attrName="imgsrc", label="imgsrc"),
		@Column(name="nickname", attrName="nickname", label="昵称"),
		@Column(name="imglist", attrName="imglist", label="imglist"),
	}, orderBy="a.rowid DESC"
)
public class TabOrderComment extends DataEntity<TabOrderComment> {
	
	private static final long serialVersionUID = 1L;
	private String rowid;		// rowid
	private String userid;		// userid
	private String orderid;		// orderid
	private String productid;		// productid
	private String content;		// content
	private Date createtime;		// createtime
	private String parame1;		// parame1
	private String parame2;		// parame2
	private String parame3;		// parame3
	private String leval;		// leval
	private String bussinessid;		// bussinessid
	private Double source;		// source
	private String replay;		// replay
	private Date replaydate;		// replaydate
	private String orderlistid;		// orderlistid
	private String imgsrc;		// imgsrc
	private String nickname;		// 昵称
	private String imglist;		// imglist
	
	public TabOrderComment() {
		this(null);
	}

	public TabOrderComment(String id){
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
	
	@Length(min=0, max=451, message="content长度不能超过 451 个字符")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
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
	
	@Length(min=0, max=45, message="leval长度不能超过 45 个字符")
	public String getLeval() {
		return leval;
	}

	public void setLeval(String leval) {
		this.leval = leval;
	}
	
	@Length(min=0, max=451, message="bussinessid长度不能超过 451 个字符")
	public String getBussinessid() {
		return bussinessid;
	}

	public void setBussinessid(String bussinessid) {
		this.bussinessid = bussinessid;
	}
	
	public Double getSource() {
		return source;
	}

	public void setSource(Double source) {
		this.source = source;
	}
	
	@Length(min=0, max=451, message="replay长度不能超过 451 个字符")
	public String getReplay() {
		return replay;
	}

	public void setReplay(String replay) {
		this.replay = replay;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getReplaydate() {
		return replaydate;
	}

	public void setReplaydate(Date replaydate) {
		this.replaydate = replaydate;
	}
	
	@Length(min=0, max=451, message="orderlistid长度不能超过 451 个字符")
	public String getOrderlistid() {
		return orderlistid;
	}

	public void setOrderlistid(String orderlistid) {
		this.orderlistid = orderlistid;
	}
	
	@Length(min=0, max=451, message="imgsrc长度不能超过 451 个字符")
	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
	
	@Length(min=0, max=45, message="昵称长度不能超过 45 个字符")
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Length(min=0, max=1000, message="imglist长度不能超过 1000 个字符")
	public String getImglist() {
		return imglist;
	}

	public void setImglist(String imglist) {
		this.imglist = imglist;
	}
	
}