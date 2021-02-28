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
import com.jeesite.modules.shop.entity.ShopTopConfig;
import com.jeesite.modules.shop.service.ShopTopConfigService;

/**
 * shop_top_configController
 * @author 高峰
 * @version 2021-02-17
 */
@Controller
@RequestMapping(value = "${adminPath}/shop/shopTopConfig")
public class ShopTopConfigController extends BaseController {

	@Autowired
	private ShopTopConfigService shopTopConfigService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ShopTopConfig get(String rowid, boolean isNewRecord) {
		return shopTopConfigService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("shop:shopTopConfig:view")
	@RequestMapping(value = {"list", ""})
	public String list(ShopTopConfig shopTopConfig, Model model) {
		model.addAttribute("shopTopConfig", shopTopConfig);
		return "modules/shop/shopTopConfigList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("shop:shopTopConfig:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ShopTopConfig> listData(ShopTopConfig shopTopConfig, HttpServletRequest request, HttpServletResponse response) {
		shopTopConfig.setPage(new Page<>(request, response));
		Page<ShopTopConfig> page = shopTopConfigService.findPage(shopTopConfig);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("shop:shopTopConfig:view")
	@RequestMapping(value = "form")
	public String form(ShopTopConfig shopTopConfig, Model model) {
		model.addAttribute("shopTopConfig", shopTopConfig);
		return "modules/shop/shopTopConfigForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("shop:shopTopConfig:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ShopTopConfig shopTopConfig) {
		shopTopConfigService.save(shopTopConfig);
		return renderResult(Global.TRUE, text("保存shop_top_config成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("shop:shopTopConfig:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ShopTopConfig shopTopConfig) {
		shopTopConfigService.delete(shopTopConfig);
		return renderResult(Global.TRUE, text("删除shop_top_config成功！"));
	}
	
}