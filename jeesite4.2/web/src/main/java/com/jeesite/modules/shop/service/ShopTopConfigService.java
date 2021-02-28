/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.shop.entity.ShopTopConfig;
import com.jeesite.modules.shop.dao.ShopTopConfigDao;

/**
 * shop_top_configService
 * @author 高峰
 * @version 2021-02-17
 */
@Service
@Transactional(readOnly=true)
public class ShopTopConfigService extends CrudService<ShopTopConfigDao, ShopTopConfig> {
	
	/**
	 * 获取单条数据
	 * @param shopTopConfig
	 * @return
	 */
	@Override
	public ShopTopConfig get(ShopTopConfig shopTopConfig) {
		return super.get(shopTopConfig);
	}
	
	/**
	 * 查询分页数据
	 * @param shopTopConfig 查询条件
	 * @param shopTopConfig.page 分页对象
	 * @return
	 */
	@Override
	public Page<ShopTopConfig> findPage(ShopTopConfig shopTopConfig) {
		return super.findPage(shopTopConfig);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param shopTopConfig
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ShopTopConfig shopTopConfig) {
		super.save(shopTopConfig);
	}
	
	/**
	 * 更新状态
	 * @param shopTopConfig
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ShopTopConfig shopTopConfig) {
		super.updateStatus(shopTopConfig);
	}
	
	/**
	 * 删除数据
	 * @param shopTopConfig
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ShopTopConfig shopTopConfig) {
		super.delete(shopTopConfig);
	}
	
}