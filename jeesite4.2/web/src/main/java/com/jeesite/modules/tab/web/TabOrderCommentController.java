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
import com.jeesite.modules.tab.entity.TabOrderComment;
import com.jeesite.modules.tab.service.TabOrderCommentService;

/**
 * tab_order_commentController
 * @author 高峰
 * @version 2021-02-19
 */
@Controller
@RequestMapping(value = "${adminPath}/tab/tabOrderComment")
public class TabOrderCommentController extends BaseController {

	@Autowired
	private TabOrderCommentService tabOrderCommentService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public TabOrderComment get(String rowid, boolean isNewRecord) {
		return tabOrderCommentService.get(rowid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("tab:tabOrderComment:view")
	@RequestMapping(value = {"list", ""})
	public String list(TabOrderComment tabOrderComment, Model model) {
		model.addAttribute("tabOrderComment", tabOrderComment);
		return "modules/tab/tabOrderCommentList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("tab:tabOrderComment:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<TabOrderComment> listData(TabOrderComment tabOrderComment, HttpServletRequest request, HttpServletResponse response) {
		tabOrderComment.setPage(new Page<>(request, response));
		Page<TabOrderComment> page = tabOrderCommentService.findPage(tabOrderComment);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("tab:tabOrderComment:view")
	@RequestMapping(value = "form")
	public String form(TabOrderComment tabOrderComment, Model model) {
		model.addAttribute("tabOrderComment", tabOrderComment);
		return "modules/tab/tabOrderCommentForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("tab:tabOrderComment:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated TabOrderComment tabOrderComment) {
		tabOrderCommentService.save(tabOrderComment);
		return renderResult(Global.TRUE, text("保存tab_order_comment成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("tab:tabOrderComment:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(TabOrderComment tabOrderComment) {
		tabOrderCommentService.delete(tabOrderComment);
		return renderResult(Global.TRUE, text("删除tab_order_comment成功！"));
	}
	
}