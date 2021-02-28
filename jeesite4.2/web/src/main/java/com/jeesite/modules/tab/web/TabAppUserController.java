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
import com.jeesite.modules.sys.utils.UserUtils;
import com.jeesite.modules.tab.entity.TabAppUser;
import com.jeesite.modules.tab.service.TabAppUserService;

/**
 * tab_app_userController
 * @author 高峰
 * @version 2020-09-28
 */
@Controller
@RequestMapping(value = "${adminPath}/tab/tabAppUser")
public class TabAppUserController extends BaseController {

	@Autowired
	private TabAppUserService tabAppUserService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TabAppUser get(String rowid, boolean isNewRecord) {
		return tabAppUserService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("tab:tabAppUser:view")
	@RequestMapping(value = {"list", ""})
	public String list(TabAppUser tabAppUser, Model model) {
		model.addAttribute("tabAppUser", tabAppUser);
		return "modules/tab/tabAppUserList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("tab:tabAppUser:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TabAppUser> listData(TabAppUser tabAppUser, HttpServletRequest request, HttpServletResponse response) {
		tabAppUser.setPage(new Page<>(request, response));
		String  code =  UserUtils.getUser().getLoginCode();
		tabAppUser.setLogincode(code);
		Page<TabAppUser> page = tabAppUserService.findPage(tabAppUser);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("tab:tabAppUser:view")
	@RequestMapping(value = "form")
	public String form(TabAppUser tabAppUser, Model model) {
		model.addAttribute("tabAppUser", tabAppUser);
		return "modules/tab/tabAppUserForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("tab:tabAppUser:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TabAppUser tabAppUser) {
		if (tabAppUser.getIsNewRecord()) {
			tabAppUser.setCreatetime(new Date());
			tabAppUser.setLogincode(UserUtils.getUser().getLoginCode());
		}
		tabAppUserService.save(tabAppUser);
		return renderResult(Global.TRUE, text("保存APP用户成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("tab:tabAppUser:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TabAppUser tabAppUser) {
		tabAppUserService.delete(tabAppUser);
		return renderResult(Global.TRUE, text("删除APP用户成功！"));
	}
	
}