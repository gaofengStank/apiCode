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
import com.jeesite.modules.tab.entity.TabFenlei;
import com.jeesite.modules.tab.service.TabFenleiService;

/**
 * tab_fenleiController
 * @author 高峰
 * @version 2020-12-24
 */
@Controller
@RequestMapping(value = "${adminPath}/tab/tabFenlei")
public class TabFenleiController extends BaseController {

	@Autowired
	private TabFenleiService tabFenleiService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TabFenlei get(String rowid, boolean isNewRecord) {
		return tabFenleiService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("tab:tabFenlei:view")
	@RequestMapping(value = {"list", ""})
	public String list(TabFenlei tabFenlei, Model model) {
		model.addAttribute("tabFenlei", tabFenlei);
		return "modules/tab/tabFenleiList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("tab:tabFenlei:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TabFenlei> listData(TabFenlei tabFenlei, HttpServletRequest request, HttpServletResponse response) {
		tabFenlei.setPage(new Page<>(request, response));
		Page<TabFenlei> page = tabFenleiService.findPage(tabFenlei);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("tab:tabFenlei:view")
	@RequestMapping(value = "form")
	public String form(TabFenlei tabFenlei, Model model) {
		model.addAttribute("tabFenlei", tabFenlei);
		return "modules/tab/tabFenleiForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("tab:tabFenlei:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TabFenlei tabFenlei) {
		tabFenleiService.save(tabFenlei);
		return renderResult(Global.TRUE, text("保存tab_fenlei成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("tab:tabFenlei:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TabFenlei tabFenlei) {
		tabFenleiService.delete(tabFenlei);
		return renderResult(Global.TRUE, text("删除tab_fenlei成功！"));
	}
	
}