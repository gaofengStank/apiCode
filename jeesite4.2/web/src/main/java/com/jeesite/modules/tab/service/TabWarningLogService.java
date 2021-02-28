/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.tab.entity.TabWarningLog;
import com.jeesite.modules.tab.dao.TabWarningLogDao;

/**
 * tab_warning_logService
 * @author 高峰
 * @version 2020-09-27
 */
@Service
@Transactional(readOnly=true)
public class TabWarningLogService extends CrudService<TabWarningLogDao, TabWarningLog> {
	
	/**
	 * 获取单条数据
	 * @param tabWarningLog
	 * @return
	 */
	@Override
	public TabWarningLog get(TabWarningLog tabWarningLog) {
		return super.get(tabWarningLog);
	}
	
	/**
	 * 查询分页数据
	 * @param tabWarningLog 查询条件
	 * @param tabWarningLog.page 分页对象
	 * @return
	 */
	@Override
	public Page<TabWarningLog> findPage(TabWarningLog tabWarningLog) {
		return super.findPage(tabWarningLog);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param tabWarningLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TabWarningLog tabWarningLog) {
		super.save(tabWarningLog);
	}
	
	/**
	 * 更新状态
	 * @param tabWarningLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TabWarningLog tabWarningLog) {
		super.updateStatus(tabWarningLog);
	}
	
	/**
	 * 删除数据
	 * @param tabWarningLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TabWarningLog tabWarningLog) {
		super.delete(tabWarningLog);
	}
	
}