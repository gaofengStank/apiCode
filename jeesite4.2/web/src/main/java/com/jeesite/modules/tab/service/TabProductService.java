/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.tab.entity.TabProduct;
import com.jeesite.modules.tab.dao.TabProductDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * tab_productService
 * @author 高峰
 * @version 2020-12-24
 */
@Service
@Transactional(readOnly=true)
public class TabProductService extends CrudService<TabProductDao, TabProduct> {
	
	/**
	 * 获取单条数据
	 * @param tabProduct
	 * @return
	 */
	@Override
	public TabProduct get(TabProduct tabProduct) {
		return super.get(tabProduct);
	}
	
	/**
	 * 查询分页数据
	 * @param tabProduct 查询条件
	 * @param tabProduct.page 分页对象
	 * @return
	 */
	@Override
	public Page<TabProduct> findPage(TabProduct tabProduct) {
		return super.findPage(tabProduct);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param tabProduct
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TabProduct tabProduct) {
		super.save(tabProduct);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(tabProduct.getId(), "tabProduct_image");
	}
	
	/**
	 * 更新状态
	 * @param tabProduct
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TabProduct tabProduct) {
		super.updateStatus(tabProduct);
	}
	
	/**
	 * 删除数据
	 * @param tabProduct
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TabProduct tabProduct) {
		super.delete(tabProduct);
	}
	
}