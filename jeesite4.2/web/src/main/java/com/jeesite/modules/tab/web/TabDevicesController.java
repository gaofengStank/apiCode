/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.web;

import java.util.List;

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
import com.jeesite.modules.tab.entity.TabAppUser;
import com.jeesite.modules.tab.entity.TabDevices;
import com.jeesite.modules.tab.service.TabAppUserService;
import com.jeesite.modules.tab.service.TabDevicesService;

/**
 * 工人和锁扣配对Controller
 * @author 高峰
 * @version 2020-09-28
 */
@Controller
@RequestMapping(value = "${adminPath}/tab/tabDevices")
public class TabDevicesController extends BaseController {

	@Autowired
	private TabDevicesService tabDevicesService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TabDevices get(String rowid, boolean isNewRecord) {
		return tabDevicesService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("tab:tabDevices:view")
	@RequestMapping(value = {"list", ""})
	public String list(TabDevices tabDevices, Model model) {
		model.addAttribute("tabDevices", tabDevices);
		return "modules/tab/tabDevicesList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("tab:tabDevices:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TabDevices> listData(TabDevices tabDevices, HttpServletRequest request, HttpServletResponse response) {
		tabDevices.setPage(new Page<>(request, response));
		
		String  code =  UserUtils.getUser().getLoginCode();
		tabDevices.setLogincode(code);
		
		Page<TabDevices> page = tabDevicesService.findPage(tabDevices);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("tab:tabDevices:view")
	@RequestMapping(value = "form")
	public String form(TabDevices tabDevices, Model model) {
		model.addAttribute("tabDevices", tabDevices);
		TabAppUser arg0  =  new TabAppUser();
		arg0.setLogincode(UserUtils.getUser().getLoginCode());
		List<TabAppUser> tabAppUsers =  tabAppUserService.findList(arg0  );
		model.addAttribute("tabAppUsers", tabAppUsers);

		return "modules/tab/tabDevicesForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("tab:tabDevices:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TabDevices tabDevices) {
		String  code =  UserUtils.getUser().getLoginCode();
		tabDevices.setLogincode(code);
		tabDevicesService.save(tabDevices);
		return renderResult(Global.TRUE, text("保存工人和锁扣配对成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("tab:tabDevices:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TabDevices tabDevices) {
		tabDevicesService.delete(tabDevices);
		return renderResult(Global.TRUE, text("删除工人和锁扣配对成功！"));
	}
	@Autowired
	private TabAppUserService tabAppUserService ;
	
}