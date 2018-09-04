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

import com.zhiyou100.crowdFunding.service.IRepayService;
import com.zhiyou100.crowdFunding.vo.Repay;

import junit.framework.TestCase;

public class RepayTest {
	private Logger logger = Logger.getLogger(RepayTest.class);
	private static ApplicationContext context;
	private static IRepayService service;
	static {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = context.getBean("repayServiceImpl", IRepayService.class);
	}

	@Test
	public void testAdd() throws Exception {
		Repay vo = new Repay();
		vo.setRyUsId(1);
		vo.setRyType(0);
		vo.setRyPaymoney(100);
		vo.setRyRule(0);
		vo.setRyContent("aaaaaaaaaaaaaaa");
		vo.setRyNumber(20);
		vo.setRyTime(1);
		vo.setRyPsId(1);
		vo.setRyCode("1235");
		vo.setRyPicUrl("aaaaaaaaaaaaaa");
		TestCase.assertTrue(service.add(vo));
		logger.info(vo);
	}

	@Test
	public void testEdit() throws Exception {
		Repay vo = new Repay();
		vo.setRyId(1);
		vo.setRyUsId(1);
		vo.setRyType(0);
		vo.setRyPaymoney(100);
		vo.setRyRule(0);
		vo.setRyContent("aaaaaaaaaaaaaaa");
		vo.setRyNumber(20);
		vo.setRyTime(30);
		vo.setRyPsId(1);
		vo.setRyCode("1235");
		vo.setRyPicUrl("aaaaaaaaaaaaaa");
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
	public void testFindById() throws Exception {
		TestCase.assertNotNull(service.findById(1));
		logger.info(service.findById(1));
	}

	@Test
	public void testFindAll() throws Exception {
		List<Repay> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		int currentPage = 1;
		int lineSize = 5;
		map.put("lineSize", lineSize);
		map.put("start", (currentPage - 1) * lineSize);
		list = service.findAll(map);
		TestCase.assertTrue(list.size() > 0);
		logger.info(list);

	}

	@Test
	public void testFindAllSplit() throws Exception {
		List<Repay> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		int currentPage = 1;
		int lineSize = 5;
//		map.put("column", "questionname");
//		map.put("keyword", "%°®ÐÄ%");
		map.put("lineSize", lineSize);
		map.put("start", (currentPage - 1) * lineSize);
		list = service.findAllSplit(map);
		TestCase.assertTrue(list.size() > 0);
		logger.info(list);
	}

	@Test
	public void testGetAllCount() throws Exception {
		Long l = service.getAllCount();
		TestCase.assertNotNull(l);
		logger.info(l);
	}

	@Test
	public void getAllCountSplit() throws Exception {
		Map<String, Object> map = new HashMap<>();
//		map.put("column", "questionname");
//		map.put("keyword", "%°®ÐÄ%");
		Long l = service.getAllCountSplit(map);
		TestCase.assertNotNull(l);
		logger.info(l);
	}
}
