/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.shop.web;

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
import com.jeesite.modules.shop.entity.ShopUserMember;
import com.jeesite.modules.shop.service.ShopUserMemberService;

/**
 * 会员表Controller
 * @author 高峰
 * @version 2021-02-16
 */
@Controller
@RequestMapping(value = "${adminPath}/shop/shopUserMember")
public class ShopUserMemberController extends BaseController {

	@Autowired
	private ShopUserMemberService shopUserMemberService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public ShopUserMember get(String uid, boolean isNewRecord) {
		return shopUserMemberService.get(uid, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("shop:shopUserMember:view")
	@RequestMapping(value = {"list", ""})
	public String list(ShopUserMember shopUserMember, Model model) {
		model.addAttribute("shopUserMember", shopUserMember);
		return "modules/shop/shopUserMemberList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("shop:shopUserMember:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<ShopUserMember> listData(ShopUserMember shopUserMember, HttpServletRequest request, HttpServletResponse response) {
		shopUserMember.setPage(new Page<>(request, response));
		Page<ShopUserMember> page = shopUserMemberService.findPage(shopUserMember);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("shop:shopUserMember:view")
	@RequestMapping(value = "form")
	public String form(ShopUserMember shopUserMember, Model model) {
		model.addAttribute("shopUserMember", shopUserMember);
		return "modules/shop/shopUserMemberForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("shop:shopUserMember:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated ShopUserMember shopUserMember) {
		shopUserMemberService.save(shopUserMember);
		return renderResult(Global.TRUE, text("保存会员表成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("shop:shopUserMember:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(ShopUserMember shopUserMember) {
		shopUserMemberService.delete(shopUserMember);
		return renderResult(Global.TRUE, text("删除会员表成功！"));
	}
	
}