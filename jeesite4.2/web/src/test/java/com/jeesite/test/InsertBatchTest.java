/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.jeesite.common.callback.MethodCallback;
import com.jeesite.common.collect.ListUtils;
import com.jeesite.common.tests.BaseSpringContextTests;
import com.jeesite.modules.Application;
import com.jeesite.modules.test.dao.TestDataDao;
import com.jeesite.modules.test.entity.TestData;

/**
 * 批量插入测试
 * @author ThinkGem
 * @version 2019年10月28日
 */
@ActiveProfiles("test")
@SpringBootTest(classes=Application.class)
public class InsertBatchTest extends BaseSpringContextTests { }
