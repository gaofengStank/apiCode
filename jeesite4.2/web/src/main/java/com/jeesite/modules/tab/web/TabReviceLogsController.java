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
import com.jeesite.modules.tab.entity.TabReviceLogs;
import com.jeesite.modules.tab.service.TabReviceLogsService;

/**
 * tab_revice_logsController
 * @author 高峰
 * @version 2020-09-30
 */
@Controller
@RequestMapping(value = "${adminPath}/tab/tabReviceLogs")
public class TabReviceLogsController extends BaseController {

	@Autowired
	private TabReviceLogsService tabReviceLogsService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TabReviceLogs get(String rowid, boolean isNewRecord) {
		return tabReviceLogsService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("tab:tabReviceLogs:view")
	@RequestMapping(value = {"list", ""})
	public String list(TabReviceLogs tabReviceLogs, Model model) {
		model.addAttribute("tabReviceLogs", tabReviceLogs);
		return "modules/tab/tabReviceLogsList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("tab:tabReviceLogs:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TabReviceLogs> listData(TabReviceLogs tabReviceLogs, HttpServletRequest request, HttpServletResponse response) {
		tabReviceLogs.setPage(new Page<>(request, response));
		String  code =  UserUtils.getUser().getLoginCode();
		tabReviceLogs.setLogincode(code);
		Page<TabReviceLogs> page = tabReviceLogsService.findPage(tabReviceLogs);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("tab:tabReviceLogs:view")
	@RequestMapping(value = "form")
	public String form(TabReviceLogs tabReviceLogs, Model model) {
		String  code =  UserUtils.getUser().getLoginCode();
		tabReviceLogs.setLogincode(code);
		model.addAttribute("tabReviceLogs", tabReviceLogs);
		return "modules/tab/tabReviceLogsForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("tab:tabReviceLogs:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TabReviceLogs tabReviceLogs) {
		String  code =  UserUtils.getUser().getLoginCode();
		tabReviceLogs.setLogincode(code);
		tabReviceLogsService.save(tabReviceLogs);
		return renderResult(Global.TRUE, text("保存tab_revice_logs成功！"));
	}
	
}