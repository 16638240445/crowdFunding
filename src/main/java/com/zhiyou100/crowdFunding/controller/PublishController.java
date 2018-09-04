package com.zhiyou100.crowdFunding.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.crowdFunding.service.IProjectsService;
import com.zhiyou100.crowdFunding.service.IProjectstypeService;
import com.zhiyou100.crowdFunding.service.IRegionService;
import com.zhiyou100.crowdFunding.service.IRepayService;
import com.zhiyou100.crowdFunding.utils.AbstractAction;
import com.zhiyou100.crowdFunding.utils.IDCardUtil;
import com.zhiyou100.crowdFunding.vo.Projects;
import com.zhiyou100.crowdFunding.vo.Projectstype;
import com.zhiyou100.crowdFunding.vo.Region;
import com.zhiyou100.crowdFunding.vo.Repay;
import com.zhiyou100.crowdFunding.vo.User;

@RequestMapping("/publish/*")
@Controller
public class PublishController extends AbstractAction {

	@Autowired
	private IProjectsService projectsService;
	@Autowired
	private IRepayService repayService;
	@Autowired
	private IProjectstypeService projectstypeService;
	@Autowired
	private IRegionService regionService;

	// 能否进入发布项目页面的判断
	@RequestMapping("front/publishProjects")
	public ModelAndView publishProjects(HttpServletRequest request) throws Exception {
		ModelAndView mav1 = new ModelAndView("/p2-crowdfunding/new_info.jsp");
//		ModelAndView mav2 = new ModelAndView("/p2-crowdfunding/login.jsp");
//		ModelAndView mav3 = new ModelAndView("/p2-crowdfunding/user.jsp");
//		User user = (User) request.getSession().getAttribute("user");
//		System.out.println(user);
//		// 1.判断用户是否登录
//		if (user != null) { // 1-1.如果登录可以进入
//			// 2.判断是否实名认证
//			if (IDCardUtil.isIDCard(user.getUsIdcard())) {
//				return mav1;
//			} else {
//				return mav3;
//			}
//		} else { // 1-2.如果没有登录进入登录页面
//			return mav2;
//		}
		return mav1;
	}

	// 填写基本信息页面
	@RequestMapping("front/newProduct")
	public ModelAndView newProduct(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("p2-crowdfunding/new_product.jsp");
		User user = (User) request.getSession().getAttribute("user");
		// request.getSession().setAttribute("user", user);
		System.out.println(user);
		return mav;
	}

	// 填写项目信息页面
	@RequestMapping("front/newInfo")
	public ModelAndView newInfo(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("p2-crowdfunding/new_info.jsp");
		return mav;
	}

	// 填写回报支持者的页面
	@RequestMapping("front/newBack")
	public ModelAndView newBack(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("p2-crowdfunding/new_back.jsp");
		// Projects projects = (Projects) request.getSession().getAttribute("projects");
		// System.out.println(projects);
		// request.getSession().setAttribute("projects", projects);
		return mav;
	}

	// 填写项目详情的页面
	@RequestMapping("front/newDetail")
	public ModelAndView newDetail(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("p2-crowdfunding/new_detail.jsp");
		return mav;
	}

	// 提交基本信息
	@RequestMapping("putInNewProduct")
	public @ResponseBody Map<String, Object> putInNewProduct(Projects vo, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		User user = (User) request.getSession().getAttribute("user");
		vo.setPsUsId(user.getUsId());
		System.out.println(vo);
		// PrintWriter out = response.getWriter();
		projectsService.add(vo);
		request.getSession().setAttribute("projects", vo);
		// if (flag) {
		// out.println("保存草稿成功");
		// } else {
		// out.println("保存草稿失败");
		// }
		// out.flush();
		// out.close();
		// return null;
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "保存草稿成功!");
		return map;
	}

	// 提交项目信息
	@RequestMapping("putInNewInfo")
	public @ResponseBody Map<String, Object> putInNewInfo(Projects vo,MultipartFile photo,
			HttpServletRequest request) throws Exception {
		System.out.println(vo);
		Projects projects = (Projects) request.getSession().getAttribute("projects");
		vo.setPsId(projects.getPsId());
		vo.setPsFile(photo.getOriginalFilename());
		System.out.println(vo);
		String fileName = super.createFileName(photo);
		super.saveFile(photo, fileName, request);
		System.out.println(vo);
		projectsService.doUpdateProjects(vo);
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "保存草稿成功");
		return map;
	}

	// 提交项目详情信息
	@RequestMapping("putInNewDetail")
	public @ResponseBody Map<String, Object> putInNewDetail(Projects vo, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		Projects projects = (Projects) request.getSession().getAttribute("projects");
		vo.setPsId(projects.getPsId());
		System.out.println(vo);
		// PrintWriter out = response.getWriter();
		projectsService.doUpdateProjectsDetail(vo);
		// request.getSession().setAttribute("projects", vo);
		// if (flag) {
		// out.println("保存草稿成功");
		// } else {
		// out.println("保存草稿失败");
		// }
		// out.flush();
		// out.close();
		// return null;
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "保存草稿成功");
		return map;
	}

	// 提交项目回报信息
	@RequestMapping("putInNewBack")
	public @ResponseBody Map<String, Object> putInNewBack(Repay vo, HttpServletResponse response,
			HttpServletRequest request) throws Exception {
		Projects projects = (Projects) request.getSession().getAttribute("projects");
		User user = (User) request.getSession().getAttribute("user");
		vo.setRyPsId(projects.getPsId());
		vo.setRyUsId(user.getUsId());
		System.out.println(vo);
		// PrintWriter out = response.getWriter();
		repayService.add(vo);
		// request.getSession().setAttribute("projects", vo);
		// if (flag) {
		// out.println("保存草稿成功");
		// } else {
		// out.println("保存草稿失败");
		// }
		// out.flush();
		// out.close();
		// return null;
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "保存成功");
		return map;
	}

	// 获取项目类型下拉列表
	@RequestMapping("find")
	public @ResponseBody List<Projectstype> findAllTypes() {
		List<Projectstype> list = null;
		try {
			list = projectstypeService.findAllTypes();
			System.out.println("==========findAllTypes============" + list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 获取省份的下拉列表
	@RequestMapping("findProvince")
	public @ResponseBody Map<String, Object> getProvince() {
		Map<String, Object> map = new HashMap<>();
		try {
			List<Region> list = regionService.findAllProvince();
			// System.out.println(list);
			map.put("provinces", list);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return map;
	}

	// 获取省份所有的市的下拉列表
	@RequestMapping("findProvinceCity")
	public @ResponseBody Map<String, Object> getCity(@RequestParam(defaultValue = "0") Integer id) {
		// System.out.println(id);
		Map<String, Object> map = new HashMap<>();
		try {
			List<Region> list = regionService.findProvinceCity(id);
			// System.out.println(list);
			map.put("cities", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	// 实现路径的配置
	@Override
	public String getFileUploadDir() {
		return "/upload/projects/";
	}

}
