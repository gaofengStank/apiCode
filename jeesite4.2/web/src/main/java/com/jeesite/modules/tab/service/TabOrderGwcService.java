/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.tab.entity.TabOrderGwc;
import com.jeesite.modules.tab.dao.TabOrderGwcDao;

/**
 * tab_order_gwcService
 * @author 高峰
 * @version 2021-02-16
 */
@Service
@Transactional(readOnly=true)
public class TabOrderGwcService extends CrudService<TabOrderGwcDao, TabOrderGwc> {
	
	/**
	 * 获取单条数据
	 * @param tabOrderGwc
	 * @return
	 */
	@Override
	public TabOrderGwc get(TabOrderGwc tabOrderGwc) {
		return super.get(tabOrderGwc);
	}
	
	/**
	 * 查询分页数据
	 * @param tabOrderGwc 查询条件
	 * @param tabOrderGwc.page 分页对象
	 * @return
	 */
	@Override
	public Page<TabOrderGwc> findPage(TabOrderGwc tabOrderGwc) {
		return super.findPage(tabOrderGwc);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param tabOrderGwc
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TabOrderGwc tabOrderGwc) {
		super.save(tabOrderGwc);
	}
	
	/**
	 * 更新状态
	 * @param tabOrderGwc
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TabOrderGwc tabOrderGwc) {
		super.updateStatus(tabOrderGwc);
	}
	
	/**
	 * 删除数据
	 * @param tabOrderGwc
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TabOrderGwc tabOrderGwc) {
		super.delete(tabOrderGwc);
	}

	public Long getUserGwcCount(TabOrderGwc arg0) {
		return tabOrderGwcDao.getUserGwcCount(arg0);
	}
	@Autowired
	private  TabOrderGwcDao tabOrderGwcDao ;
	
	@Transactional(readOnly=false)
	public void updateGwcChecks(TabOrderGwc tabOrderGwc) {
		tabOrderGwcDao.updateGwcChecks(tabOrderGwc);
	}
	@Transactional(readOnly=false)
	public void delSelectGwc(HttpServletRequest request) {
		TabOrderGwc arg0 = new TabOrderGwc();
		arg0.setUserid(request.getParameter("token"));
		arg0.setIscheck("2");
	List<TabOrderGwc> tabOrderGwcs =	tabOrderGwcDao.findList(arg0 );
	for (TabOrderGwc tabOrderGwc : tabOrderGwcs) {
		tabOrderGwcDao.delete(tabOrderGwc);
	}
	}
}