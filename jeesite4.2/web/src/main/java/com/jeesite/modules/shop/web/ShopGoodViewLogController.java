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
import com.jeesite.modules.shop.entity.ShopGoodViewLog;
import com.jeesite.modules.shop.service.ShopGoodViewLogService;

/**
 * shop_good_view_logController
 * @author 商品浏览记录
 * @version 2021-02-16
 */
@Controller
@RequestMapping(value = "${adminPath}/shop/shopGoodViewLog")
public class ShopGoodViewLogController extends BaseController {

	@Autowired
	private ShopGoodViewLogService shopGoodViewLogService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ShopGoodViewLog get(String rowid, boolean isNewRecord) {
		return shopGoodViewLogService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("shop:shopGoodViewLog:view")
	@RequestMapping(value = {"list", ""})
	public String list(ShopGoodViewLog shopGoodViewLog, Model model) {
		model.addAttribute("shopGoodViewLog", shopGoodViewLog);
		return "modules/shop/shopGoodViewLogList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("shop:shopGoodViewLog:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ShopGoodViewLog> listData(ShopGoodViewLog shopGoodViewLog, HttpServletRequest request, HttpServletResponse response) {
		shopGoodViewLog.setPage(new Page<>(request, response));
		Page<ShopGoodViewLog> page = shopGoodViewLogService.findPage(shopGoodViewLog);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("shop:shopGoodViewLog:view")
	@RequestMapping(value = "form")
	public String form(ShopGoodViewLog shopGoodViewLog, Model model) {
		model.addAttribute("shopGoodViewLog", shopGoodViewLog);
		return "modules/shop/shopGoodViewLogForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("shop:shopGoodViewLog:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ShopGoodViewLog shopGoodViewLog) {
		shopGoodViewLogService.save(shopGoodViewLog);
		return renderResult(Global.TRUE, text("保存shop_good_view_log成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("shop:shopGoodViewLog:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ShopGoodViewLog shopGoodViewLog) {
		shopGoodViewLogService.delete(shopGoodViewLog);
		return renderResult(Global.TRUE, text("删除shop_good_view_log成功！"));
	}
	
}