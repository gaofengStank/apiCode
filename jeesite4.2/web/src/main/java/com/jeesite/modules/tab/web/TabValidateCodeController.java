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
import com.jeesite.modules.tab.entity.TabValidateCode;
import com.jeesite.modules.tab.service.TabValidateCodeService;

/**
 * tab_validate_codeController
 * @author 高峰
 * @version 2021-02-20
 */
@Controller
@RequestMapping(value = "${adminPath}/tab/tabValidateCode")
public class TabValidateCodeController extends BaseController {

	@Autowired
	private TabValidateCodeService tabValidateCodeService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TabValidateCode get(String id, boolean isNewRecord) {
		return tabValidateCodeService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("tab:tabValidateCode:view")
	@RequestMapping(value = {"list", ""})
	public String list(TabValidateCode tabValidateCode, Model model) {
		model.addAttribute("tabValidateCode", tabValidateCode);
		return "modules/tab/tabValidateCodeList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("tab:tabValidateCode:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TabValidateCode> listData(TabValidateCode tabValidateCode, HttpServletRequest request, HttpServletResponse response) {
		tabValidateCode.setPage(new Page<>(request, response));
		Page<TabValidateCode> page = tabValidateCodeService.findPage(tabValidateCode);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("tab:tabValidateCode:view")
	@RequestMapping(value = "form")
	public String form(TabValidateCode tabValidateCode, Model model) {
		model.addAttribute("tabValidateCode", tabValidateCode);
		return "modules/tab/tabValidateCodeForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("tab:tabValidateCode:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TabValidateCode tabValidateCode) {
		tabValidateCodeService.save(tabValidateCode);
		return renderResult(Global.TRUE, text("保存tab_validate_code成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("tab:tabValidateCode:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TabValidateCode tabValidateCode) {
		tabValidateCodeService.delete(tabValidateCode);
		return renderResult(Global.TRUE, text("删除tab_validate_code成功！"));
	}
	
}