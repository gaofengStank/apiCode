/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.test;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.jeesite.common.collect.ListUtils;
import com.jeesite.common.idgen.IdGen;
import com.jeesite.common.tests.BaseSpringContextTests;
import com.jeesite.modules.Application;
import com.jeesite.modules.test.entity.TestData;
import com.jeesite.modules.test.entity.TestDataChild;
import com.jeesite.modules.test.service.TestDataService;

/**
 * 多数据源并发测试<br>
 * 1、将 TestDataChildDao 的数据源设置为 ds2<br>
 * 2、将 TestDataChild 的表名设置为 test_data_child2<br>
 * 3、配置 ds2 数据源，并创建 test_data_child2 表
 * @author ThinkGem
 * @version 2019-6-26
 */
@ActiveProfiles("test")
@SpringBootTest(classes=Application.class)
public class MultiDataSourceTest extends BaseSpringContextTests { }
