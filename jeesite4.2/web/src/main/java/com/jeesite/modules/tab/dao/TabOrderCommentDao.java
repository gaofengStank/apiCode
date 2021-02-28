/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.tab.entity.TabOrderComment;

/**
 * tab_order_commentDAO接口
 * @author 高峰
 * @version 2021-02-19
 */
@MyBatisDao
public interface TabOrderCommentDao extends CrudDao<TabOrderComment> {
	
}