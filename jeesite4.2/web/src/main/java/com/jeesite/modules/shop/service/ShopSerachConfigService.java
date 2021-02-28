/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.shop.entity.ShopSerachConfig;
import com.jeesite.modules.shop.dao.ShopSerachConfigDao;

/**
 * shop_serach_configService
 * @author 高峰
 * @version 2021-02-17
 */
@Service
@Transactional(readOnly=true)
public class ShopSerachConfigService extends CrudService<ShopSerachConfigDao, ShopSerachConfig> {
	
	/**
	 * 获取单条数据
	 * @param shopSerachConfig
	 * @return
	 */
	@Override
	public ShopSerachConfig get(ShopSerachConfig shopSerachConfig) {
		return super.get(shopSerachConfig);
	}
	
	/**
	 * 查询分页数据
	 * @param shopSerachConfig 查询条件
	 * @param shopSerachConfig.page 分页对象
	 * @return
	 */
	@Override
	public Page<ShopSerachConfig> findPage(ShopSerachConfig shopSerachConfig) {
		return super.findPage(shopSerachConfig);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param shopSerachConfig
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ShopSerachConfig shopSerachConfig) {
		super.save(shopSerachConfig);
	}
	
	/**
	 * 更新状态
	 * @param shopSerachConfig
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ShopSerachConfig shopSerachConfig) {
		super.updateStatus(shopSerachConfig);
	}
	
	/**
	 * 删除数据
	 * @param shopSerachConfig
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ShopSerachConfig shopSerachConfig) {
		super.delete(shopSerachConfig);
	}
	
}