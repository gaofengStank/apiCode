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
 * 会员表Entity
 * @author 高峰
 * @version 2021-02-16
 */
@Table(name="shop_user_member", alias="a", columns={
		@Column(name="uid", attrName="uid", label="用户id", isPK=true),
		@Column(name="reg_type", attrName="regType", label="注册类型"),
		@Column(name="wechat_openid", attrName="wechatOpenid", label="微信服务号openid"),
		@Column(name="wechat_openid_xcx", attrName="wechatOpenidXcx", label="微信小程序openid"),
		@Column(name="wechat_openid_pc", attrName="wechatOpenidPc", label="微信电脑端openid"),
		@Column(name="sina_openid", attrName="sinaOpenid", label="新浪微博openid"),
		@Column(name="qq_openid", attrName="qqOpenid", label="qq登录openid"),
		@Column(name="wechat_subscribe", attrName="wechatSubscribe", label="是否有订阅服务号，0否，1是"),
		@Column(name="username", attrName="username", label="用户名"),
		@Column(name="password", attrName="password", label="密码"),
		@Column(name="checked", attrName="checked", label="是否审核"),
		@Column(name="nickname", attrName="nickname", label="昵称"),
		@Column(name="sex", attrName="sex", label="性别"),
		@Column(name="userpic", attrName="userpic", label="会员头像"),
		@Column(name="is_agent", attrName="isAgent", label="是否是代理商"),
		@Column(name="pid", attrName="pid", label="上级id"),
		@Column(name="agent_level", attrName="agentLevel", label="代理级别"),
		@Column(name="total_bonus", attrName="totalBonus", label="代理商奖金"),
		@Column(name="points", attrName="points", label="积分"),
		@Column(name="cash_points", attrName="cashPoints", label="已经兑换积分"),
		@Column(name="insurance_name", attrName="insuranceName", label="insurance_name", isInsert=false, isUpdate=false, isQuery=false),
		@Column(name="cjh", attrName="cjh", label="cjh", isInsert=false, isUpdate=false, isQuery=false),
		@Column(name="cph", attrName="cph", label="cph", isInsert=false, isUpdate=false, isQuery=false),
		@Column(name="car_model", attrName="carModel", label="car_model", isInsert=false, isUpdate=false, isQuery=false),
		@Column(name="predeposit", attrName="predeposit", label="预存款余额"),
		@Column(name="use_predeposit", attrName="usePredeposit", label="已使用预存款"),
		@Column(name="wish", attrName="wish", label="收藏的数量"),
		@Column(name="regdate", attrName="regdate", label="注册时间"),
		@Column(name="lastdate", attrName="lastdate", label="最后登录时间"),
		@Column(name="regip", attrName="regip", label="注册ip"),
		@Column(name="lastip", attrName="lastip", label="上次登录ip"),
		@Column(name="loginnum", attrName="loginnum", label="登陆次数"),
		@Column(name="email", attrName="email", label="电子邮箱"),
		@Column(name="telephone", attrName="telephone", label="telephone"),
		@Column(name="groupid", attrName="groupid", label="用户组id"),
		@Column(name="areaid", attrName="areaid", label="地区id"),
		@Column(name="message", attrName="message", label="是否有短消息"),
		@Column(name="maintain_date", attrName="maintainDate", label="maintain_date"),
		@Column(name="insurance_date", attrName="insuranceDate", label="insurance_date"),
		@Column(name="islock", attrName="islock", label="是否锁定"),
		@Column(name="parame1", attrName="parame1", label="parame1"),
		@Column(name="usertype", attrName="usertype", label="用户类型"),
		@Column(name="realname", attrName="realname", label="realname"),
		@Column(name="logoutdate", attrName="logoutdate", label="注销 事件"),
		@Column(name="city", attrName="city", label="city"),
		@Column(name="parentid", attrName="parentid", label="parentid"),
		@Column(name="car_status", attrName="carStatus", label="car_status"),
		@Column(name="postid", attrName="postid", label="编号"),
		@Column(name="companyid", attrName="companyid", label="companyid"),
		@Column(name="isshiming", attrName="isshiming", label="isshiming"),
		@Column(name="status1", attrName="status1", label="status1"),
		@Column(name="checkuser", attrName="checkuser", label="checkuser"),
		@Column(name="checkdate", attrName="checkdate", label="checkdate"),
		@Column(name="totalmney", attrName="totalmney", label="totalmney"),
		@Column(name="txpasswd", attrName="txpasswd", label="txpasswd"),
		@Column(name="basecity", attrName="basecity", label="basecity"),
		@Column(name="userpaylevel", attrName="userpaylevel", label="userpaylevel"),
	}, orderBy="a.uid DESC"
)
public class ShopUserMember extends DataEntity<ShopUserMember> {
	
