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
import com.jeesite.modules.tab.entity.TabWarningLog;
import com.jeesite.modules.tab.service.TabWarningLogService;

/**
 * tab_warning_logController
 * @author 高峰
 * @version 2020-09-27
 */
@Controller
@RequestMapping(value = "${adminPath}/tab/tabWarningLog")
public class TabWarningLogController extends BaseController {

	@Autowired
	private TabWarningLogService tabWarningLogService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TabWarningLog get(String rowid, boolean isNewRecord) {
		return tabWarningLogService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("tab:tabWarningLog:view")
	@RequestMapping(value = {"list", ""})
	public String list(TabWarningLog tabWarningLog, Model model) {
		model.addAttribute("tabWarningLog", tabWarningLog);
		return "modules/tab/tabWarningLogList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("tab:tabWarningLog:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TabWarningLog> listData(TabWarningLog tabWarningLog, HttpServletRequest request, HttpServletResponse response) {
		tabWarningLog.setPage(new Page<>(request, response));
		String  code =  UserUtils.getUser().getLoginCode();
		tabWarningLog.setLogincode(code);
		Page<TabWarningLog> page = tabWarningLogService.findPage(tabWarningLog);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("tab:tabWarningLog:view")
	@RequestMapping(value = "form")
	public String form(TabWarningLog tabWarningLog, Model model) {
		model.addAttribute("tabWarningLog", tabWarningLog);
		return "modules/tab/tabWarningLogForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("tab:tabWarningLog:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TabWarningLog tabWarningLog) {
		String  code =  UserUtils.getUser().getLoginCode();
		tabWarningLog.setLogincode(code);
		tabWarningLogService.save(tabWarningLog);
		return renderResult(Global.TRUE, text("保存tab_warning_log成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("tab:tabWarningLog:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TabWarningLog tabWarningLog) {
		tabWarningLogService.delete(tabWarningLog);
		return renderResult(Global.TRUE, text("删除tab_warning_log成功！"));
	}
	
}