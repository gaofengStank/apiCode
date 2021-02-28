/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.shop.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.shop.entity.ShopGoods;
import com.jeesite.modules.shop.entity.ShopOrder;
import com.jeesite.modules.tab.api.DateUtils;
import com.jeesite.modules.tab.entity.TabOrderGwc;
import com.jeesite.modules.tab.entity.TabOrderList;
import com.jeesite.modules.tab.service.TabOrderGwcService;
import com.jeesite.modules.tab.service.TabOrderListService;
import com.jeesite.modules.shop.dao.ShopOrderDao;

/**
 * shop_orderService
 * @author 高峰
 * @version 2021-02-16
 */
@Service
@Transactional(readOnly=true)
public class ShopOrderService extends CrudService<ShopOrderDao, ShopOrder> {
	
	/**
	 * 获取单条数据
	 * @param shopOrder
	 * @return
	 */
	@Override
	public ShopOrder get(ShopOrder shopOrder) {
		return super.get(shopOrder);
	}
	
	/**
	 * 查询分页数据
	 * @param shopOrder 查询条件
	 * @param shopOrder.page 分页对象
	 * @return
	 */
	@Override
	public Page<ShopOrder> findPage(ShopOrder shopOrder) {
		return super.findPage(shopOrder);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param shopOrder
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ShopOrder shopOrder) {
		super.save(shopOrder);
	}
	
	/**
	 * 更新状态
	 * @param shopOrder
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ShopOrder shopOrder) {
		super.updateStatus(shopOrder);
	}
	
	private String getOrder() {

		String val = "";
		Random random = new Random();

		// 参数length，表示生成几位随机数
		for (int i = 0; i < 8; i++) {

			String charOrNum = i > 6 ? "char" : "num";
			// 输出字母还是数字
			if ("char".equalsIgnoreCase(charOrNum)) {
				// 输出是大写字母还是小写字母
				int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
				val += (char) (random.nextInt(26) + temp);
			} else if ("num".equalsIgnoreCase(charOrNum)) {
				val += String.valueOf(random.nextInt(10));
			}
		}

		return val;

	}
	
	
	/**
	 * 删除数据
	 * @param shopOrder
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ShopOrder shopOrder) {
		super.delete(shopOrder);
	}
	@Transactional(readOnly=false)
	public Map<String, Object> submitOrder(HttpServletRequest request) {
		String  token =   request.getParameter("token");
		
		String  rowid =   request.getParameter("rowid");
		
		ShopGoods goods  =   shopGoodsService.get(rowid);
		
		String orderId = DateUtils.dateFormatByDate4(new Date()) + getOrder();

		
		ShopOrder shopOrder   =new ShopOrder();
		shopOrder.setUserid(token);
		shopOrder.setOrderstatus("0");
		shopOrder.setCreatetime(new Date());
		shopOrder.setIstixing("1");
		shopOrder.setIsprints("1");
		shopOrder.setOrdermoney(goods.getPrice1());
		shopOrder.setOrderids(orderId);
		shopOrder.setRowid(UUID.randomUUID().toString());
		shopOrder.setIsNewRecord(true);
		this.save(shopOrder);
		
		TabOrderList tabOrderList = new TabOrderList();
		tabOrderList.setProductid(rowid);
		tabOrderList.setUserid(token);
		tabOrderList.setPirce(goods.getPrice1());
		tabOrderList.setNums(1D);
		tabOrderList.setCreatetime(new Date());
		tabOrderList.setOrderid(orderId);
		tabOrderList.setBussinessid(goods.getBussId());
		tabOrderList.setIsNewRecord(true);
		tabOrderListService.save(tabOrderList);
		
		Map<String, Object> returnValue = new HashMap<String, Object>();
		returnValue.put("flag", "true");
		
		returnValue.put("data", shopOrder);
		
		
		
		return returnValue;
	}
	
	@Transactional(readOnly=false)
	public Map<String, Object> submitOrder2(HttpServletRequest request) {
		String  token =   request.getParameter("token");
		
		TabOrderGwc entity = new TabOrderGwc();
		entity.setUserid(token);;
		List<TabOrderGwc> tabOrderGwcs  =   tabOrderGwcService.findList(entity );
		
		String orderId = DateUtils.dateFormatByDate4(new Date()) + getOrder();

		
		ShopOrder shopOrder   =new ShopOrder();
		shopOrder.setUserid(token);
		shopOrder.setOrderstatus("0");
		shopOrder.setCreatetime(new Date());
		shopOrder.setIstixing("1");
		shopOrder.setIsprints("1");
		Double money =  0D  ;
		for (TabOrderGwc tabOrderGwc : tabOrderGwcs) {
			ShopGoods goods    =   shopGoodsService.get(tabOrderGwc.getProductid());
			
			TabOrderList tabOrderList = new TabOrderList();
			tabOrderList.setProductid(tabOrderGwc.getProductid());
			tabOrderList.setUserid(token);
			tabOrderList.setPirce(goods.getPrice1());
			tabOrderList.setNums(Double.valueOf(tabOrderGwc.getNums()));
			tabOrderList.setCreatetime(new Date());
			tabOrderList.setOrderid(orderId);
			tabOrderList.setBussinessid(goods.getBussId());
			tabOrderList.setIsNewRecord(true);
			money=   money +   goods.getPrice1()   *     tabOrderGwc.getNums(); 
			tabOrderListService.save(tabOrderList);
		}
	
		
		shopOrder.setOrdermoney(money);
		shopOrder.setOrderids(orderId);
		shopOrder.setRowid(UUID.randomUUID().toString());
		shopOrder.setIsNewRecord(true);
		shopOrder.setIsservice("2");
		this.save(shopOrder);
		Map<String, Object> returnValue = new HashMap<String, Object>();
		returnValue.put("flag", "true");
		
		returnValue.put("data", shopOrder);
		
		
		return returnValue;
	}
	@Autowired
	private ShopGoodsService  shopGoodsService ;
	@Autowired
	private  TabOrderListService tabOrderListService ;
	
	@Autowired
	private  TabOrderGwcService tabOrderGwcService ;
	
}