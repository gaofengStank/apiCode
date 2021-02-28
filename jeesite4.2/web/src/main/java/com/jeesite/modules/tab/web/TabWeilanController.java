/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.web;

import java.util.Date;

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
import com.jeesite.modules.tab.entity.TabWeilan;
import com.jeesite.modules.tab.service.TabWeilanService;

/**
 * tab_weilanController
 * @author 高峰
 * @version 2020-09-26
 */
@Controller
@RequestMapping(value = "${adminPath}/tab/tabWeilan")
public class TabWeilanController extends BaseController {

	@Autowired
	private TabWeilanService tabWeilanService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TabWeilan get(String rowid, boolean isNewRecord) {
		return tabWeilanService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("tab:tabWeilan:view")
	@RequestMapping(value = {"list", ""})
	public String list(TabWeilan tabWeilan, Model model) {
		model.addAttribute("tabWeilan", tabWeilan);
		return "modules/tab/tabWeilanList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("tab:tabWeilan:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TabWeilan> listData(TabWeilan tabWeilan, HttpServletRequest request, HttpServletResponse response) {
		tabWeilan.setPage(new Page<>(request, response));
		Page<TabWeilan> page = tabWeilanService.findPage(tabWeilan);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("tab:tabWeilan:view")
	@RequestMapping(value = "form")
	public String form(TabWeilan tabWeilan, Model model) {
		model.addAttribute("tabWeilan", tabWeilan);
		return "modules/tab/tabWeilanForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("tab:tabWeilan:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TabWeilan tabWeilan) {
		tabWeilan.setCreatetime(new Date());
		tabWeilanService.save(tabWeilan);
		return renderResult(Global.TRUE, text("保存tab_weilan成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("tab:tabWeilan:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TabWeilan tabWeilan) {
		tabWeilanService.delete(tabWeilan);
		return renderResult(Global.TRUE, text("删除tab_weilan成功！"));
	}
	
	@RequiresPermissions("tab:tabWeilan:view")
	@RequestMapping(value = "form2")
	public String form2(TabWeilan tabWeilan, Model model) {
		model.addAttribute("tabWeilan", tabWeilan);
		return "modules/tab/tabWeilanForm2";
	}

	
}