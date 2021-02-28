/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.tab.entity.TabOrderList;

/**
 * tab_order_listDAO接口
 * @author 高峰
 * @version 2021-02-16
 */
@MyBatisDao
public interface TabOrderListDao extends CrudDao<TabOrderList> {
	
}