/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.tab.entity.TabWeilan;
import com.jeesite.modules.tab.dao.TabWeilanDao;

/**
 * tab_weilanService
 * @author 高峰
 * @version 2020-09-26
 */
@Service
@Transactional(readOnly=true)
public class TabWeilanService extends CrudService<TabWeilanDao, TabWeilan> {
	
	/**
	 * 获取单条数据
	 * @param tabWeilan
	 * @return
	 */
	@Override
	public TabWeilan get(TabWeilan tabWeilan) {
		return super.get(tabWeilan);
	}
	
	/**
	 * 查询分页数据
	 * @param tabWeilan 查询条件
	 * @param tabWeilan.page 分页对象
	 * @return
	 */
	@Override
	public Page<TabWeilan> findPage(TabWeilan tabWeilan) {
		return super.findPage(tabWeilan);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param tabWeilan
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TabWeilan tabWeilan) {
		super.save(tabWeilan);
	}
	
	/**
	 * 更新状态
	 * @param tabWeilan
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TabWeilan tabWeilan) {
		super.updateStatus(tabWeilan);
	}
	
	/**
	 * 删除数据
	 * @param tabWeilan
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TabWeilan tabWeilan) {
		super.delete(tabWeilan);
	}
	
}