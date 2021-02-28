/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.tab.entity.TabAqdBaoxiuLog;
import com.jeesite.modules.tab.dao.TabAqdBaoxiuLogDao;

/**
 * 报警日志Service
 * @author 高峰
 * @version 2020-09-30
 */
@Service
@Transactional(readOnly=true)
public class TabAqdBaoxiuLogService extends CrudService<TabAqdBaoxiuLogDao, TabAqdBaoxiuLog> {
	
	/**
	 * 获取单条数据
	 * @param tabAqdBaoxiuLog
	 * @return
	 */
	@Override
	public TabAqdBaoxiuLog get(TabAqdBaoxiuLog tabAqdBaoxiuLog) {
		return super.get(tabAqdBaoxiuLog);
	}
	
	/**
	 * 查询分页数据
	 * @param tabAqdBaoxiuLog 查询条件
	 * @param tabAqdBaoxiuLog.page 分页对象
	 * @return
	 */
	@Override
	public Page<TabAqdBaoxiuLog> findPage(TabAqdBaoxiuLog tabAqdBaoxiuLog) {
		return super.findPage(tabAqdBaoxiuLog);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param tabAqdBaoxiuLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TabAqdBaoxiuLog tabAqdBaoxiuLog) {
		super.save(tabAqdBaoxiuLog);
	}
	
	/**
	 * 更新状态
	 * @param tabAqdBaoxiuLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TabAqdBaoxiuLog tabAqdBaoxiuLog) {
		super.updateStatus(tabAqdBaoxiuLog);
	}
	
	/**
	 * 删除数据
	 * @param tabAqdBaoxiuLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TabAqdBaoxiuLog tabAqdBaoxiuLog) {
		super.delete(tabAqdBaoxiuLog);
	}
	
}