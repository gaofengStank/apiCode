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
import com.jeesite.modules.shop.entity.ShopBbs;
import com.jeesite.modules.shop.service.ShopBbsService;

/**
 * shop_bbsController
 * @author 高峰
 * @version 2021-02-17
 */
@Controller
@RequestMapping(value = "${adminPath}/shop/shopBbs")
public class ShopBbsController extends BaseController {

	@Autowired
	private ShopBbsService shopBbsService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ShopBbs get(String rowid, boolean isNewRecord) {
		return shopBbsService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("shop:shopBbs:view")
	@RequestMapping(value = {"list", ""})
	public String list(ShopBbs shopBbs, Model model) {
		model.addAttribute("shopBbs", shopBbs);
		return "modules/shop/shopBbsList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("shop:shopBbs:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ShopBbs> listData(ShopBbs shopBbs, HttpServletRequest request, HttpServletResponse response) {
		shopBbs.setPage(new Page<>(request, response));
		Page<ShopBbs> page = shopBbsService.findPage(shopBbs);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("shop:shopBbs:view")
	@RequestMapping(value = "form")
	public String form(ShopBbs shopBbs, Model model) {
		model.addAttribute("shopBbs", shopBbs);
		return "modules/shop/shopBbsForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("shop:shopBbs:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ShopBbs shopBbs) {
		shopBbsService.save(shopBbs);
		return renderResult(Global.TRUE, text("保存shop_bbs成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("shop:shopBbs:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ShopBbs shopBbs) {
		shopBbsService.delete(shopBbs);
		return renderResult(Global.TRUE, text("删除shop_bbs成功！"));
	}
	
}