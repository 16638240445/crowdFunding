package com.zhiyou100.crowdFunding.ServiceTest;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhiyou100.crowdFunding.service.IRegionService;
import com.zhiyou100.crowdFunding.vo.Region;

import junit.framework.TestCase;

public class RegionTest {
	private Logger logger = Logger.getLogger(Region.class);
	private static ApplicationContext context;
	private static IRegionService service;
	static {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = context.getBean("regionServiceImpl", IRegionService.class);
	}
	
	@Test
	public void testFindProvince() throws Exception{
		List<Region> list = new ArrayList<>();
		list= service.findAllProvince();
		TestCase.assertTrue(list.size()>0);
		logger.info(list);
	}
	
	@Test
	public void testFindProvinceCity() throws Exception{
		List<Region> list = new ArrayList<>();
		list= service.findProvinceCity(17);
		TestCase.assertTrue(list.size()>0);
		logger.info(list);
	}
	
}
