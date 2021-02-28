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
import com.jeesite.modules.tab.entity.TabYjfk;
import com.jeesite.modules.tab.service.TabYjfkService;

/**
 * tab_yjfkController
 * @author 高峰
 * @version 2021-02-27
 */
@Controller
@RequestMapping(value = "${adminPath}/tab/tabYjfk")
public class TabYjfkController extends BaseController {

	@Autowired
	private TabYjfkService tabYjfkService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TabYjfk get(String rowid, boolean isNewRecord) {
		return tabYjfkService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("tab:tabYjfk:view")
	@RequestMapping(value = {"list", ""})
	public String list(TabYjfk tabYjfk, Model model) {
		model.addAttribute("tabYjfk", tabYjfk);
		return "modules/tab/tabYjfkList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("tab:tabYjfk:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TabYjfk> listData(TabYjfk tabYjfk, HttpServletRequest request, HttpServletResponse response) {
		tabYjfk.setPage(new Page<>(request, response));
		Page<TabYjfk> page = tabYjfkService.findPage(tabYjfk);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("tab:tabYjfk:view")
	@RequestMapping(value = "form")
	public String form(TabYjfk tabYjfk, Model model) {
		model.addAttribute("tabYjfk", tabYjfk);
		return "modules/tab/tabYjfkForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("tab:tabYjfk:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TabYjfk tabYjfk) {
		tabYjfkService.save(tabYjfk);
		return renderResult(Global.TRUE, text("保存tab_yjfk成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("tab:tabYjfk:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TabYjfk tabYjfk) {
		tabYjfkService.delete(tabYjfk);
		return renderResult(Global.TRUE, text("删除tab_yjfk成功！"));
	}
	
}