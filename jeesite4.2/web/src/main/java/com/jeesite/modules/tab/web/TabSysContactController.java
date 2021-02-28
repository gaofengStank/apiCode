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
import com.jeesite.modules.tab.entity.TabSysContact;
import com.jeesite.modules.tab.service.TabSysContactService;

/**
 * tab_sys_contactController
 * @author 高峰
 * @version 2021-02-26
 */
@Controller
@RequestMapping(value = "${adminPath}/tab/tabSysContact")
public class TabSysContactController extends BaseController {

	@Autowired
	private TabSysContactService tabSysContactService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TabSysContact get(String rowid, boolean isNewRecord) {
		return tabSysContactService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("tab:tabSysContact:view")
	@RequestMapping(value = {"list", ""})
	public String list(TabSysContact tabSysContact, Model model) {
		model.addAttribute("tabSysContact", tabSysContact);
		return "modules/tab/tabSysContactList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("tab:tabSysContact:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TabSysContact> listData(TabSysContact tabSysContact, HttpServletRequest request, HttpServletResponse response) {
		tabSysContact.setPage(new Page<>(request, response));
		Page<TabSysContact> page = tabSysContactService.findPage(tabSysContact);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("tab:tabSysContact:view")
	@RequestMapping(value = "form")
	public String form(TabSysContact tabSysContact, Model model) {
		model.addAttribute("tabSysContact", tabSysContact);
		return "modules/tab/tabSysContactForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("tab:tabSysContact:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TabSysContact tabSysContact) {
		tabSysContactService.save(tabSysContact);
		return renderResult(Global.TRUE, text("保存tab_sys_contact成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("tab:tabSysContact:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TabSysContact tabSysContact) {
		tabSysContactService.delete(tabSysContact);
		return renderResult(Global.TRUE, text("删除tab_sys_contact成功！"));
	}
	
}