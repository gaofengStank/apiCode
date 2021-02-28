/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.dao;

import java.util.List;
import java.util.Map;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.tab.entity.TabValidateCode;

/**
 * tab_validate_codeDAO接口
 * @author 高峰
 * @version 2021-02-20
 */
@MyBatisDao
public interface TabValidateCodeDao extends CrudDao<TabValidateCode> {

	List<TabValidateCode> checkValidCode(Map<String, String> parame);
	
}