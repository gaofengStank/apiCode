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
import com.jeesite.modules.shop.entity.ShopBusiness;
import com.jeesite.modules.shop.service.ShopBusinessService;

/**
 * shop_businessController
 * @author 高峰
 * @version 2021-02-19
 */
@Controller
@RequestMapping(value = "${adminPath}/shop/shopBusiness")
public class ShopBusinessController extends BaseController {

	@Autowired
	private ShopBusinessService shopBusinessService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ShopBusiness get(String rowid, boolean isNewRecord) {
		return shopBusinessService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("shop:shopBusiness:view")
	@RequestMapping(value = {"list", ""})
	public String list(ShopBusiness shopBusiness, Model model) {
		model.addAttribute("shopBusiness", shopBusiness);
		return "modules/shop/shopBusinessList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("shop:shopBusiness:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ShopBusiness> listData(ShopBusiness shopBusiness, HttpServletRequest request, HttpServletResponse response) {
		shopBusiness.setPage(new Page<>(request, response));
		Page<ShopBusiness> page = shopBusinessService.findPage(shopBusiness);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("shop:shopBusiness:view")
	@RequestMapping(value = "form")
	public String form(ShopBusiness shopBusiness, Model model) {
		model.addAttribute("shopBusiness", shopBusiness);
		return "modules/shop/shopBusinessForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("shop:shopBusiness:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ShopBusiness shopBusiness) {
		shopBusinessService.save(shopBusiness);
		return renderResult(Global.TRUE, text("保存shop_business成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("shop:shopBusiness:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ShopBusiness shopBusiness) {
		shopBusinessService.delete(shopBusiness);
		return renderResult(Global.TRUE, text("删除shop_business成功！"));
	}
	
}