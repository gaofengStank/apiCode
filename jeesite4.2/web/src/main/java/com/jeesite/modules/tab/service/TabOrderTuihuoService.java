/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.tab.entity.TabOrderTuihuo;
import com.jeesite.modules.tab.dao.TabOrderTuihuoDao;

/**
 * tab_order_tuihuoService
 * @author 高峰
 * @version 2021-02-16
 */
@Service
@Transactional(readOnly=true)
public class TabOrderTuihuoService extends CrudService<TabOrderTuihuoDao, TabOrderTuihuo> {
	
	/**
	 * 获取单条数据
	 * @param tabOrderTuihuo
	 * @return
	 */
	@Override
	public TabOrderTuihuo get(TabOrderTuihuo tabOrderTuihuo) {
		return super.get(tabOrderTuihuo);
	}
	
	/**
	 * 查询分页数据
	 * @param tabOrderTuihuo 查询条件
	 * @param tabOrderTuihuo.page 分页对象
	 * @return
	 */
	@Override
	public Page<TabOrderTuihuo> findPage(TabOrderTuihuo tabOrderTuihuo) {
		return super.findPage(tabOrderTuihuo);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param tabOrderTuihuo
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TabOrderTuihuo tabOrderTuihuo) {
		super.save(tabOrderTuihuo);
	}
	
	/**
	 * 更新状态
	 * @param tabOrderTuihuo
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TabOrderTuihuo tabOrderTuihuo) {
		super.updateStatus(tabOrderTuihuo);
	}
	
	/**
	 * 删除数据
	 * @param tabOrderTuihuo
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TabOrderTuihuo tabOrderTuihuo) {
		super.delete(tabOrderTuihuo);
	}
	
}