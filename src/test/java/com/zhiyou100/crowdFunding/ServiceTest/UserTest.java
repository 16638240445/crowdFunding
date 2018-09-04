package com.zhiyou100.crowdFunding.ServiceTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhiyou100.crowdFunding.service.IUserService;
import com.zhiyou100.crowdFunding.vo.User;

import junit.framework.TestCase;

public class UserTest {
	private Logger logger = Logger.getLogger(UserTest.class);
	private static ApplicationContext context;
	private static IUserService service;
	static {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = context.getBean("userServiceImpl", IUserService.class);
	}

	@Test
	public void testAdd() throws Exception {
		User vo = new User();
		vo.setUsEmail("1107798500@qq.com");
		vo.setUsName("张三");
		vo.setUsPassword("123456");
		vo.setUsMoney(0);
		vo.setUsIdcard("41270219951004141X");
		vo.setUsPhone("16638240445");
		vo.setUsAddress("河南省郑州市经开区第六大街");
		vo.setUsRole(1);
		vo.setUsSex("男");
		vo.setUsCode("5642");
		vo.setUsCreateTime(new Date());
		vo.setUsUpdateTime(new Date());
		TestCase.assertTrue(service.add(vo));
		logger.info(vo);
	}

	@Test
	public void textEdit() throws Exception {
		User vo = new User();
		vo.setUsId(2);
		vo.setUsEmail("123456@qq.com");
		vo.setUsName("李四");
		vo.setUsPassword("123456");
		vo.setUsMoney(0);
		vo.setUsIdcard("412702199510041410");
		vo.setUsPhone("12345600000");
		vo.setUsAddress("河南省郑州市经开区第六大街");
		vo.setUsRole(1);
		vo.setUsSex("男");
		vo.setUsCode("5642");
		vo.setUsUpdateTime(new Date());
		TestCase.assertTrue(service.edit(vo));
		logger.info(vo);
	}

	@Test
	public void testRemove() throws Exception {
		TestCase.assertTrue(service.remove(4));
	}

	@Test
	public void testRemoveBatch() throws Exception {
		Set<Integer> ids = new HashSet<>();
		ids.add(3);
		TestCase.assertTrue(service.removeBatch(ids));
	}
	
	@Test
	public void testFindById() throws Exception{
		TestCase.assertNotNull(service.findById(1));
		logger.info(service.findById(1));
	}
	
	@Test 
	public void testFindAll() throws Exception{
		List<User> list = new ArrayList<>();
		Map<String,Object> map = new HashMap<>();
		int currentPage = 1;
		int lineSize = 5;
		map.put("lineSize", lineSize);
		map.put("start", (currentPage-1)*lineSize);
		list = service.findAll(map);
		TestCase.assertTrue(list.size()>0);
		logger.info(list);
		
	}
	
	@Test
	public void testFindAllSplit() throws Exception{
		List<User> list = new ArrayList<>();
		Map<String,Object> map = new HashMap<>();
		int currentPage = 1;
		int lineSize = 5;
		map.put("column", "us_name");
		map.put("keyword", "%张%");
		map.put("lineSize", lineSize);
		map.put("start", (currentPage-1)*lineSize);
		list = service.findAllSplit(map);
		TestCase.assertTrue(list.size()>0);
		logger.info(list);
	}
	
	@Test
	public void testGetAllCount() throws Exception{
		Long l = service.getAllCount();
		TestCase.assertNotNull(l);
		logger.info(l);
	}
	
	@Test
	public void getAllCountSplit() throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("column", "us_name");
		map.put("keyword", "%张%");
		Long l = service.getAllCountSplit(map);
		TestCase.assertNotNull(l);
		logger.info(l);
	}
	
	@Test
	public void findByLogin() throws Exception{
		Map<String,Object> map = new HashMap<>();
		map.put("usEmail", "16638240445");
		map.put("usPhone", "1107798500@qq.com");
		map.put("usPassword", "123456");
		User vo = service.findByLogin(map);
		TestCase.assertNotNull(vo);
		logger.info(vo);
	}
	
	@Test
	public void findByEmail() throws Exception{
		User vo =service.findByEmail("1107798500@qq.com");
		TestCase.assertNotNull(vo);
		logger.info(vo);
	}
}
