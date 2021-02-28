/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.shop.entity.ShopGoodFenlei;
import com.jeesite.modules.shop.dao.ShopGoodFenleiDao;

/**
 * shop_good_fenleiService
 * @author 高峰
 * @version 2021-02-17
 */
@Service
@Transactional(readOnly=true)
public class ShopGoodFenleiService extends CrudService<ShopGoodFenleiDao, ShopGoodFenlei> {
	
	/**
	 * 获取单条数据
	 * @param shopGoodFenlei
	 * @return
	 */
	@Override
	public ShopGoodFenlei get(ShopGoodFenlei shopGoodFenlei) {
		return super.get(shopGoodFenlei);
	}
	
	/**
	 * 查询分页数据
	 * @param shopGoodFenlei 查询条件
	 * @param shopGoodFenlei.page 分页对象
	 * @return
	 */
	@Override
	public Page<ShopGoodFenlei> findPage(ShopGoodFenlei shopGoodFenlei) {
		return super.findPage(shopGoodFenlei);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param shopGoodFenlei
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ShopGoodFenlei shopGoodFenlei) {
		super.save(shopGoodFenlei);
	}
	
	/**
	 * 更新状态
	 * @param shopGoodFenlei
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ShopGoodFenlei shopGoodFenlei) {
		super.updateStatus(shopGoodFenlei);
	}
	
	/**
	 * 删除数据
	 * @param shopGoodFenlei
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ShopGoodFenlei shopGoodFenlei) {
		super.delete(shopGoodFenlei);
	}

	public List<ShopGoodFenlei> listHomeDefaultData() {
		ShopGoodFenlei goodFenlei    =  new ShopGoodFenlei();
		goodFenlei.setParentRowid("1");
		
 		return super.findList(goodFenlei);
	}
	
}