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
import com.jeesite.modules.tab.entity.TabPachongProduct;
import com.jeesite.modules.tab.service.TabPachongProductService;

/**
 * tab_pachong_productController
 * @author 高峰
 * @version 2020-10-03
 */
@Controller
@RequestMapping(value = "${adminPath}/tab/tabPachongProduct")
public class TabPachongProductController extends BaseController {

	@Autowired
	private TabPachongProductService tabPachongProductService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TabPachongProduct get(String rowid, boolean isNewRecord) {
		return tabPachongProductService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("tab:tabPachongProduct:view")
	@RequestMapping(value = {"list", ""})
	public String list(TabPachongProduct tabPachongProduct, Model model) {
		model.addAttribute("tabPachongProduct", tabPachongProduct);
		return "modules/tab/tabPachongProductList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("tab:tabPachongProduct:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TabPachongProduct> listData(TabPachongProduct tabPachongProduct, HttpServletRequest request, HttpServletResponse response) {
		tabPachongProduct.setPage(new Page<>(request, response));
		Page<TabPachongProduct> page = tabPachongProductService.findPage(tabPachongProduct);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("tab:tabPachongProduct:view")
	@RequestMapping(value = "form")
	public String form(TabPachongProduct tabPachongProduct, Model model) {
		model.addAttribute("tabPachongProduct", tabPachongProduct);
		return "modules/tab/tabPachongProductForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("tab:tabPachongProduct:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TabPachongProduct tabPachongProduct) {
		tabPachongProductService.save(tabPachongProduct);
		return renderResult(Global.TRUE, text("保存tab_pachong_product成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("tab:tabPachongProduct:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TabPachongProduct tabPachongProduct) {
		tabPachongProductService.delete(tabPachongProduct);
		return renderResult(Global.TRUE, text("删除tab_pachong_product成功！"));
	}
	
}