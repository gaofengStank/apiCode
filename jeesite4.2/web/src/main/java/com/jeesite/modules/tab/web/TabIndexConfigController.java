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
import com.jeesite.modules.tab.entity.TabIndexConfig;
import com.jeesite.modules.tab.service.TabIndexConfigService;

/**
 * tab_index_configController
 * @author 高峰
 * @version 2020-12-23
 */
@Controller
@RequestMapping(value = "${adminPath}/tab/tabIndexConfig")
public class TabIndexConfigController extends BaseController {

	@Autowired
	private TabIndexConfigService tabIndexConfigService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TabIndexConfig get(String rowid, boolean isNewRecord) {
		return tabIndexConfigService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("tab:tabIndexConfig:view")
	@RequestMapping(value = {"list", ""})
	public String list(TabIndexConfig tabIndexConfig, Model model) {
		model.addAttribute("tabIndexConfig", tabIndexConfig);
		return "modules/tab/tabIndexConfigList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("tab:tabIndexConfig:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TabIndexConfig> listData(TabIndexConfig tabIndexConfig, HttpServletRequest request, HttpServletResponse response) {
		tabIndexConfig.setPage(new Page<>(request, response));
		Page<TabIndexConfig> page = tabIndexConfigService.findPage(tabIndexConfig);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("tab:tabIndexConfig:view")
	@RequestMapping(value = "form")
	public String form(TabIndexConfig tabIndexConfig, Model model) {
		model.addAttribute("tabIndexConfig", tabIndexConfig);
		return "modules/tab/tabIndexConfigForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("tab:tabIndexConfig:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TabIndexConfig tabIndexConfig) {
		tabIndexConfigService.save(tabIndexConfig);
		return renderResult(Global.TRUE, text("保存tab_index_config成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("tab:tabIndexConfig:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TabIndexConfig tabIndexConfig) {
		tabIndexConfigService.delete(tabIndexConfig);
		return renderResult(Global.TRUE, text("删除tab_index_config成功！"));
	}
	
}