	private static final long serialVersionUID = 1L;
	private String uid;		// 用户id
	private String regType;		// 注册类型
	private String wechatOpenid;		// 微信服务号openid
	private String wechatOpenidXcx;		// 微信小程序openid
	private String wechatOpenidPc;		// 微信电脑端openid
	private String sinaOpenid;		// 新浪微博openid
	private String qqOpenid;		// qq登录openid
	private Integer wechatSubscribe;		// 是否有订阅服务号，0否，1是
	private String username;		// 用户名
	private String password;		// 密码
	private Integer checked;		// 是否审核
	private String nickname;		// 昵称
	private String sex;		// 性别
	private String userpic;		// 会员头像
	private Long isAgent;		// 是否是代理商
	private Integer pid;		// 上级id
	private Integer agentLevel;		// 代理级别
	private Double totalBonus;		// 代理商奖金
	private Integer points;		// 积分
	private Integer cashPoints;		// 已经兑换积分
	private String insuranceName;		// insurance_name
	private String cjh;		// cjh
	private String cph;		// cph
	private String carModel;		// car_model
	private Double predeposit;		// 预存款余额
	private Double usePredeposit;		// 已使用预存款
	private Integer wish;		// 收藏的数量
	private Date regdate;		// 注册时间
	private Date lastdate;		// 最后登录时间
	private String regip;		// 注册ip
	private String lastip;		// 上次登录ip
	private Integer loginnum;		// 登陆次数
	private String email;		// 电子邮箱
	private String telephone;		// telephone
	private Integer groupid;		// 用户组id
	private String areaid;		// 地区id
	private Integer message;		// 是否有短消息
	private Date maintainDate;		// maintain_date
	private Date insuranceDate;		// insurance_date
	private Integer islock;		// 是否锁定
	private String parame1;		// parame1
	private String usertype;		// 用户类型
	private String realname;		// realname
	private Date logoutdate;		// 注销 事件
	private String city;		// city
	private String parentid;		// parentid
	private String carStatus;		// car_status
	private String postid;		// 编号
	private String companyid;		// companyid
	private String isshiming;		// isshiming
	private String status1;		// status1
	private String checkuser;		// checkuser
	private Date checkdate;		// checkdate
	private Double totalmney;		// totalmney
	private String txpasswd;		// txpasswd
	private String basecity;		// basecity
	private String userpaylevel;		// userpaylevel
	
	public ShopUserMember() {
		this(null);
	}

