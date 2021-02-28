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
 * 商品信息表Entity
 * @author 高峰
 * @version 2021-02-16
 */
@Table(name="shop_goods", alias="a", columns={
		@Column(name="rowid", attrName="rowid", label="rowid", isPK=true),
		@Column(name="imgsrc", attrName="imgsrc", label="图片"),
		@Column(name="types", attrName="types", label="分类"),
		@Column(name="name", attrName="name", label="商品名称", queryType=QueryType.LIKE),
		@Column(name="selllength", attrName="selllength", label="销量"),
		@Column(name="xinghao", attrName="xinghao", label="型号"),
		@Column(name="scd", attrName="scd", label="生产地"),
		@Column(name="price1", attrName="price1", label="市场价"),
		@Column(name="pirce2", attrName="pirce2", label="销售价"),
		@Column(name="awardsource", attrName="awardsource", label="购买得积分"),
		@Column(name="kc", attrName="kc", label="库存"),
		@Column(name="miuskc", attrName="miuskc", label="扣减库存"),
		@Column(name="ispeisong", attrName="ispeisong", label="是否配送"),
		@Column(name="isyunfei", attrName="isyunfei", label="是否免运费"),
		@Column(name="weights", attrName="weights", label="总量"),
		@Column(name="cc", attrName="cc", label="尺寸"),
		@Column(name="status1", attrName="status1", label="状态"),
		@Column(name="orderindex", attrName="orderindex", label="排序"),
		@Column(name="viewlength", attrName="viewlength", label="浏览量"),
		@Column(name="fenlei", attrName="fenlei", label="分类"),
		@Column(name="desciprts", attrName="desciprts", label="描述"),
		@Column(name="createtime", attrName="createtime", label="提交时间"),
		@Column(name="imgslist", attrName="imgslist", label="图集"),
		@Column(name="status2", attrName="status2", label="审核状态"),
		@Column(name="ispush", attrName="ispush", label="是否推送"),
		@Column(name="isindex", attrName="isindex", label="是否推荐"),
		@Column(name="isnews", attrName="isnews", label="是否新品"),
		@Column(name="ewmlinks", attrName="ewmlinks", label="二维码链接"),
		@Column(name="hpl", attrName="hpl", label="好评率"),
		@Column(name="isdikou", attrName="isdikou", label="是否积分抵扣"),
		@Column(name="needsource", attrName="needsource", label="需要积分"),
		@Column(name="ismiaosha", attrName="ismiaosha", label="是否秒杀"),
		@Column(name="satrtms", attrName="satrtms", label="秒杀开始"),
		@Column(name="endms", attrName="endms", label="秒杀结束"),
		@Column(name="msmoney", attrName="msmoney", label="秒杀金额"),
		@Column(name="showindex", attrName="showindex", label="排序"),
		@Column(name="shenming", attrName="shenming", label="申明"),
		@Column(name="codes", attrName="codes", label="codes"),
		@Column(name="scph", attrName="scph", label="生产批号"),
		@Column(name="zxbz", attrName="zxbz", label="执行标准"),
		@Column(name="qydm", attrName="qydm", label="企业代码"),
		@Column(name="ccrq", attrName="ccrq", label="出厂日期"),
		@Column(name="yxq", attrName="yxq", label="有效期"),
		@Column(name="ndjb", attrName="ndjb", label="粘度级别", isInsert=false, isUpdate=false, isQuery=false),
		@Column(name="buss_id", attrName="bussId", label="商家编号"),
		@Column(name="hp", attrName="hp", label="有效期"),

		@Column(name="zp", attrName="zp", label="有效期"),

		@Column(name="cp", attrName="cp", label="有效期"),

	}, orderBy="a.rowid DESC"
)
public class ShopGoods extends DataEntity<ShopGoods> {
	private Long hp ;
	private Long zp ;
	private Long cp ; 
	
	private static final long serialVersionUID = 1L;
	private String rowid;		// rowid
	private String imgsrc;		// 图片
	private String types;		// 分类
	private String name;		// 商品名称
	private Long selllength;		// 销量
	private String xinghao;		// 型号
	private String scd;		// 生产地
	private Double price1;		// 市场价
	private Double pirce2;		// 销售价
	private Long awardsource;		// 购买得积分
	private Long kc;		// 库存
	private String miuskc;		// 扣减库存
	private String ispeisong;		// 是否配送
	private String isyunfei;		// 是否免运费
	private String weights;		// 总量
	private String cc;		// 尺寸
	private String status1;		// 状态
	private Long orderindex;		// 排序
	private Long viewlength;		// 浏览量
	private String fenlei;		// 分类
	private String desciprts;		// 描述
	private Date createtime;		// 提交时间
	private String imgslist;		// 图集
	private String status2;		// 审核状态
	private String ispush;		// 是否推送
	private String isindex;		// 是否推荐
	private String isnews;		// 是否新品
	private String ewmlinks;		// 二维码链接
	private String hpl;		// 好评率
	private String isdikou;		// 是否积分抵扣
	private Long needsource;		// 需要积分
	private String ismiaosha;		// 是否秒杀
	private Date satrtms;		// 秒杀开始
	private Date endms;		// 秒杀结束
	private Double msmoney;		// 秒杀金额
	private String showindex;		// 排序
	private String shenming;		// 申明
	private String codes;		// codes
	private String scph;		// 生产批号
	private String zxbz;		// 执行标准
	private String qydm;		// 企业代码
	private Date ccrq;		// 出厂日期
	private Date yxq;		// 有效期
	private String ndjb;		// 粘度级别
	private String bussId;		// 商家编号
	
