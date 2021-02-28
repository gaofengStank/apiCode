/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.tab.entity.TabOrderList;
import com.jeesite.modules.tab.dao.TabOrderListDao;

/**
 * tab_order_listService
 * @author 高峰
 * @version 2021-02-16
 */
@Service
@Transactional(readOnly=true)
public class TabOrderListService extends CrudService<TabOrderListDao, TabOrderList> {
	
	/**
	 * 获取单条数据
	 * @param tabOrderList
	 * @return
	 */
	@Override
	public TabOrderList get(TabOrderList tabOrderList) {
		return super.get(tabOrderList);
	}
	
	/**
	 * 查询分页数据
	 * @param tabOrderList 查询条件
	 * @param tabOrderList.page 分页对象
	 * @return
	 */
	@Override
	public Page<TabOrderList> findPage(TabOrderList tabOrderList) {
		return super.findPage(tabOrderList);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param tabOrderList
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TabOrderList tabOrderList) {
		super.save(tabOrderList);
	}
	
	/**
	 * 更新状态
	 * @param tabOrderList
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TabOrderList tabOrderList) {
		super.updateStatus(tabOrderList);
	}
	
	/**
	 * 删除数据
	 * @param tabOrderList
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TabOrderList tabOrderList) {
		super.delete(tabOrderList);
	}
	
}