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
import com.jeesite.modules.shop.entity.ShopGoodCollect;
import com.jeesite.modules.shop.service.ShopGoodCollectService;

/**
 * shop_good_collectController
 * @author 高峰
 * @version 2021-02-16
 */
@Controller
@RequestMapping(value = "${adminPath}/shop/shopGoodCollect")
public class ShopGoodCollectController extends BaseController {

	@Autowired
	private ShopGoodCollectService shopGoodCollectService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ShopGoodCollect get(String rowid, boolean isNewRecord) {
		return shopGoodCollectService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("shop:shopGoodCollect:view")
	@RequestMapping(value = {"list", ""})
	public String list(ShopGoodCollect shopGoodCollect, Model model) {
		model.addAttribute("shopGoodCollect", shopGoodCollect);
		return "modules/shop/shopGoodCollectList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("shop:shopGoodCollect:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ShopGoodCollect> listData(ShopGoodCollect shopGoodCollect, HttpServletRequest request, HttpServletResponse response) {
		shopGoodCollect.setPage(new Page<>(request, response));
		Page<ShopGoodCollect> page = shopGoodCollectService.findPage(shopGoodCollect);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("shop:shopGoodCollect:view")
	@RequestMapping(value = "form")
	public String form(ShopGoodCollect shopGoodCollect, Model model) {
		model.addAttribute("shopGoodCollect", shopGoodCollect);
		return "modules/shop/shopGoodCollectForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("shop:shopGoodCollect:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ShopGoodCollect shopGoodCollect) {
		shopGoodCollectService.save(shopGoodCollect);
		return renderResult(Global.TRUE, text("保存shop_good_collect成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("shop:shopGoodCollect:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ShopGoodCollect shopGoodCollect) {
		shopGoodCollectService.delete(shopGoodCollect);
		return renderResult(Global.TRUE, text("删除shop_good_collect成功！"));
	}
	
}