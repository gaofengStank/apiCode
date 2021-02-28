/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.tab.entity.TabPachongData;
import com.jeesite.modules.tab.dao.TabPachongDataDao;

/**
 * tab_pachong_dataService
 * @author 高峰
 * @version 2020-10-02
 */
@Service
@Transactional(readOnly=true)
public class TabPachongDataService extends CrudService<TabPachongDataDao, TabPachongData> {
	
	/**
	 * 获取单条数据
	 * @param tabPachongData
	 * @return
	 */
	@Override
	public TabPachongData get(TabPachongData tabPachongData) {
		return super.get(tabPachongData);
	}
	
	/**
	 * 查询分页数据
	 * @param tabPachongData 查询条件
	 * @param tabPachongData.page 分页对象
	 * @return
	 */
	@Override
	public Page<TabPachongData> findPage(TabPachongData tabPachongData) {
		return super.findPage(tabPachongData);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param tabPachongData
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TabPachongData tabPachongData) {
		super.save(tabPachongData);
	}
	
	/**
	 * 更新状态
	 * @param tabPachongData
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TabPachongData tabPachongData) {
		super.updateStatus(tabPachongData);
	}
	
	/**
	 * 删除数据
	 * @param tabPachongData
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TabPachongData tabPachongData) {
		super.delete(tabPachongData);
	}
	
}