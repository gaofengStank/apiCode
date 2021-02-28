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
import com.jeesite.modules.tab.entity.TabOrderGwc;
import com.jeesite.modules.tab.service.TabOrderGwcService;

/**
 * tab_order_gwcController
 * @author 高峰
 * @version 2021-02-16
 */
@Controller
@RequestMapping(value = "${adminPath}/tab/tabOrderGwc")
public class TabOrderGwcController extends BaseController {

	@Autowired
	private TabOrderGwcService tabOrderGwcService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TabOrderGwc get(String rowid, boolean isNewRecord) {
		return tabOrderGwcService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("tab:tabOrderGwc:view")
	@RequestMapping(value = {"list", ""})
	public String list(TabOrderGwc tabOrderGwc, Model model) {
		model.addAttribute("tabOrderGwc", tabOrderGwc);
		return "modules/tab/tabOrderGwcList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("tab:tabOrderGwc:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TabOrderGwc> listData(TabOrderGwc tabOrderGwc, HttpServletRequest request, HttpServletResponse response) {
		tabOrderGwc.setPage(new Page<>(request, response));
		Page<TabOrderGwc> page = tabOrderGwcService.findPage(tabOrderGwc);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("tab:tabOrderGwc:view")
	@RequestMapping(value = "form")
	public String form(TabOrderGwc tabOrderGwc, Model model) {
		model.addAttribute("tabOrderGwc", tabOrderGwc);
		return "modules/tab/tabOrderGwcForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("tab:tabOrderGwc:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TabOrderGwc tabOrderGwc) {
		tabOrderGwcService.save(tabOrderGwc);
		return renderResult(Global.TRUE, text("保存tab_order_gwc成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("tab:tabOrderGwc:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TabOrderGwc tabOrderGwc) {
		tabOrderGwcService.delete(tabOrderGwc);
		return renderResult(Global.TRUE, text("删除tab_order_gwc成功！"));
	}
	
}