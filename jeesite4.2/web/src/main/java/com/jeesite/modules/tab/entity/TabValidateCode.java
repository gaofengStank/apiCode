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
 * tab_validate_codeEntity
 * @author 高峰
 * @version 2021-02-20
 */
@Table(name="tab_validate_code", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="phone", attrName="phone", label="手机号"),
		@Column(name="code", attrName="code", label="验证码"),
		@Column(name="createtime", attrName="createtime", label="创建时间"),
		@Column(name="validate_time", attrName="validateTime", label="过期时间"),
		@Column(name="flag", attrName="flag", label="状态"),
	}, orderBy="a.id DESC"
)
public class TabValidateCode extends DataEntity<TabValidateCode> {
	
	private static final long serialVersionUID = 1L;
	private String phone;		// 手机号
	private String code;		// 验证码
	private Date createtime;		// 创建时间
	private Date validateTime;		// 过期时间
	private String flag;		// 状态
	
	public TabValidateCode() {
		this(null);
	}

	public TabValidateCode(String id){
		super(id);
	}
	
	@Length(min=0, max=11, message="手机号长度不能超过 11 个字符")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Length(min=0, max=6, message="验证码长度不能超过 6 个字符")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getValidateTime() {
		return validateTime;
	}

	public void setValidateTime(Date validateTime) {
		this.validateTime = validateTime;
	}
	
	@Length(min=0, max=1, message="状态长度不能超过 1 个字符")
	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}
	
}