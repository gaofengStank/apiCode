/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.tab.entity.TabDevices;
import com.jeesite.modules.tab.dao.TabDevicesDao;

/**
 * 工人和锁扣配对Service
 * @author 高峰
 * @version 2020-09-28
 */
@Service
@Transactional(readOnly=true)
public class TabDevicesService extends CrudService<TabDevicesDao, TabDevices> {
	
	/**
	 * 获取单条数据
	 * @param tabDevices
	 * @return
	 */
	@Override
	public TabDevices get(TabDevices tabDevices) {
		return super.get(tabDevices);
	}
	
	/**
	 * 查询分页数据
	 * @param tabDevices 查询条件
	 * @param tabDevices.page 分页对象
	 * @return
	 */
	@Override
	public Page<TabDevices> findPage(TabDevices tabDevices) {
		return super.findPage(tabDevices);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param tabDevices
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TabDevices tabDevices) {
		super.save(tabDevices);
	}
	
	/**
	 * 更新状态
	 * @param tabDevices
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TabDevices tabDevices) {
		super.updateStatus(tabDevices);
	}
	
	/**
	 * 删除数据
	 * @param tabDevices
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TabDevices tabDevices) {
		super.delete(tabDevices);
	}
	
}