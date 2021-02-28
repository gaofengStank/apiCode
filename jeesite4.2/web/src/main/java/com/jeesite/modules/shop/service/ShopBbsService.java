/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.shop.entity.ShopBbs;
import com.jeesite.modules.shop.dao.ShopBbsDao;

/**
 * shop_bbsService
 * @author 高峰
 * @version 2021-02-17
 */
@Service
@Transactional(readOnly=true)
public class ShopBbsService extends CrudService<ShopBbsDao, ShopBbs> {
	
	/**
	 * 获取单条数据
	 * @param shopBbs
	 * @return
	 */
	@Override
	public ShopBbs get(ShopBbs shopBbs) {
		return super.get(shopBbs);
	}
	
	/**
	 * 查询分页数据
	 * @param shopBbs 查询条件
	 * @param shopBbs.page 分页对象
	 * @return
	 */
	@Override
	public Page<ShopBbs> findPage(ShopBbs shopBbs) {
		return super.findPage(shopBbs);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param shopBbs
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ShopBbs shopBbs) {
		super.save(shopBbs);
	}
	
	/**
	 * 更新状态
	 * @param shopBbs
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ShopBbs shopBbs) {
		super.updateStatus(shopBbs);
	}
	
	/**
	 * 删除数据
	 * @param shopBbs
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ShopBbs shopBbs) {
		super.delete(shopBbs);
	}
	
}