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
import com.jeesite.modules.tab.entity.TabAnquanyuan;
import com.jeesite.modules.tab.service.TabAnquanyuanService;

/**
 * tab_anquanyuanController
 * @author 高峰
 * @version 2020-09-30
 */
@Controller
@RequestMapping(value = "${adminPath}/tab/tabAnquanyuan")
public class TabAnquanyuanController extends BaseController {

	@Autowired
	private TabAnquanyuanService tabAnquanyuanService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TabAnquanyuan get(String rowid, boolean isNewRecord) {
		return tabAnquanyuanService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("tab:tabAnquanyuan:view")
	@RequestMapping(value = {"list", ""})
	public String list(TabAnquanyuan tabAnquanyuan, Model model) {
		model.addAttribute("tabAnquanyuan", tabAnquanyuan);
		return "modules/tab/tabAnquanyuanList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("tab:tabAnquanyuan:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TabAnquanyuan> listData(TabAnquanyuan tabAnquanyuan, HttpServletRequest request, HttpServletResponse response) {
		tabAnquanyuan.setPage(new Page<>(request, response));
		Page<TabAnquanyuan> page = tabAnquanyuanService.findPage(tabAnquanyuan);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("tab:tabAnquanyuan:view")
	@RequestMapping(value = "form")
	public String form(TabAnquanyuan tabAnquanyuan, Model model) {
		model.addAttribute("tabAnquanyuan", tabAnquanyuan);
		return "modules/tab/tabAnquanyuanForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("tab:tabAnquanyuan:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TabAnquanyuan tabAnquanyuan) {
		String  code =  UserUtils.getUser().getLoginCode();
		tabAnquanyuan.setLogincode(code);
		tabAnquanyuanService.save(tabAnquanyuan);
		return renderResult(Global.TRUE, text("保存tab_anquanyuan成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("tab:tabAnquanyuan:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TabAnquanyuan tabAnquanyuan) {
		tabAnquanyuanService.delete(tabAnquanyuan);
		return renderResult(Global.TRUE, text("删除tab_anquanyuan成功！"));
	}
	
}