/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.shop.entity.ShopBusinessCollect;
import com.jeesite.modules.shop.dao.ShopBusinessCollectDao;

/**
 * shop_business_collectService
 * @author 高峰
 * @version 2021-02-23
 */
@Service
@Transactional(readOnly=true)
public class ShopBusinessCollectService extends CrudService<ShopBusinessCollectDao, ShopBusinessCollect> {
	
	/**
	 * 获取单条数据
	 * @param shopBusinessCollect
	 * @return
	 */
	@Override
	public ShopBusinessCollect get(ShopBusinessCollect shopBusinessCollect) {
		return super.get(shopBusinessCollect);
	}
	
	/**
	 * 查询分页数据
	 * @param shopBusinessCollect 查询条件
	 * @param shopBusinessCollect.page 分页对象
	 * @return
	 */
	@Override
	public Page<ShopBusinessCollect> findPage(ShopBusinessCollect shopBusinessCollect) {
		return super.findPage(shopBusinessCollect);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param shopBusinessCollect
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ShopBusinessCollect shopBusinessCollect) {
		super.save(shopBusinessCollect);
	}
	
	/**
	 * 更新状态
	 * @param shopBusinessCollect
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ShopBusinessCollect shopBusinessCollect) {
		super.updateStatus(shopBusinessCollect);
	}
	
	/**
	 * 删除数据
	 * @param shopBusinessCollect
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ShopBusinessCollect shopBusinessCollect) {
		super.delete(shopBusinessCollect);
	}
	
}