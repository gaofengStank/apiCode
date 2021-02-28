/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.shop.entity.ShopBusiness;
import com.jeesite.modules.shop.dao.ShopBusinessDao;

/**
 * shop_businessService
 * @author 高峰
 * @version 2021-02-19
 */
@Service
@Transactional(readOnly=true)
public class ShopBusinessService extends CrudService<ShopBusinessDao, ShopBusiness> {
	
	/**
	 * 获取单条数据
	 * @param shopBusiness
	 * @return
	 */
	@Override
	public ShopBusiness get(ShopBusiness shopBusiness) {
		return super.get(shopBusiness);
	}
	
	/**
	 * 查询分页数据
	 * @param shopBusiness 查询条件
	 * @param shopBusiness.page 分页对象
	 * @return
	 */
	@Override
	public Page<ShopBusiness> findPage(ShopBusiness shopBusiness) {
		return super.findPage(shopBusiness);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param shopBusiness
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ShopBusiness shopBusiness) {
		super.save(shopBusiness);
	}
	
	/**
	 * 更新状态
	 * @param shopBusiness
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ShopBusiness shopBusiness) {
		super.updateStatus(shopBusiness);
	}
	
	/**
	 * 删除数据
	 * @param shopBusiness
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ShopBusiness shopBusiness) {
		super.delete(shopBusiness);
	}
	
}