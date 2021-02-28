/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.shop.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.shop.entity.ShopBbs;

/**
 * shop_bbsDAO接口
 * @author 高峰
 * @version 2021-02-17
 */
@MyBatisDao
public interface ShopBbsDao extends CrudDao<ShopBbs> {
	
}