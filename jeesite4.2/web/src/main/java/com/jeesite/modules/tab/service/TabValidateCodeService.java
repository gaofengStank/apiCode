/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.tab.entity.TabValidateCode;
import com.jeesite.modules.tab.dao.TabValidateCodeDao;

/**
 * tab_validate_codeService
 * @author 高峰
 * @version 2021-02-20
 */
@Service
@Transactional(readOnly=true)
public class TabValidateCodeService extends CrudService<TabValidateCodeDao, TabValidateCode> {
	
	/**
	 * 获取单条数据
	 * @param tabValidateCode
	 * @return
	 */
	@Override
	public TabValidateCode get(TabValidateCode tabValidateCode) {
		return super.get(tabValidateCode);
	}
	
	/**
	 * 查询分页数据
	 * @param tabValidateCode 查询条件
	 * @param tabValidateCode.page 分页对象
	 * @return
	 */
	@Override
	public Page<TabValidateCode> findPage(TabValidateCode tabValidateCode) {
		return super.findPage(tabValidateCode);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param tabValidateCode
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TabValidateCode tabValidateCode) {
		super.save(tabValidateCode);
	}
	
	/**
	 * 更新状态
	 * @param tabValidateCode
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TabValidateCode tabValidateCode) {
		super.updateStatus(tabValidateCode);
	}
	
	/**
	 * 删除数据
	 * @param tabValidateCode
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TabValidateCode tabValidateCode) {
		super.delete(tabValidateCode);
	}

	public List<TabValidateCode> checkValidCode(Map<String, String> parame) {
		return tabValidateCodeDao.checkValidCode(parame);
	}
	@Autowired
	private TabValidateCodeDao tabValidateCodeDao;
}