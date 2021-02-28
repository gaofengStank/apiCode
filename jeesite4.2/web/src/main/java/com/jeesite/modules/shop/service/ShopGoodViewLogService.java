/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.shop.entity.ShopGoodViewLog;
import com.jeesite.modules.shop.dao.ShopGoodViewLogDao;

/**
 * shop_good_view_logService
 * @author 商品浏览记录
 * @version 2021-02-16
 */
@Service
@Transactional(readOnly=true)
public class ShopGoodViewLogService extends CrudService<ShopGoodViewLogDao, ShopGoodViewLog> {
	
	/**
	 * 获取单条数据
	 * @param shopGoodViewLog
	 * @return
	 */
	@Override
	public ShopGoodViewLog get(ShopGoodViewLog shopGoodViewLog) {
		return super.get(shopGoodViewLog);
	}
	
	/**
	 * 查询分页数据
	 * @param shopGoodViewLog 查询条件
	 * @param shopGoodViewLog.page 分页对象
	 * @return
	 */
	@Override
	public Page<ShopGoodViewLog> findPage(ShopGoodViewLog shopGoodViewLog) {
		return super.findPage(shopGoodViewLog);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param shopGoodViewLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ShopGoodViewLog shopGoodViewLog) {
		super.save(shopGoodViewLog);
	}
	
	/**
	 * 更新状态
	 * @param shopGoodViewLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ShopGoodViewLog shopGoodViewLog) {
		super.updateStatus(shopGoodViewLog);
	}
	
	/**
	 * 删除数据
	 * @param shopGoodViewLog
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ShopGoodViewLog shopGoodViewLog) {
		super.delete(shopGoodViewLog);
	}
	
}