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

import com.zhiyou100.crowdFunding.service.IProjectsService;
import com.zhiyou100.crowdFunding.vo.Projects;

import junit.framework.TestCase;

public class ProjectsTest {
	private Logger logger = Logger.getLogger(ProjectsTest.class);
	private static ApplicationContext context;
	private static IProjectsService service;
	static {
		context = new ClassPathXmlApplicationContext("applicationContext.xml");
		service = context.getBean("projectsServiceImpl", IProjectsService.class);
	}

	@Test
	public void testAdd() throws Exception {
		Projects vo = new Projects();
		vo.setPsUsId(1);
		vo.setPsCustName("赵四");
		vo.setPsCustPhone("16638240441");
		vo.setPsCustAddress("河南省郑州市分部");
		vo.setPsPstId(1);
		
		TestCase.assertTrue(service.add(vo));
		logger.info(vo);
	}

	@Test
	public void testEdit() throws Exception {
		Projects vo = new Projects();
		vo.setPsId(1);
		vo.setPsUsId(1);
		vo.setPsCustName("赵六");
		vo.setPsCustPhone("16638240441");
		vo.setPsCustAddress("河南省郑州市分部");
		vo.setPsPstId(1);
		vo.setPsFile("aaaaaaa");
		vo.setPsName("aaaaaa");
		vo.setPsGoal("aaaaaaaaa");
		vo.setPsAddress("aaaaaaaaa");
		vo.setPsMoney(10000.0);
		vo.setPsDays(30);
		vo.setPsVideo("aaaaaaaaa");
		vo.setPsStory("aaaaaa");
		vo.setPsSupport("aaaaaaa");
		vo.setPsRepay("aaaaaaaaaaa");
		vo.setPsAboutme("aaaaaaa");
		vo.setPsType(0);
		vo.setPsStarttime(new Date());
		vo.setPsEndtime(new Date());
		vo.setPsGetmoney(5000.0);
		vo.setPsGetpeople(1000);
		vo.setPsAuditor(1);
		TestCase.assertTrue(service.edit(vo));
		logger.info(vo);
	}

	@Test
	public void testRemove() throws Exception {
		TestCase.assertTrue(service.remove(3));
	}

	@Test
	public void testRemoveBatch() throws Exception {
		Set<Integer> ids = new HashSet<>();
		ids.add(4);
		TestCase.assertTrue(service.removeBatch(ids));
	}

	@Test
	public void testFindById() throws Exception {
		TestCase.assertNotNull(service.findById(2));
		logger.info(service.findById(2));
	}

	@Test
	public void testFindAll() throws Exception {
		Map<String, Object> map = new HashMap<>();
		int currentPage = 1;
		int lineSize = 5;
		map.put("lineSize", lineSize);
		map.put("start", (currentPage - 1) * lineSize);
		List<Projects> list = service.findAll(map);
		TestCase.assertTrue(list.size() > 0);
		logger.info(list);

	}

	@Test
	public void testFindAllSplit() throws Exception {
		List<Projects> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		int currentPage = 1;
		int lineSize = 5;
		map.put("column", "ps_name");
		map.put("keyword", "aaaaaa");
		map.put("lineSize", lineSize);
		map.put("start", (currentPage - 1) * lineSize);
		list = service.findAllSplit(map);
		TestCase.assertTrue(list.size() > 0);
		logger.info(list);
		logger.info(list.size());
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
		String psName ="aaaaaa";
		String psType ="";
		String pstName ="";
		String usName ="林鹏";
		map.put("psName", "%"+psName+"%");
		map.put("psType", "%"+psType+"%");
		map.put("pstName", "%"+pstName+"%");
		map.put("usName", "%"+usName+"%");
		Long l = service.getAllCountSplit(map);
		TestCase.assertNotNull(l);
		logger.info(l);
	}
	
	@Test
	public void testEditReview() throws Exception {
		Projects vo = new Projects();
		vo.setPsId(2);
		vo.setPsType(1);
		vo.setPsStarttime(new Date());
		vo.setPsEndtime(new Date());
		vo.setPsAuditor(1);
		TestCase.assertTrue(service.doUpdateByReview(vo));
		logger.info(vo);
	}
	
	@Test
	public void findByEmail() throws Exception{
		List<Projects> list = service.findByEmail("1107798500@qq.com");
		TestCase.assertTrue(list.size()>0);
		logger.info(list);
	}
	
	@Test
	public void findByType() throws Exception{
		List<Projects> list = service.findByType("16638240445");
		TestCase.assertTrue(list.size()>0);
		logger.info(list);
	}
	@Test
	public void findByTrem() throws Exception{
		List<Projects> list = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		int currentPage = 1;
		int lineSize = 5;
		String psName ="aaaaaa";
		String psType ="";
		String pstName ="";
		String usName ="林鹏";
		map.put("psName", "%"+psName+"%");
		map.put("psType", "%"+psType+"%");
		map.put("pstName", "%"+pstName+"%");
		map.put("usName", "%"+usName+"%");
		map.put("lineSize", lineSize);
		map.put("start", (currentPage - 1) * lineSize);
		list = service.findByTerm(map);
		TestCase.assertTrue(list.size() > 0);
		logger.info(list);
		logger.info(list.size());
	}
	
	@Test
	public void  getCountByReview() throws Exception{
		Long l =  service.getCountByReview();
		TestCase.assertNotNull(l);
		logger.info(l);
	}
	
}
