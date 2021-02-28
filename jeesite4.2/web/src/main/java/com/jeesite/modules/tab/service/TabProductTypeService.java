/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.tab.entity.TabProductType;
import com.jeesite.modules.tab.dao.TabProductTypeDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * tab_product_typeService
 * @author 产品分类
 * @version 2020-12-24
 */
@Service
@Transactional(readOnly=true)
public class TabProductTypeService extends CrudService<TabProductTypeDao, TabProductType> {
	
	/**
	 * 获取单条数据
	 * @param tabProductType
	 * @return
	 */
	@Override
	public TabProductType get(TabProductType tabProductType) {
		return super.get(tabProductType);
	}
	
	/**
	 * 查询分页数据
	 * @param tabProductType 查询条件
	 * @param tabProductType.page 分页对象
	 * @return
	 */
	@Override
	public Page<TabProductType> findPage(TabProductType tabProductType) {
		return super.findPage(tabProductType);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param tabProductType
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TabProductType tabProductType) {
		super.save(tabProductType);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(tabProductType.getId(), "tabProductType_image");
	}
	
	/**
	 * 更新状态
	 * @param tabProductType
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TabProductType tabProductType) {
		super.updateStatus(tabProductType);
	}
	
	/**
	 * 删除数据
	 * @param tabProductType
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TabProductType tabProductType) {
		super.delete(tabProductType);
	}
	
}