/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.tab.entity.TabAnquanyuan;
import com.jeesite.modules.tab.dao.TabAnquanyuanDao;

/**
 * tab_anquanyuanService
 * @author 高峰
 * @version 2020-09-30
 */
@Service
@Transactional(readOnly=true)
public class TabAnquanyuanService extends CrudService<TabAnquanyuanDao, TabAnquanyuan> {
	
	/**
	 * 获取单条数据
	 * @param tabAnquanyuan
	 * @return
	 */
	@Override
	public TabAnquanyuan get(TabAnquanyuan tabAnquanyuan) {
		return super.get(tabAnquanyuan);
	}
	
	/**
	 * 查询分页数据
	 * @param tabAnquanyuan 查询条件
	 * @param tabAnquanyuan.page 分页对象
	 * @return
	 */
	@Override
	public Page<TabAnquanyuan> findPage(TabAnquanyuan tabAnquanyuan) {
		return super.findPage(tabAnquanyuan);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param tabAnquanyuan
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TabAnquanyuan tabAnquanyuan) {
		super.save(tabAnquanyuan);
	}
	
	/**
	 * 更新状态
	 * @param tabAnquanyuan
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TabAnquanyuan tabAnquanyuan) {
		super.updateStatus(tabAnquanyuan);
	}
	
	/**
	 * 删除数据
	 * @param tabAnquanyuan
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TabAnquanyuan tabAnquanyuan) {
		super.delete(tabAnquanyuan);
	}
	
}