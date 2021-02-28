/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.tab.entity.TabAppUser;
import com.jeesite.modules.tab.dao.TabAppUserDao;

/**
 * tab_app_userService
 * @author 高峰
 * @version 2020-09-28
 */
@Service
@Transactional(readOnly=true)
public class TabAppUserService extends CrudService<TabAppUserDao, TabAppUser> {
	
	/**
	 * 获取单条数据
	 * @param tabAppUser
	 * @return
	 */
	@Override
	public TabAppUser get(TabAppUser tabAppUser) {
		return super.get(tabAppUser);
	}
	
	/**
	 * 查询分页数据
	 * @param tabAppUser 查询条件
	 * @param tabAppUser.page 分页对象
	 * @return
	 */
	@Override
	public Page<TabAppUser> findPage(TabAppUser tabAppUser) {
		return super.findPage(tabAppUser);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param tabAppUser
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TabAppUser tabAppUser) {
		super.save(tabAppUser);
	}
	
	/**
	 * 更新状态
	 * @param tabAppUser
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TabAppUser tabAppUser) {
		super.updateStatus(tabAppUser);
	}
	
	/**
	 * 删除数据
	 * @param tabAppUser
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TabAppUser tabAppUser) {
		super.delete(tabAppUser);
	}
	
}