	private  ShopBusiness shopBusiness ;
	
	
	
	public ShopBusiness getShopBusiness() {
		return shopBusiness;
	}

	public void setShopBusiness(ShopBusiness shopBusiness) {
		this.shopBusiness = shopBusiness;
	}

	public Long getHp() {
		return hp;
	}

	public void setHp(Long hp) {
		this.hp = hp;
	}

	public Long getZp() {
		return zp;
	}

	public void setZp(Long zp) {
		this.zp = zp;
	}

	public Long getCp() {
		return cp;
	}

	public void setCp(Long cp) {
		this.cp = cp;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ShopGoods() {
		this(null);
	}

	public ShopGoods(String id){
		super(id);
	}
	
	public String getRowid() {
		return rowid;
	}

	public void setRowid(String rowid) {
		this.rowid = rowid;
	}
	
	@Length(min=0, max=451, message="图片长度不能超过 451 个字符")
	public String getImgsrc() {
		return imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}
	
	@Length(min=0, max=111, message="分类长度不能超过 111 个字符")
	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}
	
	@Length(min=0, max=45, message="商品名称长度不能超过 45 个字符")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Long getSelllength() {
		return selllength;
	}

	public void setSelllength(Long selllength) {
		this.selllength = selllength;
	}
	
	@Length(min=0, max=45, message="型号长度不能超过 45 个字符")
	public String getXinghao() {
		return xinghao;
	}

	public void setXinghao(String xinghao) {
		this.xinghao = xinghao;
	}
	
	@Length(min=0, max=45, message="生产地长度不能超过 45 个字符")
	public String getScd() {
		return scd;
	}

	public void setScd(String scd) {
		this.scd = scd;
	}
	
	public Double getPrice1() {
		return price1;
	}

	public void setPrice1(Double price1) {
		this.price1 = price1;
	}
	
	public Double getPirce2() {
		return pirce2;
	}

	public void setPirce2(Double pirce2) {
		this.pirce2 = pirce2;
	}
	
	public Long getAwardsource() {
		return awardsource;
	}

	public void setAwardsource(Long awardsource) {
		this.awardsource = awardsource;
	}
	
	public Long getKc() {
		return kc;
	}

	public void setKc(Long kc) {
		this.kc = kc;
	}
	
	@Length(min=0, max=45, message="扣减库存长度不能超过 45 个字符")
	public String getMiuskc() {
		return miuskc;
	}

	public void setMiuskc(String miuskc) {
		this.miuskc = miuskc;
	}
	
	@Length(min=0, max=45, message="是否配送长度不能超过 45 个字符")
	public String getIspeisong() {
		return ispeisong;
	}

	public void setIspeisong(String ispeisong) {
		this.ispeisong = ispeisong;
	}
	
	@Length(min=0, max=45, message="是否免运费长度不能超过 45 个字符")
	public String getIsyunfei() {
		return isyunfei;
	}

	public void setIsyunfei(String isyunfei) {
		this.isyunfei = isyunfei;
	}
	
	@Length(min=0, max=45, message="总量长度不能超过 45 个字符")
	public String getWeights() {
		return weights;
	}

	public void setWeights(String weights) {
		this.weights = weights;
	}
	
