/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.tab.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.tab.entity.TabIndexConfig;
import com.jeesite.modules.tab.dao.TabIndexConfigDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * tab_index_configService
 * @author 高峰
 * @version 2020-12-23
 */
@Service
@Transactional(readOnly=true)
public class TabIndexConfigService extends CrudService<TabIndexConfigDao, TabIndexConfig> {
	
	/**
	 * 获取单条数据
	 * @param tabIndexConfig
	 * @return
	 */
	@Override
	public TabIndexConfig get(TabIndexConfig tabIndexConfig) {
		return super.get(tabIndexConfig);
	}
	
	/**
	 * 查询分页数据
	 * @param tabIndexConfig 查询条件
	 * @param tabIndexConfig.page 分页对象
	 * @return
	 */
	@Override
	public Page<TabIndexConfig> findPage(TabIndexConfig tabIndexConfig) {
		return super.findPage(tabIndexConfig);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param tabIndexConfig
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(TabIndexConfig tabIndexConfig) {
		super.save(tabIndexConfig);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(tabIndexConfig.getId(), "tabIndexConfig_image");
	}
	
	/**
	 * 更新状态
	 * @param tabIndexConfig
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(TabIndexConfig tabIndexConfig) {
		super.updateStatus(tabIndexConfig);
	}
	
	/**
	 * 删除数据
	 * @param tabIndexConfig
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(TabIndexConfig tabIndexConfig) {
		super.delete(tabIndexConfig);
	}
	
}