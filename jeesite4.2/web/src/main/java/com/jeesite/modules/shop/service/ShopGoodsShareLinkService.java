/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.shop.entity.ShopGoodsShareLink;
import com.jeesite.modules.shop.dao.ShopGoodsShareLinkDao;

/**
 * shop_goods_share_linkService
 * @author 高峰
 * @version 2021-02-16
 */
@Service
@Transactional(readOnly=true)
public class ShopGoodsShareLinkService extends CrudService<ShopGoodsShareLinkDao, ShopGoodsShareLink> {
	
	/**
	 * 获取单条数据
	 * @param shopGoodsShareLink
	 * @return
	 */
	@Override
	public ShopGoodsShareLink get(ShopGoodsShareLink shopGoodsShareLink) {
		return super.get(shopGoodsShareLink);
	}
	
	/**
	 * 查询分页数据
	 * @param shopGoodsShareLink 查询条件
	 * @param shopGoodsShareLink.page 分页对象
	 * @return
	 */
	@Override
	public Page<ShopGoodsShareLink> findPage(ShopGoodsShareLink shopGoodsShareLink) {
		return super.findPage(shopGoodsShareLink);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param shopGoodsShareLink
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ShopGoodsShareLink shopGoodsShareLink) {
		super.save(shopGoodsShareLink);
	}
	
	/**
	 * 更新状态
	 * @param shopGoodsShareLink
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ShopGoodsShareLink shopGoodsShareLink) {
		super.updateStatus(shopGoodsShareLink);
	}
	
	/**
	 * 删除数据
	 * @param shopGoodsShareLink
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ShopGoodsShareLink shopGoodsShareLink) {
		super.delete(shopGoodsShareLink);
	}
	
}