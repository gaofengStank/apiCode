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
import com.jeesite.modules.shop.entity.ShopSerachConfig;
import com.jeesite.modules.shop.service.ShopSerachConfigService;

/**
 * shop_serach_configController
 * @author 高峰
 * @version 2021-02-17
 */
@Controller
@RequestMapping(value = "${adminPath}/shop/shopSerachConfig")
public class ShopSerachConfigController extends BaseController {

	@Autowired
	private ShopSerachConfigService shopSerachConfigService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ShopSerachConfig get(String rowid, boolean isNewRecord) {
		return shopSerachConfigService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("shop:shopSerachConfig:view")
	@RequestMapping(value = {"list", ""})
	public String list(ShopSerachConfig shopSerachConfig, Model model) {
		model.addAttribute("shopSerachConfig", shopSerachConfig);
		return "modules/shop/shopSerachConfigList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("shop:shopSerachConfig:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ShopSerachConfig> listData(ShopSerachConfig shopSerachConfig, HttpServletRequest request, HttpServletResponse response) {
		shopSerachConfig.setPage(new Page<>(request, response));
		Page<ShopSerachConfig> page = shopSerachConfigService.findPage(shopSerachConfig);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("shop:shopSerachConfig:view")
	@RequestMapping(value = "form")
	public String form(ShopSerachConfig shopSerachConfig, Model model) {
		model.addAttribute("shopSerachConfig", shopSerachConfig);
		return "modules/shop/shopSerachConfigForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("shop:shopSerachConfig:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ShopSerachConfig shopSerachConfig) {
		shopSerachConfigService.save(shopSerachConfig);
		return renderResult(Global.TRUE, text("保存shop_serach_config成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("shop:shopSerachConfig:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ShopSerachConfig shopSerachConfig) {
		shopSerachConfigService.delete(shopSerachConfig);
		return renderResult(Global.TRUE, text("删除shop_serach_config成功！"));
	}
	
}