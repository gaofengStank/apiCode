/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.shop.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.shop.entity.ShopGoods;
import com.jeesite.modules.shop.dao.ShopGoodsDao;

/**
 * 商品信息表Service
 * @author 高峰
 * @version 2021-02-16
 */
@Service
@Transactional(readOnly=true)
public class ShopGoodsService extends CrudService<ShopGoodsDao, ShopGoods> {
	
	/**
	 * 获取单条数据
	 * @param shopGoods
	 * @return
	 */
	@Override
	public ShopGoods get(ShopGoods shopGoods) {
		return super.get(shopGoods);
	}
	
	/**
	 * 查询分页数据
	 * @param shopGoods 查询条件
	 * @param shopGoods.page 分页对象
	 * @return
	 */
	@Override
	public Page<ShopGoods> findPage(ShopGoods shopGoods) {
		return super.findPage(shopGoods);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param shopGoods
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ShopGoods shopGoods) {
		super.save(shopGoods);
	}
	
	/**
	 * 更新状态
	 * @param shopGoods
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ShopGoods shopGoods) {
		super.updateStatus(shopGoods);
	}
	
	/**
	 * 删除数据
	 * @param shopGoods
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ShopGoods shopGoods) {
		super.delete(shopGoods);
	}

	public List<ShopGoods> listMySc(HttpServletRequest request) {
		String  token =   request.getParameter("token");
		Map<String, String>  parame = new HashMap<String, String>();
		parame.put("token", token);
		
 		return shopGoodsDao.listMySc(request);
	}
	
	@Autowired
	private  ShopGoodsDao shopGoodsDao ;
	
}