	public ShopUserMember(String id){
		super(id);
	}
	
	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}
	
	@Length(min=0, max=20, message="注册类型长度不能超过 20 个字符")
	public String getRegType() {
		return regType;
	}

	public void setRegType(String regType) {
		this.regType = regType;
	}
	
	@Length(min=0, max=128, message="微信服务号openid长度不能超过 128 个字符")
	public String getWechatOpenid() {
		return wechatOpenid;
	}

	public void setWechatOpenid(String wechatOpenid) {
		this.wechatOpenid = wechatOpenid;
	}
	
	@Length(min=0, max=128, message="微信小程序openid长度不能超过 128 个字符")
	public String getWechatOpenidXcx() {
		return wechatOpenidXcx;
	}

	public void setWechatOpenidXcx(String wechatOpenidXcx) {
		this.wechatOpenidXcx = wechatOpenidXcx;
	}
	
	@Length(min=0, max=200, message="微信电脑端openid长度不能超过 200 个字符")
	public String getWechatOpenidPc() {
		return wechatOpenidPc;
	}

	public void setWechatOpenidPc(String wechatOpenidPc) {
		this.wechatOpenidPc = wechatOpenidPc;
	}
	
	@Length(min=0, max=200, message="新浪微博openid长度不能超过 200 个字符")
	public String getSinaOpenid() {
		return sinaOpenid;
	}

	public void setSinaOpenid(String sinaOpenid) {
		this.sinaOpenid = sinaOpenid;
	}
	
	@Length(min=0, max=200, message="qq登录openid长度不能超过 200 个字符")
	public String getQqOpenid() {
		return qqOpenid;
	}

	public void setQqOpenid(String qqOpenid) {
		this.qqOpenid = qqOpenid;
	}
	
	public Integer getWechatSubscribe() {
		return wechatSubscribe;
	}

	public void setWechatSubscribe(Integer wechatSubscribe) {
		this.wechatSubscribe = wechatSubscribe;
	}
	
	@Length(min=0, max=20, message="用户名长度不能超过 20 个字符")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	@Length(min=0, max=128, message="密码长度不能超过 128 个字符")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public Integer getChecked() {
		return checked;
	}

	public void setChecked(Integer checked) {
		this.checked = checked;
	}
	
	@Length(min=0, max=50, message="昵称长度不能超过 50 个字符")
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Length(min=0, max=111, message="性别长度不能超过 111 个字符")
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Length(min=0, max=255, message="会员头像长度不能超过 255 个字符")
	public String getUserpic() {
		return userpic;
	}

	public void setUserpic(String userpic) {
		this.userpic = userpic;
	}
	
	public Long getIsAgent() {
		return isAgent;
	}

	public void setIsAgent(Long isAgent) {
		this.isAgent = isAgent;
	}
	
	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}
	
	public Integer getAgentLevel() {
		return agentLevel;
	}

	public void setAgentLevel(Integer agentLevel) {
		this.agentLevel = agentLevel;
	}
	
	public Double getTotalBonus() {
		return totalBonus;
	}

	public void setTotalBonus(Double totalBonus) {
		this.totalBonus = totalBonus;
	}
	
	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}
	
	public Integer getCashPoints() {
		return cashPoints;
	}

	public void setCashPoints(Integer cashPoints) {
		this.cashPoints = cashPoints;
	}
	
	@Length(min=0, max=255, message="insurance_name长度不能超过 255 个字符")
	public String getInsuranceName() {
		return insuranceName;
	}

	public void setInsuranceName(String insuranceName) {
		this.insuranceName = insuranceName;
	}
	
	@Length(min=0, max=255, message="cjh长度不能超过 255 个字符")
	public String getCjh() {
		return cjh;
	}

	public void setCjh(String cjh) {
		this.cjh = cjh;
	}
	
	@Length(min=0, max=100, message="cph长度不能超过 100 个字符")
	public String getCph() {
		return cph;
	}

	public void setCph(String cph) {
		this.cph = cph;
	}
	
	@Length(min=0, max=255, message="car_model长度不能超过 255 个字符")
	public String getCarModel() {
		return carModel;
	}

	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	
	public Double getPredeposit() {
		return predeposit;
	}

	public void setPredeposit(Double predeposit) {
		this.predeposit = predeposit;
	}
	
	public Double getUsePredeposit() {
		return usePredeposit;
	}

	public void setUsePredeposit(Double usePredeposit) {
		this.usePredeposit = usePredeposit;
	}
	
	public Integer getWish() {
		return wish;
	}

	public void setWish(Integer wish) {
		this.wish = wish;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getLastdate() {
		return lastdate;
	}

	public void setLastdate(Date lastdate) {
		this.lastdate = lastdate;
	}
	
	@Length(min=0, max=15, message="注册ip长度不能超过 15 个字符")
	public String getRegip() {
		return regip;
	}

	public void setRegip(String regip) {
		this.regip = regip;
	}
	
	@Length(min=0, max=15, message="上次登录ip长度不能超过 15 个字符")
	public String getLastip() {
		return lastip;
	}

	public void setLastip(String lastip) {
		this.lastip = lastip;
	}
	
	public Integer getLoginnum() {
		return loginnum;
	}

	public void setLoginnum(Integer loginnum) {
		this.loginnum = loginnum;
	}
	
	@Length(min=0, max=32, message="电子邮箱长度不能超过 32 个字符")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Length(min=0, max=20, message="telephone长度不能超过 20 个字符")
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}
	
	@Length(min=0, max=111, message="地区id长度不能超过 111 个字符")
	public String getAreaid() {
		return areaid;
	}

	public void setAreaid(String areaid) {
		this.areaid = areaid;
	}
	
	public Integer getMessage() {
		return message;
	}

	public void setMessage(Integer message) {
		this.message = message;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getMaintainDate() {
		return maintainDate;
	}

	public void setMaintainDate(Date maintainDate) {
		this.maintainDate = maintainDate;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getInsuranceDate() {
		return insuranceDate;
	}

	public void setInsuranceDate(Date insuranceDate) {
		this.insuranceDate = insuranceDate;
	}
	
	public Integer getIslock() {
		return islock;
	}

	public void setIslock(Integer islock) {
		this.islock = islock;
	}
	
	@Length(min=0, max=45, message="parame1长度不能超过 45 个字符")
	public String getParame1() {
		return parame1;
	}

	public void setParame1(String parame1) {
		this.parame1 = parame1;
	}
	
	@Length(min=0, max=45, message="用户类型长度不能超过 45 个字符")
	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	@Length(min=0, max=45, message="realname长度不能超过 45 个字符")
	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getLogoutdate() {
		return logoutdate;
	}

	public void setLogoutdate(Date logoutdate) {
		this.logoutdate = logoutdate;
	}
	
	@Length(min=0, max=451, message="city长度不能超过 451 个字符")
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Length(min=0, max=451, message="parentid长度不能超过 451 个字符")
	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	
	@Length(min=0, max=45, message="car_status长度不能超过 45 个字符")
	public String getCarStatus() {
		return carStatus;
	}

	public void setCarStatus(String carStatus) {
		this.carStatus = carStatus;
	}
	
	@Length(min=0, max=451, message="编号长度不能超过 451 个字符")
	public String getPostid() {
		return postid;
	}

	public void setPostid(String postid) {
		this.postid = postid;
	}
	
	@Length(min=0, max=451, message="companyid长度不能超过 451 个字符")
	public String getCompanyid() {
		return companyid;
	}

	public void setCompanyid(String companyid) {
		this.companyid = companyid;
	}
	
	@Length(min=0, max=45, message="isshiming长度不能超过 45 个字符")
	public String getIsshiming() {
		return isshiming;
	}

	public void setIsshiming(String isshiming) {
		this.isshiming = isshiming;
	}
	
	@Length(min=0, max=45, message="status1长度不能超过 45 个字符")
	public String getStatus1() {
		return status1;
	}

	public void setStatus1(String status1) {
		this.status1 = status1;
	}
	
	@Length(min=0, max=45, message="checkuser长度不能超过 45 个字符")
	public String getCheckuser() {
		return checkuser;
	}

	public void setCheckuser(String checkuser) {
		this.checkuser = checkuser;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCheckdate() {
		return checkdate;
	}

	public void setCheckdate(Date checkdate) {
		this.checkdate = checkdate;
	}
	
	public Double getTotalmney() {
		return totalmney;
	}

	public void setTotalmney(Double totalmney) {
		this.totalmney = totalmney;
	}
	
	@Length(min=0, max=451, message="txpasswd长度不能超过 451 个字符")
	public String getTxpasswd() {
		return txpasswd;
	}

	public void setTxpasswd(String txpasswd) {
		this.txpasswd = txpasswd;
	}
	
	@Length(min=0, max=451, message="basecity长度不能超过 451 个字符")
	public String getBasecity() {
		return basecity;
	}

	public void setBasecity(String basecity) {
		this.basecity = basecity;
	}
	
	@Length(min=0, max=45, message="userpaylevel长度不能超过 45 个字符")
	public String getUserpaylevel() {
		return userpaylevel;
	}

	public void setUserpaylevel(String userpaylevel) {
		this.userpaylevel = userpaylevel;
	}
	
}