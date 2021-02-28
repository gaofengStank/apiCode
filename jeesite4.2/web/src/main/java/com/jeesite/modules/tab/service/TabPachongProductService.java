/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.tab.entity.TabPachongProduct;
import com.jeesite.modules.tab.dao.TabPachongProductDao;

/**
 * tab_pachong_productService
 * @author 高峰
 * @version 2020-10-03
 */
@Service
@Transactional(readOnly=true)
public class TabPachongProductService extends CrudService<TabPachongProductDao, TabPachongProduct> {
	
	/**
	 * 获取单条数据
	 * @param tabPachongProduct
	 * @return
	 */
	@Override
	public TabPachongProduct get(TabPachongProduct tabPachongProduct) {
		return super.get(tabPachongProduct);
	}
	
	/**
	 * 查询分页数据
	 * @param tabPachongProduct 查询条件
	 * @param tabPachongProduct.page 分页对象
	 * @return
	 */
	@Override
	public Page<TabPachongProduct> findPage(TabPachongProduct tabPachongProduct) {
		return super.findPage(tabPachongProduct);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param tabPachongProduct
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TabPachongProduct tabPachongProduct) {
		super.save(tabPachongProduct);
	}
	
	/**
	 * 更新状态
	 * @param tabPachongProduct
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TabPachongProduct tabPachongProduct) {
		super.updateStatus(tabPachongProduct);
	}
	
	/**
	 * 删除数据
	 * @param tabPachongProduct
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TabPachongProduct tabPachongProduct) {
		super.delete(tabPachongProduct);
	}
	
}