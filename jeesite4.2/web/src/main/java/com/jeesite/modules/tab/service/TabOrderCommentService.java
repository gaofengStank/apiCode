/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.tab.entity.TabOrderComment;
import com.jeesite.modules.tab.dao.TabOrderCommentDao;

/**
 * tab_order_commentService
 * @author 高峰
 * @version 2021-02-19
 */
@Service
@Transactional(readOnly=true)
public class TabOrderCommentService extends CrudService<TabOrderCommentDao, TabOrderComment> {
	
	/**
	 * 获取单条数据
	 * @param tabOrderComment
	 * @return
	 */
	@Override
	public TabOrderComment get(TabOrderComment tabOrderComment) {
		return super.get(tabOrderComment);
	}
	
	/**
	 * 查询分页数据
	 * @param tabOrderComment 查询条件
	 * @param tabOrderComment.page 分页对象
	 * @return
	 */
	@Override
	public Page<TabOrderComment> findPage(TabOrderComment tabOrderComment) {
		return super.findPage(tabOrderComment);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param tabOrderComment
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TabOrderComment tabOrderComment) {
		super.save(tabOrderComment);
	}
	
	/**
	 * 更新状态
	 * @param tabOrderComment
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TabOrderComment tabOrderComment) {
		super.updateStatus(tabOrderComment);
	}
	
	/**
	 * 删除数据
	 * @param tabOrderComment
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TabOrderComment tabOrderComment) {
		super.delete(tabOrderComment);
	}
	
}