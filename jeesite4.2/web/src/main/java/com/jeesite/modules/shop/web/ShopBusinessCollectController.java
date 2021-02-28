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
import com.jeesite.modules.shop.entity.ShopBusinessCollect;
import com.jeesite.modules.shop.service.ShopBusinessCollectService;

/**
 * shop_business_collectController
 * @author 高峰
 * @version 2021-02-23
 */
@Controller
@RequestMapping(value = "${adminPath}/shop/shopBusinessCollect")
public class ShopBusinessCollectController extends BaseController {

	@Autowired
	private ShopBusinessCollectService shopBusinessCollectService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ShopBusinessCollect get(String rowid, boolean isNewRecord) {
		return shopBusinessCollectService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("shop:shopBusinessCollect:view")
	@RequestMapping(value = {"list", ""})
	public String list(ShopBusinessCollect shopBusinessCollect, Model model) {
		model.addAttribute("shopBusinessCollect", shopBusinessCollect);
		return "modules/shop/shopBusinessCollectList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("shop:shopBusinessCollect:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ShopBusinessCollect> listData(ShopBusinessCollect shopBusinessCollect, HttpServletRequest request, HttpServletResponse response) {
		shopBusinessCollect.setPage(new Page<>(request, response));
		Page<ShopBusinessCollect> page = shopBusinessCollectService.findPage(shopBusinessCollect);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("shop:shopBusinessCollect:view")
	@RequestMapping(value = "form")
	public String form(ShopBusinessCollect shopBusinessCollect, Model model) {
		model.addAttribute("shopBusinessCollect", shopBusinessCollect);
		return "modules/shop/shopBusinessCollectForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("shop:shopBusinessCollect:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ShopBusinessCollect shopBusinessCollect) {
		shopBusinessCollectService.save(shopBusinessCollect);
		return renderResult(Global.TRUE, text("保存shop_business_collect成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("shop:shopBusinessCollect:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ShopBusinessCollect shopBusinessCollect) {
		shopBusinessCollectService.delete(shopBusinessCollect);
		return renderResult(Global.TRUE, text("删除shop_business_collect成功！"));
	}
	
}