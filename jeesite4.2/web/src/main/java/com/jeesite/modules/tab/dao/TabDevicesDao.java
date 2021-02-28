/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.tab.entity.TabDevices;

/**
 * 工人和锁扣配对DAO接口
 * @author 高峰
 * @version 2020-09-28
 */
@MyBatisDao
public interface TabDevicesDao extends CrudDao<TabDevices> {
	
}