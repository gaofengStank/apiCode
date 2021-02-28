/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.shop.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.shop.entity.ShopGoodViewLog;

/**
 * shop_good_view_logDAO接口
 * @author 商品浏览记录
 * @version 2021-02-16
 */
@MyBatisDao
public interface ShopGoodViewLogDao extends CrudDao<ShopGoodViewLog> {
	
}