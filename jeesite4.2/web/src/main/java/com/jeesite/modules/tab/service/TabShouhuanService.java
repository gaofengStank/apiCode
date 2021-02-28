/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.tab.entity.TabShouhuan;
import com.jeesite.modules.tab.dao.TabShouhuanDao;

/**
 * tab_shouhuanService
 * @author 高峰
 * @version 2020-09-26
 */
@Service
@Transactional(readOnly=true)
public class TabShouhuanService extends CrudService<TabShouhuanDao, TabShouhuan> {
	
	/**
	 * 获取单条数据
	 * @param tabShouhuan
	 * @return
	 */
	@Override
	public TabShouhuan get(TabShouhuan tabShouhuan) {
		return super.get(tabShouhuan);
	}
	
	/**
	 * 查询分页数据
	 * @param tabShouhuan 查询条件
	 * @param tabShouhuan.page 分页对象
	 * @return
	 */
	@Override
	public Page<TabShouhuan> findPage(TabShouhuan tabShouhuan) {
		return super.findPage(tabShouhuan);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param tabShouhuan
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TabShouhuan tabShouhuan) {
		super.save(tabShouhuan);
	}
	
	/**
	 * 更新状态
	 * @param tabShouhuan
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TabShouhuan tabShouhuan) {
		super.updateStatus(tabShouhuan);
	}
	
	/**
	 * 删除数据
	 * @param tabShouhuan
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TabShouhuan tabShouhuan) {
		super.delete(tabShouhuan);
	}
	
}