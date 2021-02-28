/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.tab.entity.TabAqdWaringLog;
import com.jeesite.modules.tab.dao.TabAqdWaringLogDao;

/**
 * 报警日志Service
 * @author 高峰
 * @version 2020-09-30
 */
@Service
@Transactional(readOnly=true)
public class TabAqdWaringLogService extends CrudService<TabAqdWaringLogDao, TabAqdWaringLog> {
	
	/**
	 * 获取单条数据
	 * @param tabAqdWaringLog
	 * @return
	 */
	@Override
	public TabAqdWaringLog get(TabAqdWaringLog tabAqdWaringLog) {
		return super.get(tabAqdWaringLog);
	}
	
	/**
	 * 查询分页数据
	 * @param tabAqdWaringLog 查询条件
	 * @param tabAqdWaringLog.page 分页对象
	 * @return
	 */
	@Override
	public Page<TabAqdWaringLog> findPage(TabAqdWaringLog tabAqdWaringLog) {
		return super.findPage(tabAqdWaringLog);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param tabAqdWaringLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TabAqdWaringLog tabAqdWaringLog) {
		super.save(tabAqdWaringLog);
	}
	
	/**
	 * 更新状态
	 * @param tabAqdWaringLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TabAqdWaringLog tabAqdWaringLog) {
		super.updateStatus(tabAqdWaringLog);
	}
	
	/**
	 * 删除数据
	 * @param tabAqdWaringLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TabAqdWaringLog tabAqdWaringLog) {
		super.delete(tabAqdWaringLog);
	}
	
}