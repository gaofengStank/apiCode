/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.tab.entity.TabAqdWaringLog;

/**
 * 报警日志DAO接口
 * @author 高峰
 * @version 2020-09-30
 */
@MyBatisDao
public interface TabAqdWaringLogDao extends CrudDao<TabAqdWaringLog> {
	
}