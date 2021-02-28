/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.web;

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
import com.jeesite.modules.tab.entity.TabProduct;
import com.jeesite.modules.tab.service.TabProductService;

/**
 * tab_productController
 * @author 高峰
 * @version 2020-12-24
 */
@Controller
@RequestMapping(value = "${adminPath}/tab/tabProduct")
public class TabProductController extends BaseController {

	@Autowired
	private TabProductService tabProductService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TabProduct get(String rowid, boolean isNewRecord) {
		return tabProductService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("tab:tabProduct:view")
	@RequestMapping(value = {"list", ""})
	public String list(TabProduct tabProduct, Model model) {
		model.addAttribute("tabProduct", tabProduct);
		return "modules/tab/tabProductList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("tab:tabProduct:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TabProduct> listData(TabProduct tabProduct, HttpServletRequest request, HttpServletResponse response) {
		tabProduct.setPage(new Page<>(request, response));
		Page<TabProduct> page = tabProductService.findPage(tabProduct);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("tab:tabProduct:view")
	@RequestMapping(value = "form")
	public String form(TabProduct tabProduct, Model model) {
		model.addAttribute("tabProduct", tabProduct);
		return "modules/tab/tabProductForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("tab:tabProduct:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TabProduct tabProduct) {
		tabProductService.save(tabProduct);
		return renderResult(Global.TRUE, text("保存tab_product成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("tab:tabProduct:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TabProduct tabProduct) {
		tabProductService.delete(tabProduct);
		return renderResult(Global.TRUE, text("删除tab_product成功！"));
	}
	
}