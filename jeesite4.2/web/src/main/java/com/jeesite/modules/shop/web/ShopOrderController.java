/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.shop.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.shop.entity.ShopOrder;
import com.jeesite.modules.shop.service.ShopOrderService;

/**
 * shop_orderController
 * @author 高峰
 * @version 2021-02-16
 */
@Controller
@RequestMapping(value = "${adminPath}/shop/shopOrder")
public class ShopOrderController extends BaseController {

	@Autowired
	private ShopOrderService shopOrderService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ShopOrder get(String rowid, boolean isNewRecord) {
		return shopOrderService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("shop:shopOrder:view")
	@RequestMapping(value = {"list", ""})
	public String list(ShopOrder shopOrder, Model model) {
		model.addAttribute("shopOrder", shopOrder);
		return "modules/shop/shopOrderList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("shop:shopOrder:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ShopOrder> listData(ShopOrder shopOrder, HttpServletRequest request, HttpServletResponse response) {
		shopOrder.setPage(new Page<>(request, response));
		Page<ShopOrder> page = shopOrderService.findPage(shopOrder);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("shop:shopOrder:view")
	@RequestMapping(value = "form")
	public String form(ShopOrder shopOrder, Model model) {
		model.addAttribute("shopOrder", shopOrder);
		return "modules/shop/shopOrderForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("shop:shopOrder:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ShopOrder shopOrder) {
		shopOrderService.save(shopOrder);
		return renderResult(Global.TRUE, text("保存shop_order成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("shop:shopOrder:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ShopOrder shopOrder) {
		shopOrderService.delete(shopOrder);
		return renderResult(Global.TRUE, text("删除shop_order成功！"));
	}
	
}