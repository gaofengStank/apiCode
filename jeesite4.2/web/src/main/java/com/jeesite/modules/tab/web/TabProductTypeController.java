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
import com.jeesite.modules.tab.entity.TabProductType;
import com.jeesite.modules.tab.service.TabProductTypeService;

/**
 * tab_product_typeController
 * @author 产品分类
 * @version 2020-12-24
 */
@Controller
@RequestMapping(value = "${adminPath}/tab/tabProductType")
public class TabProductTypeController extends BaseController {

	@Autowired
	private TabProductTypeService tabProductTypeService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TabProductType get(String rowid, boolean isNewRecord) {
		return tabProductTypeService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("tab:tabProductType:view")
	@RequestMapping(value = {"list", ""})
	public String list(TabProductType tabProductType, Model model) {
		model.addAttribute("tabProductType", tabProductType);
		return "modules/tab/tabProductTypeList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("tab:tabProductType:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TabProductType> listData(TabProductType tabProductType, HttpServletRequest request, HttpServletResponse response) {
		tabProductType.setPage(new Page<>(request, response));
		Page<TabProductType> page = tabProductTypeService.findPage(tabProductType);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("tab:tabProductType:view")
	@RequestMapping(value = "form")
	public String form(TabProductType tabProductType, Model model) {
		model.addAttribute("tabProductType", tabProductType);
		return "modules/tab/tabProductTypeForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("tab:tabProductType:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TabProductType tabProductType) {
		tabProductTypeService.save(tabProductType);
		return renderResult(Global.TRUE, text("保存tab_product_type成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("tab:tabProductType:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TabProductType tabProductType) {
		tabProductTypeService.delete(tabProductType);
		return renderResult(Global.TRUE, text("删除tab_product_type成功！"));
	}
	
}