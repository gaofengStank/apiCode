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
import com.jeesite.modules.shop.entity.ShopGoodsShareLink;
import com.jeesite.modules.shop.service.ShopGoodsShareLinkService;

/**
 * shop_goods_share_linkController
 * @author 高峰
 * @version 2021-02-16
 */
@Controller
@RequestMapping(value = "${adminPath}/shop/shopGoodsShareLink")
public class ShopGoodsShareLinkController extends BaseController {

	@Autowired
	private ShopGoodsShareLinkService shopGoodsShareLinkService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ShopGoodsShareLink get(String rowid, boolean isNewRecord) {
		return shopGoodsShareLinkService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("shop:shopGoodsShareLink:view")
	@RequestMapping(value = {"list", ""})
	public String list(ShopGoodsShareLink shopGoodsShareLink, Model model) {
		model.addAttribute("shopGoodsShareLink", shopGoodsShareLink);
		return "modules/shop/shopGoodsShareLinkList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("shop:shopGoodsShareLink:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ShopGoodsShareLink> listData(ShopGoodsShareLink shopGoodsShareLink, HttpServletRequest request, HttpServletResponse response) {
		shopGoodsShareLink.setPage(new Page<>(request, response));
		Page<ShopGoodsShareLink> page = shopGoodsShareLinkService.findPage(shopGoodsShareLink);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("shop:shopGoodsShareLink:view")
	@RequestMapping(value = "form")
	public String form(ShopGoodsShareLink shopGoodsShareLink, Model model) {
		model.addAttribute("shopGoodsShareLink", shopGoodsShareLink);
		return "modules/shop/shopGoodsShareLinkForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("shop:shopGoodsShareLink:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ShopGoodsShareLink shopGoodsShareLink) {
		shopGoodsShareLinkService.save(shopGoodsShareLink);
		return renderResult(Global.TRUE, text("保存shop_goods_share_link成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("shop:shopGoodsShareLink:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ShopGoodsShareLink shopGoodsShareLink) {
		shopGoodsShareLinkService.delete(shopGoodsShareLink);
		return renderResult(Global.TRUE, text("删除shop_goods_share_link成功！"));
	}
	
}