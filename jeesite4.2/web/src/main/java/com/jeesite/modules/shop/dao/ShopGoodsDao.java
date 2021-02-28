/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.shop.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.shop.entity.ShopGoods;

/**
 * 商品信息表DAO接口
 * @author 高峰
 * @version 2021-02-16
 */
@MyBatisDao
public interface ShopGoodsDao extends CrudDao<ShopGoods> {

	List<ShopGoods> listMySc(HttpServletRequest request);
	
}