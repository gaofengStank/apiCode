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
import com.jeesite.modules.tab.entity.TabPachongData;
import com.jeesite.modules.tab.service.TabPachongDataService;

/**
 * tab_pachong_dataController
 * @author 高峰
 * @version 2020-10-02
 */
@Controller
@RequestMapping(value = "${adminPath}/tab/tabPachongData")
public class TabPachongDataController extends BaseController {

	@Autowired
	private TabPachongDataService tabPachongDataService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TabPachongData get(String rowid, boolean isNewRecord) {
		return tabPachongDataService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("tab:tabPachongData:view")
	@RequestMapping(value = {"list", ""})
	public String list(TabPachongData tabPachongData, Model model) {
		model.addAttribute("tabPachongData", tabPachongData);
		return "modules/tab/tabPachongDataList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("tab:tabPachongData:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TabPachongData> listData(TabPachongData tabPachongData, HttpServletRequest request, HttpServletResponse response) {
		tabPachongData.setPage(new Page<>(request, response));
		Page<TabPachongData> page = tabPachongDataService.findPage(tabPachongData);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("tab:tabPachongData:view")
	@RequestMapping(value = "form")
	public String form(TabPachongData tabPachongData, Model model) {
		model.addAttribute("tabPachongData", tabPachongData);
		return "modules/tab/tabPachongDataForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("tab:tabPachongData:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TabPachongData tabPachongData) {
		tabPachongDataService.save(tabPachongData);
		return renderResult(Global.TRUE, text("保存tab_pachong_data成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("tab:tabPachongData:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TabPachongData tabPachongData) {
		tabPachongDataService.delete(tabPachongData);
		return renderResult(Global.TRUE, text("删除tab_pachong_data成功！"));
	}
	
}