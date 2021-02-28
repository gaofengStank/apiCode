/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.tab.entity.TabSysContact;
import com.jeesite.modules.tab.dao.TabSysContactDao;

/**
 * tab_sys_contactService
 * @author 高峰
 * @version 2021-02-26
 */
@Service
@Transactional(readOnly=true)
public class TabSysContactService extends CrudService<TabSysContactDao, TabSysContact> {
	
	/**
	 * 获取单条数据
	 * @param tabSysContact
	 * @return
	 */
	@Override
	public TabSysContact get(TabSysContact tabSysContact) {
		return super.get(tabSysContact);
	}
	
	/**
	 * 查询分页数据
	 * @param tabSysContact 查询条件
	 * @param tabSysContact.page 分页对象
	 * @return
	 */
	@Override
	public Page<TabSysContact> findPage(TabSysContact tabSysContact) {
		return super.findPage(tabSysContact);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param tabSysContact
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TabSysContact tabSysContact) {
		super.save(tabSysContact);
	}
	
	/**
	 * 更新状态
	 * @param tabSysContact
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TabSysContact tabSysContact) {
		super.updateStatus(tabSysContact);
	}
	
	/**
	 * 删除数据
	 * @param tabSysContact
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TabSysContact tabSysContact) {
		super.delete(tabSysContact);
	}
	
}