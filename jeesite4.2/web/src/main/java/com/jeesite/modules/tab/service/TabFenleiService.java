/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.tab.entity.TabFenlei;
import com.jeesite.modules.tab.dao.TabFenleiDao;

/**
 * tab_fenleiService
 * @author 高峰
 * @version 2020-12-24
 */
@Service
@Transactional(readOnly=true)
public class TabFenleiService extends CrudService<TabFenleiDao, TabFenlei> {
	
	/**
	 * 获取单条数据
	 * @param tabFenlei
	 * @return
	 */
	@Override
	public TabFenlei get(TabFenlei tabFenlei) {
		return super.get(tabFenlei);
	}
	
	/**
	 * 查询分页数据
	 * @param tabFenlei 查询条件
	 * @param tabFenlei.page 分页对象
	 * @return
	 */
	@Override
	public Page<TabFenlei> findPage(TabFenlei tabFenlei) {
		return super.findPage(tabFenlei);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param tabFenlei
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TabFenlei tabFenlei) {
		super.save(tabFenlei);
	}
	
	/**
	 * 更新状态
	 * @param tabFenlei
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TabFenlei tabFenlei) {
		super.updateStatus(tabFenlei);
	}
	
	/**
	 * 删除数据
	 * @param tabFenlei
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TabFenlei tabFenlei) {
		super.delete(tabFenlei);
	}
	
}