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
import com.jeesite.modules.tab.entity.TabOrderTuihuo;
import com.jeesite.modules.tab.service.TabOrderTuihuoService;

/**
 * tab_order_tuihuoController
 * @author 高峰
 * @version 2021-02-16
 */
@Controller
@RequestMapping(value = "${adminPath}/tab/tabOrderTuihuo")
public class TabOrderTuihuoController extends BaseController {

	@Autowired
	private TabOrderTuihuoService tabOrderTuihuoService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TabOrderTuihuo get(String rowid, boolean isNewRecord) {
		return tabOrderTuihuoService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("tab:tabOrderTuihuo:view")
	@RequestMapping(value = {"list", ""})
	public String list(TabOrderTuihuo tabOrderTuihuo, Model model) {
		model.addAttribute("tabOrderTuihuo", tabOrderTuihuo);
		return "modules/tab/tabOrderTuihuoList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("tab:tabOrderTuihuo:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TabOrderTuihuo> listData(TabOrderTuihuo tabOrderTuihuo, HttpServletRequest request, HttpServletResponse response) {
		tabOrderTuihuo.setPage(new Page<>(request, response));
		Page<TabOrderTuihuo> page = tabOrderTuihuoService.findPage(tabOrderTuihuo);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("tab:tabOrderTuihuo:view")
	@RequestMapping(value = "form")
	public String form(TabOrderTuihuo tabOrderTuihuo, Model model) {
		model.addAttribute("tabOrderTuihuo", tabOrderTuihuo);
		return "modules/tab/tabOrderTuihuoForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("tab:tabOrderTuihuo:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TabOrderTuihuo tabOrderTuihuo) {
		tabOrderTuihuoService.save(tabOrderTuihuo);
		return renderResult(Global.TRUE, text("保存tab_order_tuihuo成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("tab:tabOrderTuihuo:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TabOrderTuihuo tabOrderTuihuo) {
		tabOrderTuihuoService.delete(tabOrderTuihuo);
		return renderResult(Global.TRUE, text("删除tab_order_tuihuo成功！"));
	}
	
}