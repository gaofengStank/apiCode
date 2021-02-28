/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.shop.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.shop.entity.ShopOrder;

/**
 * shop_orderDAO接口
 * @author 高峰
 * @version 2021-02-16
 */
@MyBatisDao
public interface ShopOrderDao extends CrudDao<ShopOrder> {
	
}