/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.tab.entity.TabYjfk;
import com.jeesite.modules.tab.dao.TabYjfkDao;

/**
 * tab_yjfkService
 * @author 高峰
 * @version 2021-02-27
 */
@Service
@Transactional(readOnly=true)
public class TabYjfkService extends CrudService<TabYjfkDao, TabYjfk> {
	
	/**
	 * 获取单条数据
	 * @param tabYjfk
	 * @return
	 */
	@Override
	public TabYjfk get(TabYjfk tabYjfk) {
		return super.get(tabYjfk);
	}
	
	/**
	 * 查询分页数据
	 * @param tabYjfk 查询条件
	 * @param tabYjfk.page 分页对象
	 * @return
	 */
	@Override
	public Page<TabYjfk> findPage(TabYjfk tabYjfk) {
		return super.findPage(tabYjfk);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param tabYjfk
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TabYjfk tabYjfk) {
		super.save(tabYjfk);
	}
	
	/**
	 * 更新状态
	 * @param tabYjfk
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TabYjfk tabYjfk) {
		super.updateStatus(tabYjfk);
	}
	
	/**
	 * 删除数据
	 * @param tabYjfk
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TabYjfk tabYjfk) {
		super.delete(tabYjfk);
	}
	
}