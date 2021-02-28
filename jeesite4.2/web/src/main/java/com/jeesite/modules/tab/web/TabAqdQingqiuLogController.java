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
import com.jeesite.modules.tab.entity.TabAqdQingqiuLog;
import com.jeesite.modules.tab.service.TabAqdQingqiuLogService;

/**
 * 报警日志Controller
 * @author 高峰
 * @version 2020-09-30
 */
@Controller
@RequestMapping(value = "${adminPath}/tab/tabAqdQingqiuLog")
public class TabAqdQingqiuLogController extends BaseController {

	@Autowired
	private TabAqdQingqiuLogService tabAqdQingqiuLogService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TabAqdQingqiuLog get(String rowid, boolean isNewRecord) {
		return tabAqdQingqiuLogService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("tab:tabAqdQingqiuLog:view")
	@RequestMapping(value = {"list", ""})
	public String list(TabAqdQingqiuLog tabAqdQingqiuLog, Model model) {
		model.addAttribute("tabAqdQingqiuLog", tabAqdQingqiuLog);
		return "modules/tab/tabAqdQingqiuLogList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("tab:tabAqdQingqiuLog:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TabAqdQingqiuLog> listData(TabAqdQingqiuLog tabAqdQingqiuLog, HttpServletRequest request, HttpServletResponse response) {
		tabAqdQingqiuLog.setPage(new Page<>(request, response));
		String  code =  UserUtils.getUser().getLoginCode();
		tabAqdQingqiuLog.setLogincode(code);
		Page<TabAqdQingqiuLog> page = tabAqdQingqiuLogService.findPage(tabAqdQingqiuLog);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("tab:tabAqdQingqiuLog:view")
	@RequestMapping(value = "form")
	public String form(TabAqdQingqiuLog tabAqdQingqiuLog, Model model) {
		model.addAttribute("tabAqdQingqiuLog", tabAqdQingqiuLog);
		return "modules/tab/tabAqdQingqiuLogForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("tab:tabAqdQingqiuLog:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TabAqdQingqiuLog tabAqdQingqiuLog) {
		String  code =  UserUtils.getUser().getLoginCode();
		tabAqdQingqiuLog.setLogincode(code);
		tabAqdQingqiuLogService.save(tabAqdQingqiuLog);
		return renderResult(Global.TRUE, text("保存报警日志成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("tab:tabAqdQingqiuLog:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TabAqdQingqiuLog tabAqdQingqiuLog) {
		tabAqdQingqiuLogService.delete(tabAqdQingqiuLog);
		return renderResult(Global.TRUE, text("删除报警日志成功！"));
	}
	
}