	@Length(min=0, max=45, message="尺寸长度不能超过 45 个字符")
	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}
	
	@Length(min=0, max=45, message="状态长度不能超过 45 个字符")
	public String getStatus1() {
		return status1;
	}

	public void setStatus1(String status1) {
		this.status1 = status1;
	}
	
	public Long getOrderindex() {
		return orderindex;
	}

	public void setOrderindex(Long orderindex) {
		this.orderindex = orderindex;
	}
	
	public Long getViewlength() {
		return viewlength;
	}

	public void setViewlength(Long viewlength) {
		this.viewlength = viewlength;
	}
	
	@Length(min=0, max=45, message="分类长度不能超过 45 个字符")
	public String getFenlei() {
		return fenlei;
	}

	public void setFenlei(String fenlei) {
		this.fenlei = fenlei;
	}
	
	public String getDesciprts() {
		return desciprts;
	}

	public void setDesciprts(String desciprts) {
		this.desciprts = desciprts;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	
	@Length(min=0, max=4511, message="图集长度不能超过 4511 个字符")
	public String getImgslist() {
		return imgslist;
	}

	public void setImgslist(String imgslist) {
		this.imgslist = imgslist;
	}
	
	@Length(min=0, max=45, message="审核状态长度不能超过 45 个字符")
	public String getStatus2() {
		return status2;
	}

	public void setStatus2(String status2) {
		this.status2 = status2;
	}
	
	@Length(min=0, max=4, message="是否推送长度不能超过 4 个字符")
	public String getIspush() {
		return ispush;
	}

	public void setIspush(String ispush) {
		this.ispush = ispush;
	}
	
	@Length(min=0, max=4, message="是否推荐长度不能超过 4 个字符")
	public String getIsindex() {
		return isindex;
	}

	public void setIsindex(String isindex) {
		this.isindex = isindex;
	}
	
	@Length(min=0, max=4, message="是否新品长度不能超过 4 个字符")
	public String getIsnews() {
		return isnews;
	}

	public void setIsnews(String isnews) {
		this.isnews = isnews;
	}
	
	@Length(min=0, max=451, message="二维码链接长度不能超过 451 个字符")
	public String getEwmlinks() {
		return ewmlinks;
	}

	public void setEwmlinks(String ewmlinks) {
		this.ewmlinks = ewmlinks;
	}
	
	@Length(min=0, max=451, message="好评率长度不能超过 451 个字符")
	public String getHpl() {
		return hpl;
	}

	public void setHpl(String hpl) {
		this.hpl = hpl;
	}
	
	@Length(min=0, max=4, message="是否积分抵扣长度不能超过 4 个字符")
	public String getIsdikou() {
		return isdikou;
	}

	public void setIsdikou(String isdikou) {
		this.isdikou = isdikou;
	}
	
	public Long getNeedsource() {
		return needsource;
	}

	public void setNeedsource(Long needsource) {
		this.needsource = needsource;
	}
	
	@Length(min=0, max=4, message="是否秒杀长度不能超过 4 个字符")
	public String getIsmiaosha() {
		return ismiaosha;
	}

	public void setIsmiaosha(String ismiaosha) {
		this.ismiaosha = ismiaosha;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getSatrtms() {
		return satrtms;
	}

	public void setSatrtms(Date satrtms) {
		this.satrtms = satrtms;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getEndms() {
		return endms;
	}

	public void setEndms(Date endms) {
		this.endms = endms;
	}
	
	public Double getMsmoney() {
		return msmoney;
	}

	public void setMsmoney(Double msmoney) {
		this.msmoney = msmoney;
	}
	
	@Length(min=0, max=45, message="排序长度不能超过 45 个字符")
	public String getShowindex() {
		return showindex;
	}

	public void setShowindex(String showindex) {
		this.showindex = showindex;
	}
	
	@Length(min=0, max=451, message="申明长度不能超过 451 个字符")
	public String getShenming() {
		return shenming;
	}

	public void setShenming(String shenming) {
		this.shenming = shenming;
	}
	
	@Length(min=0, max=451, message="codes长度不能超过 451 个字符")
	public String getCodes() {
		return codes;
	}

	public void setCodes(String codes) {
		this.codes = codes;
	}
	
	@Length(min=0, max=45, message="生产批号长度不能超过 45 个字符")
	public String getScph() {
		return scph;
	}

	public void setScph(String scph) {
		this.scph = scph;
	}
	
	@Length(min=0, max=45, message="执行标准长度不能超过 45 个字符")
	public String getZxbz() {
		return zxbz;
	}

	public void setZxbz(String zxbz) {
		this.zxbz = zxbz;
	}
	
	@Length(min=0, max=45, message="企业代码长度不能超过 45 个字符")
	public String getQydm() {
		return qydm;
	}

	public void setQydm(String qydm) {
		this.qydm = qydm;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getCcrq() {
		return ccrq;
	}

	public void setCcrq(Date ccrq) {
		this.ccrq = ccrq;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getYxq() {
		return yxq;
	}

	public void setYxq(Date yxq) {
		this.yxq = yxq;
	}
	
	@Length(min=0, max=45, message="粘度级别长度不能超过 45 个字符")
	public String getNdjb() {
		return ndjb;
	}

	public void setNdjb(String ndjb) {
		this.ndjb = ndjb;
	}
	
	@Length(min=0, max=45, message="商家编号长度不能超过 45 个字符")
	public String getBussId() {
		return bussId;
	}

	public void setBussId(String bussId) {
		this.bussId = bussId;
	}
	
}