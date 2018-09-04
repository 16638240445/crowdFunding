package com.zhiyou100.crowdFunding.ServiceTest;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhiyou100.crowdFunding.service.IAdminService;
import com.zhiyou100.crowdFunding.vo.Admin;

import junit.framework.TestCase;

public class AdminTest {
	private Logger logger = Logger.getLogger(AdminTest.class);
	private static ApplicationContext context;
	private static IAdminService service;
	static {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = context.getBean("adminServiceImpl" , IAdminService.class);
	}
	@Test
	public void testAdd() throws Exception {
		Admin vo = new Admin();
		vo.setAdminName("张三");
		vo.setAdminPassword("a123456");
		vo.setGender("男");
		vo.setAdminAccountName("a123456");
		TestCase.assertTrue(service.add(vo));
		logger.info(vo);
	}
	
	@Test
	public void testEdit()throws Exception{
		Admin vo = new Admin();
		vo.setAdminId(1);
		vo.setAdminName("李老大");
		vo.setAdminPassword("a123456");
		vo.setGender("男");
		vo.setAdminAccountName("a123456");
		TestCase.assertTrue(service.edit(vo));
		logger.info(vo);
	}
	
	@Test
	public void testRemove() throws Exception{
		TestCase.assertTrue(service.remove(3));
	}
	
	@Test
	public void TestRemoveBatch() throws Exception{
		Set<Integer> ids = new HashSet<>();
		ids.add(4);
		TestCase.assertTrue(service.removeBatch(ids));
	}
	
	@Test
	public void testFindById() throws Exception{
		Admin vo = service.findById(1);
		TestCase.assertNotNull(vo);
		logger.info(vo);	
	}
	
	@Test
	public void testFindAll() throws Exception{	  
		Map<String,Object> map = new HashMap<>();
		int lineSize = 5;
		int currentPage=1; 
		map.put("lineSize", lineSize);
		map.put("start", (currentPage-1)*lineSize);
		List<Admin> list= service.findAll(map);
		TestCase.assertTrue(list.size()>0);
		logger.info(list);	
	}
	
	@Test
	public void testFindAllSplit() throws Exception{
		List<Admin> list = new ArrayList<>();
		Map<String,Object> map = new HashMap<>();
		int lineSize = 5;
		int currentPage=1; 
		map.put("column", "admin_name");
		map.put("keyword", "%李%");
		map.put("lineSize", lineSize);
		map.put("start", (currentPage-1)*lineSize);
		list = service.findAllSplit(map);
		TestCase.assertTrue(list.size()>0);
		logger.info(list);	
	}
	
	@Test
	public void testGetCount() throws Exception{
		Long l = service.getAllCount();
		TestCase.assertNotNull(l);
		logger.info(l);
	}
	
	@Test
	public void testGetAllCountSplit() throws Exception{
		Map<String,Object> map = new HashMap<>();
		int lineSize = 5;
		int currentPage=1; 
		map.put("column", "admin_name");
		map.put("keyword", "%李%");
		map.put("lineSize", lineSize);
		map.put("start", (currentPage-1)*lineSize);
		Long  l= service.getAllCountSplit(map);
		TestCase.assertNotNull(l);
		logger.info(l);
	}
	
	@Test 
	public void testFindByLogin() throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("adminAccountName", "a123456");
		map.put("adminPassword", "a123456");
		Admin vo = service.findByLogin(map);
		TestCase.assertNotNull(vo);
		logger.info(vo);
	}
	
	
	
}
