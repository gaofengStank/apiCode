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
import com.jeesite.modules.shop.entity.ShopGoods;
import com.jeesite.modules.shop.service.ShopGoodsService;

/**
 * 商品信息表Controller
 * @author 高峰
 * @version 2021-02-16
 */
@Controller
@RequestMapping(value = "${adminPath}/shop/shopGoods")
public class ShopGoodsController extends BaseController {

	@Autowired
	private ShopGoodsService shopGoodsService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ShopGoods get(String rowid, boolean isNewRecord) {
		return shopGoodsService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("shop:shopGoods:view")
	@RequestMapping(value = {"list", ""})
	public String list(ShopGoods shopGoods, Model model) {
		model.addAttribute("shopGoods", shopGoods);
		return "modules/shop/shopGoodsList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("shop:shopGoods:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ShopGoods> listData(ShopGoods shopGoods, HttpServletRequest request, HttpServletResponse response) {
		shopGoods.setPage(new Page<>(request, response));
		Page<ShopGoods> page = shopGoodsService.findPage(shopGoods);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("shop:shopGoods:view")
	@RequestMapping(value = "form")
	public String form(ShopGoods shopGoods, Model model) {
		model.addAttribute("shopGoods", shopGoods);
		return "modules/shop/shopGoodsForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("shop:shopGoods:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ShopGoods shopGoods) {
		shopGoodsService.save(shopGoods);
		return renderResult(Global.TRUE, text("保存商品信息表成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("shop:shopGoods:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ShopGoods shopGoods) {
		shopGoodsService.delete(shopGoods);
		return renderResult(Global.TRUE, text("删除商品信息表成功！"));
	}
	
}