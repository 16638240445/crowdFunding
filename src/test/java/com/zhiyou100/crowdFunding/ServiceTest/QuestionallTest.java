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

import com.zhiyou100.crowdFunding.service.IQuestionallService;
import com.zhiyou100.crowdFunding.vo.Questionall;
import com.zhiyou100.crowdFunding.vo.Questionother;

import junit.framework.TestCase;

public class QuestionallTest {
	private Logger logger = Logger.getLogger(QuestionallTest.class);
	private static ApplicationContext context;
	private static IQuestionallService service;
	static {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = context.getBean("questionallServiceImpl", IQuestionallService.class);
	}

	@Test
	public void testAdd() throws Exception {
		Questionall vo = new Questionall();
		vo.setQuestionname("公益众筹");
		TestCase.assertTrue(service.add(vo));
		logger.info(vo);
	}

	@Test
	public void testEdit() throws Exception {
		Questionall vo = new Questionall();
		vo.setQuestionid(3);
		vo.setQuestionname("众筹日期");
		TestCase.assertTrue(service.edit(vo));
		logger.info(vo);
	}

	@Test
	public void testRemove() throws Exception {
		TestCase.assertTrue(service.remove(5));
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
		List<Questionall> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		int currentPage = 1;
		int lineSize = 5;
		map.put("lineSize", lineSize);
		map.put("start", (currentPage - 1) * lineSize);
		list = service.findAll();
		TestCase.assertTrue(list.size() > 0);
		logger.info(list);
	}
	
	@Test
	public void findAll() throws Exception {
		List<Questionall> list = new ArrayList<>();
		list = service.findAll();
		TestCase.assertTrue(list.size() > 0);
		logger.info(list);
	}

	@Test
	public void testFindAllSplit() throws Exception {
		List<Questionall> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		int currentPage = 1;
		int lineSize = 5;
		map.put("column", "questionname");
		map.put("keyword", "%爱心%");
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
		map.put("column", "questionname");
		map.put("keyword", "%爱心%");
		Long l = service.getAllCountSplit(map);
		TestCase.assertNotNull(l);
		logger.info(l);
	}

}
