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
import com.jeesite.modules.shop.entity.ShopGoodFenlei;
import com.jeesite.modules.shop.service.ShopGoodFenleiService;

/**
 * shop_good_fenleiController
 * @author 高峰
 * @version 2021-02-17
 */
@Controller
@RequestMapping(value = "${adminPath}/shop/shopGoodFenlei")
public class ShopGoodFenleiController extends BaseController {

	@Autowired
	private ShopGoodFenleiService shopGoodFenleiService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ShopGoodFenlei get(String rowid, boolean isNewRecord) {
		return shopGoodFenleiService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("shop:shopGoodFenlei:view")
	@RequestMapping(value = {"list", ""})
	public String list(ShopGoodFenlei shopGoodFenlei, Model model) {
		model.addAttribute("shopGoodFenlei", shopGoodFenlei);
		return "modules/shop/shopGoodFenleiList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("shop:shopGoodFenlei:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ShopGoodFenlei> listData(ShopGoodFenlei shopGoodFenlei, HttpServletRequest request, HttpServletResponse response) {
		shopGoodFenlei.setPage(new Page<>(request, response));
		Page<ShopGoodFenlei> page = shopGoodFenleiService.findPage(shopGoodFenlei);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("shop:shopGoodFenlei:view")
	@RequestMapping(value = "form")
	public String form(ShopGoodFenlei shopGoodFenlei, Model model) {
		model.addAttribute("shopGoodFenlei", shopGoodFenlei);
		return "modules/shop/shopGoodFenleiForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("shop:shopGoodFenlei:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ShopGoodFenlei shopGoodFenlei) {
		shopGoodFenleiService.save(shopGoodFenlei);
		return renderResult(Global.TRUE, text("保存shop_good_fenlei成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("shop:shopGoodFenlei:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ShopGoodFenlei shopGoodFenlei) {
		shopGoodFenleiService.delete(shopGoodFenlei);
		return renderResult(Global.TRUE, text("删除shop_good_fenlei成功！"));
	}
	
}