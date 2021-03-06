/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.tab.entity.TabOrderGwc;

/**
 * tab_order_gwcDAO接口
 * @author 高峰
 * @version 2021-02-16
 */
@MyBatisDao
public interface TabOrderGwcDao extends CrudDao<TabOrderGwc> {

	Long getUserGwcCount(TabOrderGwc arg0);

	void updateGwcChecks(TabOrderGwc tabOrderGwc);
	
}