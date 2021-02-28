/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.tab.entity.TabProduct;

/**
 * tab_productDAO接口
 * @author 高峰
 * @version 2020-12-24
 */
@MyBatisDao
public interface TabProductDao extends CrudDao<TabProduct> {
	
}