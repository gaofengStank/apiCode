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
import com.jeesite.modules.tab.entity.TabOrderList;
import com.jeesite.modules.tab.service.TabOrderListService;

/**
 * tab_order_listController
 * @author 高峰
 * @version 2021-02-16
 */
@Controller
@RequestMapping(value = "${adminPath}/tab/tabOrderList")
public class TabOrderListController extends BaseController {

	@Autowired
	private TabOrderListService tabOrderListService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TabOrderList get(String rowid, boolean isNewRecord) {
		return tabOrderListService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("tab:tabOrderList:view")
	@RequestMapping(value = {"list", ""})
	public String list(TabOrderList tabOrderList, Model model) {
		model.addAttribute("tabOrderList", tabOrderList);
		return "modules/tab/tabOrderListList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("tab:tabOrderList:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TabOrderList> listData(TabOrderList tabOrderList, HttpServletRequest request, HttpServletResponse response) {
		tabOrderList.setPage(new Page<>(request, response));
		Page<TabOrderList> page = tabOrderListService.findPage(tabOrderList);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("tab:tabOrderList:view")
	@RequestMapping(value = "form")
	public String form(TabOrderList tabOrderList, Model model) {
		model.addAttribute("tabOrderList", tabOrderList);
		return "modules/tab/tabOrderListForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("tab:tabOrderList:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TabOrderList tabOrderList) {
		tabOrderListService.save(tabOrderList);
		return renderResult(Global.TRUE, text("保存tab_order_list成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("tab:tabOrderList:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TabOrderList tabOrderList) {
		tabOrderListService.delete(tabOrderList);
		return renderResult(Global.TRUE, text("删除tab_order_list成功！"));
	}
	
}