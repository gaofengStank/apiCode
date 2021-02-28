/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.tab.entity.TabAqdQingqiuLog;
import com.jeesite.modules.tab.dao.TabAqdQingqiuLogDao;

/**
 * 报警日志Service
 * @author 高峰
 * @version 2020-09-30
 */
@Service
@Transactional(readOnly=true)
public class TabAqdQingqiuLogService extends CrudService<TabAqdQingqiuLogDao, TabAqdQingqiuLog> {
	
	/**
	 * 获取单条数据
	 * @param tabAqdQingqiuLog
	 * @return
	 */
	@Override
	public TabAqdQingqiuLog get(TabAqdQingqiuLog tabAqdQingqiuLog) {
		return super.get(tabAqdQingqiuLog);
	}
	
	/**
	 * 查询分页数据
	 * @param tabAqdQingqiuLog 查询条件
	 * @param tabAqdQingqiuLog.page 分页对象
	 * @return
	 */
	@Override
	public Page<TabAqdQingqiuLog> findPage(TabAqdQingqiuLog tabAqdQingqiuLog) {
		return super.findPage(tabAqdQingqiuLog);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param tabAqdQingqiuLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TabAqdQingqiuLog tabAqdQingqiuLog) {
		super.save(tabAqdQingqiuLog);
	}
	
	/**
	 * 更新状态
	 * @param tabAqdQingqiuLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TabAqdQingqiuLog tabAqdQingqiuLog) {
		super.updateStatus(tabAqdQingqiuLog);
	}
	
	/**
	 * 删除数据
	 * @param tabAqdQingqiuLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TabAqdQingqiuLog tabAqdQingqiuLog) {
		super.delete(tabAqdQingqiuLog);
	}
	
}