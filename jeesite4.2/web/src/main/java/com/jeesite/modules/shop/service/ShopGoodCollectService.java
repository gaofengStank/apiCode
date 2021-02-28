/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.shop.entity.ShopGoodCollect;
import com.jeesite.modules.shop.dao.ShopGoodCollectDao;

/**
 * shop_good_collectService
 * @author 高峰
 * @version 2021-02-16
 */
@Service
@Transactional(readOnly=true)
public class ShopGoodCollectService extends CrudService<ShopGoodCollectDao, ShopGoodCollect> {
	
	/**
	 * 获取单条数据
	 * @param shopGoodCollect
	 * @return
	 */
	@Override
	public ShopGoodCollect get(ShopGoodCollect shopGoodCollect) {
		return super.get(shopGoodCollect);
	}
	
	/**
	 * 查询分页数据
	 * @param shopGoodCollect 查询条件
	 * @param shopGoodCollect.page 分页对象
	 * @return
	 */
	@Override
	public Page<ShopGoodCollect> findPage(ShopGoodCollect shopGoodCollect) {
		return super.findPage(shopGoodCollect);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param shopGoodCollect
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ShopGoodCollect shopGoodCollect) {
		super.save(shopGoodCollect);
	}
	
	/**
	 * 更新状态
	 * @param shopGoodCollect
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ShopGoodCollect shopGoodCollect) {
		super.updateStatus(shopGoodCollect);
	}
	
	/**
	 * 删除数据
	 * @param shopGoodCollect
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ShopGoodCollect shopGoodCollect) {
		super.delete(shopGoodCollect);
	}
	
}