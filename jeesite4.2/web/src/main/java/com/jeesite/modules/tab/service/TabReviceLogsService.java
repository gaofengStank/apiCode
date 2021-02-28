/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.tab.entity.TabReviceLogs;
import com.jeesite.modules.tab.dao.TabReviceLogsDao;

/**
 * tab_revice_logsService
 * @author 高峰
 * @version 2020-09-30
 */
@Service
@Transactional(readOnly=true)
public class TabReviceLogsService extends CrudService<TabReviceLogsDao, TabReviceLogs> {
	
	/**
	 * 获取单条数据
	 * @param tabReviceLogs
	 * @return
	 */
	@Override
	public TabReviceLogs get(TabReviceLogs tabReviceLogs) {
		return super.get(tabReviceLogs);
	}
	
	/**
	 * 查询分页数据
	 * @param tabReviceLogs 查询条件
	 * @param tabReviceLogs.page 分页对象
	 * @return
	 */
	@Override
	public Page<TabReviceLogs> findPage(TabReviceLogs tabReviceLogs) {
		return super.findPage(tabReviceLogs);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param tabReviceLogs
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TabReviceLogs tabReviceLogs) {
		super.save(tabReviceLogs);
	}
	
	/**
	 * 更新状态
	 * @param tabReviceLogs
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TabReviceLogs tabReviceLogs) {
		super.updateStatus(tabReviceLogs);
	}
	
	/**
	 * 删除数据
	 * @param tabReviceLogs
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TabReviceLogs tabReviceLogs) {
		super.delete(tabReviceLogs);
	}
	
}