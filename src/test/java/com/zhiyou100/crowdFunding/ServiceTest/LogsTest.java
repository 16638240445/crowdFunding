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

import com.zhiyou100.crowdFunding.service.ILogsService;
import com.zhiyou100.crowdFunding.vo.Logs;

import junit.framework.TestCase;

public class LogsTest {
	private Logger logger = Logger.getLogger(LogsTest.class);
	private static ApplicationContext context;
	private static ILogsService service;
	static {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = context.getBean("logsServiceImpl", ILogsService.class);
	}

	@Test
	public void testAdd() throws Exception {
		Logs vo = new Logs();
		vo.setLogUsId(1);
		vo.setLogContent("aaaaaaaaaaaaaaaa");
		TestCase.assertTrue(service.add(vo));
		logger.info(vo);
	}

	@Test
	public void testEdit() throws Exception {
		Logs vo = new Logs();
		vo.setLogId(1);
		vo.setLogUsId(1);
		vo.setLogContent("bbbbbbbbbbbbbbbbb");
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
		List<Logs> list = new ArrayList<>();
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
		List<Logs> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		int currentPage = 1;
		int lineSize = 5;
		// map.put("column", "pst_name");
		// map.put("keyword", "%Öú%");
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
		// map.put("column", "pst_name");
		// map.put("keyword", "%Öú%");
		Long l = service.getAllCountSplit(map);
		TestCase.assertNotNull(l);
		logger.info(l);
	}
}
