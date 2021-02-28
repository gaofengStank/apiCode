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
import com.jeesite.modules.shop.entity.ShopIndexSider;
import com.jeesite.modules.shop.service.ShopIndexSiderService;

/**
 * shop_index_siderController
 * @author 高峰
 * @version 2021-02-17
 */
@Controller
@RequestMapping(value = "${adminPath}/shop/shopIndexSider")
public class ShopIndexSiderController extends BaseController {

	@Autowired
	private ShopIndexSiderService shopIndexSiderService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ShopIndexSider get(String rowid, boolean isNewRecord) {
		return shopIndexSiderService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("shop:shopIndexSider:view")
	@RequestMapping(value = {"list", ""})
	public String list(ShopIndexSider shopIndexSider, Model model) {
		model.addAttribute("shopIndexSider", shopIndexSider);
		return "modules/shop/shopIndexSiderList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("shop:shopIndexSider:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ShopIndexSider> listData(ShopIndexSider shopIndexSider, HttpServletRequest request, HttpServletResponse response) {
		shopIndexSider.setPage(new Page<>(request, response));
		Page<ShopIndexSider> page = shopIndexSiderService.findPage(shopIndexSider);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("shop:shopIndexSider:view")
	@RequestMapping(value = "form")
	public String form(ShopIndexSider shopIndexSider, Model model) {
		model.addAttribute("shopIndexSider", shopIndexSider);
		return "modules/shop/shopIndexSiderForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("shop:shopIndexSider:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ShopIndexSider shopIndexSider) {
		shopIndexSiderService.save(shopIndexSider);
		return renderResult(Global.TRUE, text("保存shop_index_sider成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("shop:shopIndexSider:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ShopIndexSider shopIndexSider) {
		shopIndexSiderService.delete(shopIndexSider);
		return renderResult(Global.TRUE, text("删除shop_index_sider成功！"));
	}
	
}