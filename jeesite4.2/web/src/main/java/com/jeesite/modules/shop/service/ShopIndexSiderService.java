/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.shop.entity.ShopIndexSider;
import com.jeesite.modules.shop.dao.ShopIndexSiderDao;

/**
 * shop_index_siderService
 * @author 高峰
 * @version 2021-02-17
 */
@Service
@Transactional(readOnly=true)
public class ShopIndexSiderService extends CrudService<ShopIndexSiderDao, ShopIndexSider> {
	
	/**
	 * 获取单条数据
	 * @param shopIndexSider
	 * @return
	 */
	@Override
	public ShopIndexSider get(ShopIndexSider shopIndexSider) {
		return super.get(shopIndexSider);
	}
	
	/**
	 * 查询分页数据
	 * @param shopIndexSider 查询条件
	 * @param shopIndexSider.page 分页对象
	 * @return
	 */
	@Override
	public Page<ShopIndexSider> findPage(ShopIndexSider shopIndexSider) {
		return super.findPage(shopIndexSider);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param shopIndexSider
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ShopIndexSider shopIndexSider) {
		super.save(shopIndexSider);
	}
	
	/**
	 * 更新状态
	 * @param shopIndexSider
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ShopIndexSider shopIndexSider) {
		super.updateStatus(shopIndexSider);
	}
	
	/**
	 * 删除数据
	 * @param shopIndexSider
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ShopIndexSider shopIndexSider) {
		super.delete(shopIndexSider);
	}
	
}