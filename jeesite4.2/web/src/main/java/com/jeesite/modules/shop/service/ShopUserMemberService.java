/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.shop.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.shop.entity.ShopUserMember;
import com.jeesite.modules.shop.dao.ShopUserMemberDao;

/**
 * 会员表Service
 * @author 高峰
 * @version 2021-02-16
 */
@Service
@Transactional(readOnly=true)
public class ShopUserMemberService extends CrudService<ShopUserMemberDao, ShopUserMember> {
	
	/**
	 * 获取单条数据
	 * @param shopUserMember
	 * @return
	 */
	@Override
	public ShopUserMember get(ShopUserMember shopUserMember) {
		return super.get(shopUserMember);
	}
	
	/**
	 * 查询分页数据
	 * @param shopUserMember 查询条件
	 * @param shopUserMember.page 分页对象
	 * @return
	 */
	@Override
	public Page<ShopUserMember> findPage(ShopUserMember shopUserMember) {
		return super.findPage(shopUserMember);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param shopUserMember
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(ShopUserMember shopUserMember) {
		super.save(shopUserMember);
	}
	
	/**
	 * 更新状态
	 * @param shopUserMember
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(ShopUserMember shopUserMember) {
		super.updateStatus(shopUserMember);
	}
	
	/**
	 * 删除数据
	 * @param shopUserMember
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(ShopUserMember shopUserMember) {
		super.delete(shopUserMember);
	}
	
}