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
import com.jeesite.modules.tab.entity.TabAqdWaringLog;
import com.jeesite.modules.tab.service.TabAqdWaringLogService;

/**
 * 报警日志Controller
 * @author 高峰
 * @version 2020-09-30
 */
@Controller
@RequestMapping(value = "${adminPath}/tab/tabAqdWaringLog")
public class TabAqdWaringLogController extends BaseController {

	@Autowired
	private TabAqdWaringLogService tabAqdWaringLogService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TabAqdWaringLog get(String rowid, boolean isNewRecord) {
		return tabAqdWaringLogService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("tab:tabAqdWaringLog:view")
	@RequestMapping(value = {"list", ""})
	public String list(TabAqdWaringLog tabAqdWaringLog, Model model) {
		model.addAttribute("tabAqdWaringLog", tabAqdWaringLog);
		return "modules/tab/tabAqdWaringLogList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("tab:tabAqdWaringLog:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TabAqdWaringLog> listData(TabAqdWaringLog tabAqdWaringLog, HttpServletRequest request, HttpServletResponse response) {
		tabAqdWaringLog.setPage(new Page<>(request, response));
		String  code =  UserUtils.getUser().getLoginCode();
		tabAqdWaringLog.setLogincode(code);
		Page<TabAqdWaringLog> page = tabAqdWaringLogService.findPage(tabAqdWaringLog);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("tab:tabAqdWaringLog:view")
	@RequestMapping(value = "form")
	public String form(TabAqdWaringLog tabAqdWaringLog, Model model) {
		model.addAttribute("tabAqdWaringLog", tabAqdWaringLog);
		return "modules/tab/tabAqdWaringLogForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("tab:tabAqdWaringLog:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TabAqdWaringLog tabAqdWaringLog) {
		String  code =  UserUtils.getUser().getLoginCode();
		tabAqdWaringLog.setLogincode(code);
		tabAqdWaringLogService.save(tabAqdWaringLog);
		return renderResult(Global.TRUE, text("保存报警日志成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("tab:tabAqdWaringLog:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TabAqdWaringLog tabAqdWaringLog) {
		tabAqdWaringLogService.delete(tabAqdWaringLog);
		return renderResult(Global.TRUE, text("删除报警日志成功！"));
	}
	
}