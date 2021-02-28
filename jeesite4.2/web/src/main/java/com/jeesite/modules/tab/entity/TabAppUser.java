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
 * tab_app_userEntity
 * @author 高峰
 * @version 2020-09-28
 */
@Table(name="tab_app_user", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="rowid", isPK=true),
		@Column(name="username", attrName="username", label="账号"),
		@Column(name="password", attrName="password", label="密码"),
		@Column(name="nickname", attrName="nickname", label="昵称"),
		@Column(name="createtime", attrName="createtime", label="创建时间"),
		@Column(name="logincode", attrName="logincode", label="登录用户"),
	}, orderBy="a.rowid DESC"
)
public class TabAppUser extends DataEntity<TabAppUser> {
	
	private static final long serialVersionUID = 1L;
	private String rowid;		// rowid
	private String username;		// 账号
	private String password;		// 密码
	private String nickname;		// 昵称
	private Date createtime;		// 创建时间
	private String logincode;		// 登录用户
	
	public TabAppUser() {
		this(null);
	}

	public TabAppUser(String id){
		super(id);
	}
	
	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	@Length(min=0, max=45, message="账号长度不能超过 45 个字符")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Length(min=0, max=45, message="密码长度不能超过 45 个字符")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Length(min=0, max=45, message="昵称长度不能超过 45 个字符")
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	@Length(min=0, max=451, message="登录用户长度不能超过 451 个字符")
	public String getLogincode() {
		return logincode;
	}

	public void setLogincode(String logincode) {
		this.logincode = logincode;
	}
	
}