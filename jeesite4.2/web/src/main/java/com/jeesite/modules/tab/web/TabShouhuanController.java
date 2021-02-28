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
import com.jeesite.modules.sys.utils.UserUtils;
import com.jeesite.modules.tab.entity.TabShouhuan;
import com.jeesite.modules.tab.entity.TabWeilan;
import com.jeesite.modules.tab.service.TabShouhuanService;

/**
 * tab_shouhuanController
 * @author 高峰
 * @version 2020-09-26
 */
@Controller
@RequestMapping(value = "${adminPath}/tab/tabShouhuan")
public class TabShouhuanController extends BaseController {

	@Autowired
	private TabShouhuanService tabShouhuanService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TabShouhuan get(String rowid, boolean isNewRecord) {
		return tabShouhuanService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("tab:tabShouhuan:view")
	@RequestMapping(value = {"list", ""})
	public String list(TabShouhuan tabShouhuan, Model model) {
		model.addAttribute("tabShouhuan", tabShouhuan);
		return "modules/tab/tabShouhuanList";
	}
	@RequiresPermissions("tab:tabShouhuan:view")
	@RequestMapping(value = {"list2", ""})
	public String list2(TabShouhuan tabShouhuan, Model model) {
		model.addAttribute("tabShouhuan", tabShouhuan);
		return "modules/tab/tabShouhuanList2";
	}
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("tab:tabShouhuan:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TabShouhuan> listData(TabShouhuan tabShouhuan, HttpServletRequest request, HttpServletResponse response) {
		tabShouhuan.setPage(new Page<>(request, response));
		String  code =  UserUtils.getUser().getLoginCode();
		tabShouhuan.setLogincode(code);
		Page<TabShouhuan> page = tabShouhuanService.findPage(tabShouhuan);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("tab:tabShouhuan:view")
	@RequestMapping(value = "form")
	public String form(TabShouhuan tabShouhuan, Model model) {
		model.addAttribute("tabShouhuan", tabShouhuan);
		return "modules/tab/tabShouhuanForm";
	}
	@RequiresPermissions("tab:tabShouhuan:view")
	@RequestMapping(value = "form2")
	public String form2(TabShouhuan tabShouhuan, Model model) {
		TabWeilan tabWeilan  = new TabWeilan();
		tabWeilan.setImei(tabShouhuan.getImei());
		model.addAttribute("tabWeilan",tabWeilan );
		return "modules/tab/tabWeilanForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("tab:tabShouhuan:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TabShouhuan tabShouhuan) {
		String  code =  UserUtils.getUser().getLoginCode();
		tabShouhuan.setLogincode(code);
		tabShouhuanService.save(tabShouhuan);
		return renderResult(Global.TRUE, text("保存手环信息管理成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("tab:tabShouhuan:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TabShouhuan tabShouhuan) {
		tabShouhuanService.delete(tabShouhuan);
		return renderResult(Global.TRUE, text("删除手环信息管理成功！"));
	}
	
}