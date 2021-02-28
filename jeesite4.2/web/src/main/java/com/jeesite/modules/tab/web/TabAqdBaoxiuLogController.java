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
import com.jeesite.modules.tab.entity.TabAqdBaoxiuLog;
import com.jeesite.modules.tab.service.TabAqdBaoxiuLogService;

/**
 * 报警日志Controller
 * @author 高峰
 * @version 2020-09-30
 */
@Controller
@RequestMapping(value = "${adminPath}/tab/tabAqdBaoxiuLog")
public class TabAqdBaoxiuLogController extends BaseController {

	@Autowired
	private TabAqdBaoxiuLogService tabAqdBaoxiuLogService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TabAqdBaoxiuLog get(String rowid, boolean isNewRecord) {
		return tabAqdBaoxiuLogService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("tab:tabAqdBaoxiuLog:view")
	@RequestMapping(value = {"list", ""})
	public String list(TabAqdBaoxiuLog tabAqdBaoxiuLog, Model model) {
		model.addAttribute("tabAqdBaoxiuLog", tabAqdBaoxiuLog);
		return "modules/tab/tabAqdBaoxiuLogList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("tab:tabAqdBaoxiuLog:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TabAqdBaoxiuLog> listData(TabAqdBaoxiuLog tabAqdBaoxiuLog, HttpServletRequest request, HttpServletResponse response) {
		tabAqdBaoxiuLog.setPage(new Page<>(request, response));
		String  code =  UserUtils.getUser().getLoginCode();
		tabAqdBaoxiuLog.setLogincode(code);
		Page<TabAqdBaoxiuLog> page = tabAqdBaoxiuLogService.findPage(tabAqdBaoxiuLog);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("tab:tabAqdBaoxiuLog:view")
	@RequestMapping(value = "form")
	public String form(TabAqdBaoxiuLog tabAqdBaoxiuLog, Model model) {
		model.addAttribute("tabAqdBaoxiuLog", tabAqdBaoxiuLog);
		return "modules/tab/tabAqdBaoxiuLogForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("tab:tabAqdBaoxiuLog:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TabAqdBaoxiuLog tabAqdBaoxiuLog) {
		String  code =  UserUtils.getUser().getLoginCode();
		tabAqdBaoxiuLog.setLogincode(code);
		tabAqdBaoxiuLogService.save(tabAqdBaoxiuLog);
		return renderResult(Global.TRUE, text("保存报警日志成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("tab:tabAqdBaoxiuLog:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TabAqdBaoxiuLog tabAqdBaoxiuLog) {
		tabAqdBaoxiuLogService.delete(tabAqdBaoxiuLog);
		return renderResult(Global.TRUE, text("删除报警日志成功！"));
	}
	
}