package com.zhiyou100.crowdFunding.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.crowdFunding.service.IAdminService;
import com.zhiyou100.crowdFunding.service.ICommentsService;
import com.zhiyou100.crowdFunding.service.IProjectsService;
import com.zhiyou100.crowdFunding.service.IProjectstypeService;
import com.zhiyou100.crowdFunding.service.IUserService;
import com.zhiyou100.crowdFunding.vo.Admin;
import com.zhiyou100.crowdFunding.vo.Comments;
import com.zhiyou100.crowdFunding.vo.Projects;
import com.zhiyou100.crowdFunding.vo.Projectstype;
import com.zhiyou100.crowdFunding.vo.User;

@SessionAttributes("user")
@RequestMapping("/admin/*")
@Controller
public class AdminController extends AbstractController {
	@Resource
	private IAdminService adminService;
	@Resource
	private IProjectsService projectsService;
	@Resource
	private IUserService userService;
	@Resource
	private IProjectstypeService projectstypeService;
	@Resource
	private ICommentsService commentsService;

	// 后台登录
	@RequestMapping("login")
	public String login() {
		return "/admin/admin_login.jsp";
	}

	// 验证账号密码
	@RequestMapping("index")
	public @ResponseBody Object index(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String adminAccountName = request.getParameter("adminAccountName");
		String adminPassword = request.getParameter("adminPassword");		
		Map<String, Object> map = new HashMap<>();
		map.put("adminAccountName", adminAccountName);
		map.put("adminPassword", adminPassword);
		System.out.println(map.get("adminAccountName"));
		System.out.println(map.get("adminPassword"));
		Admin vo = adminService.findByLogin(map);
		request.getSession().setAttribute("vo", vo);
		System.out.println("============="+vo);
		return vo;
	}

	// 所有项目
	@RequestMapping("products")
	public ModelAndView products(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("/admin/products.jsp");
		int currentPage = Integer
				.parseInt(request.getParameter("currentPage") == null ? "1" : request.getParameter("currentPage"));
		int lineSize = Integer
				.parseInt(request.getParameter("lineSize") == null ? "2" : request.getParameter("lineSize"));
		Map<String, Object> map = new HashMap<>();
		map.put("lineSize", lineSize);
		map.put("start", (currentPage - 1) * lineSize);
		Long productsCount = projectsService.getAllCount();
		List<Projects> list = projectsService.findAll(map);
		// System.out.println(list);
		// 总页数
		mav.addObject("allCount", productsCount);
//		request.setAttribute("vo", request.getSession().getAttribute("vo"));
		if (productsCount < 1) {
			mav.addObject("allPages", (productsCount + lineSize) / lineSize);
		}
		mav.addObject("allPages", (productsCount + lineSize - 1) / lineSize);
		mav.addObject("list", list);
		mav.addObject("currentPage", currentPage);
		mav.addObject("lineSize", lineSize);
		mav.addObject("forWard", mav);
		return mav;
	}

	// 所有项目详情1
	@RequestMapping("productsDetail_1")
	public String projectsDetail_1(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int psId = Integer.parseInt(request.getParameter("psId"));
		int psUsId = Integer.parseInt(request.getParameter("psUsId"));
		User user = userService.findById(psUsId);
		// System.out.println(user);
		Projects ps = projectsService.findById(psId);
		request.setAttribute("ps", ps);
		request.setAttribute("user", user);
		return "/admin/product/product-info1.jsp";
	}

	// 所有项目详情2
	@RequestMapping("productsDetail_2")
	public String projectsDetail_2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int psId = Integer.parseInt(request.getParameter("psId"));
		int psUsId = Integer.parseInt(request.getParameter("psUsId"));
		User user = userService.findById(psUsId);
		// System.out.println(user);
		Projects ps = projectsService.findById(psId);
		request.setAttribute("ps", ps);
		request.setAttribute("user", user);
		return "/admin/product/product-info2.jsp";
	}

	// 所有项目详情3
	@RequestMapping("productsDetail_3")
	public ModelAndView projectsDetail_3(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/admin/product/product-info3.jsp");
		int psId = Integer.parseInt(request.getParameter("psId"));
		int psUsId = Integer.parseInt(request.getParameter("psUsId"));
		Map<String, Object> map = new HashMap<>();
		map.put("cmUsId", psUsId);
		map.put("cmPsId", psId);
		Comments vo = commentsService.findByPstidAndUsId(map);
		// System.out.println(vo);
		User user = userService.findById(psUsId);
		Projects ps = projectsService.findById(psId);
		mav.addObject("cm", vo);
		mav.addObject("ps", ps);
		mav.addObject("user", user);
		return mav;
	}

	// 所有项目详情4
	@RequestMapping("productsDetail_4")
	public ModelAndView projectsDetail_4(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/admin/product/product-info4.jsp");
		int psId = Integer.parseInt(request.getParameter("psId"));
		Projects ps = projectsService.findById(psId);
		mav.addObject("ps", ps);
		return mav;
	}

	// 所有项目详情5
	@RequestMapping("productsDetail_5")
	public ModelAndView projectsDetail_5(User user, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = new ModelAndView("/admin/product/product-info5.jsp");
		int psId = Integer.parseInt(request.getParameter("psId"));
		// int psUsId = Integer.parseInt(request.getParameter("psUsId"));
		// User user = userService.findById(psUsId);
		System.out.println(user);
		Projects ps = projectsService.findById(psId);
		request.setAttribute("ps", ps);
		request.setAttribute("user", user);
		return mav;
	}

	// 项目分类列表
	@RequestMapping("projectstype")
	public ModelAndView projectstype(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/admin/classify/all_classity.jsp");
		int currentPage = Integer
				.parseInt(request.getParameter("currentPage") == null ? "1" : request.getParameter("currentPage"));
		int lineSize = Integer
				.parseInt(request.getParameter("lineSize") == null ? "2" : request.getParameter("lineSize"));
		Map<String, Object> map = new HashMap<>();
		map.put("lineSize", lineSize);
		map.put("start", (currentPage - 1) * lineSize);
		List<Projectstype> list = projectstypeService.findAll(map);
		Long projectstypeCount = projectstypeService.getAllCount();
		mav.addObject("allCount", projectstypeCount);
		if (projectstypeCount < 1) {
			mav.addObject("allPages", (projectstypeCount + lineSize) / lineSize);
		} else {
			mav.addObject("allPages", (projectstypeCount + lineSize - 1) / lineSize);
		}
		mav.addObject("list", list);
		mav.addObject("currentPage", currentPage);
		mav.addObject("lineSize", lineSize);
		mav.addObject("forWard", mav);
		// request.setAttribute("list", list);
		return mav;
	}

	// 项目分类更改
	@RequestMapping("projectstypeUpdate")
	public String projectstypeUpdate(Projectstype vo, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// Projectstype vo = new Projectstype();
		// vo.setPstId(Integer.parseInt(request.getParameter("pstId")));
		// vo.setPstName(request.getParameter("pstName"));
		// vo.setPstDesc(request.getParameter("pstDesc"));
		// vo.setPstStardate(DateUtils.StringtoDate(request.getParameter("pstStardate")));
		// vo.setPstType(Integer.parseInt(request.getParameter("pstType")));
		// System.out.println(vo);
		projectstypeService.edit(vo);
		return "redirect:/admin/projectstype.action";
	}

	// 项目分类详情
	@RequestMapping("projectstypeDel")
	public ModelAndView projectstypeDel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("redirect:/admin/projectstype.action");
		int pstId = Integer.parseInt(request.getParameter("pstId"));
		System.out.println(pstId);
		projectstypeService.remove(pstId);
		return mav;
	}

	// 项目分类添加
	@RequestMapping("projectstypeAdd")
	public ModelAndView projectstypeAdd(Projectstype vo, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = new ModelAndView("/admin/classify/add_classity.jsp");
		ModelAndView mav1 = new ModelAndView("redirect:/admin/projectstype.action");
		// Projectstype vo = new Projectstype();
		// vo.setPstName(request.getParameter("pstName"));
		// vo.setPstDesc(request.getParameter("pstDesc"));
		// vo.setPstStardate(new Date());
		vo.setPstType(0);
		// System.out.println(vo);
		if (projectstypeService.add(vo) == true) {
			return mav1;
		} else {
			return mav;
		}
	}

	// 项目审核列表
	@RequestMapping("productsReviewList")
	public ModelAndView productsReviewList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/admin/project_review/products-review-list.jsp");
		int currentPage = Integer
				.parseInt(request.getParameter("currentPage") == null ? "1" : request.getParameter("currentPage"));
		int lineSize = Integer
				.parseInt(request.getParameter("lineSize") == null ? "4" : request.getParameter("lineSize"));
		Map<String, Object> map = new HashMap<>();
		map.put("column", "ps_type");
		map.put("keyword", "0");
		map.put("lineSize", lineSize);
		map.put("start", (currentPage - 1) * lineSize);
		Long productsCount = projectsService.getCountByReview();
		List<Projects> list = projectsService.findAllSplit(map);
		// 总页数
		mav.addObject("allCount", productsCount);
		if (productsCount < 1) {
			mav.addObject("allPages", (productsCount + lineSize) / lineSize);
		} else {
			mav.addObject("allPages", (productsCount + lineSize - 1) / lineSize);
		}
		mav.addObject("list", list);
		mav.addObject("currentPage", currentPage);
		mav.addObject("lineSize", lineSize);
		mav.addObject("forWard", mav);
		return mav;
	}

	// 项目审核详情
	@RequestMapping("productReviewDetail")
	public ModelAndView productReviewDetail(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/admin/project_review/product-review-detail.jsp");
		int psId = Integer.parseInt(request.getParameter("psId"));
		int psUsId = Integer.parseInt(request.getParameter("psUsId"));
		User user = userService.findById(psUsId);
		// System.out.println(user);
		Projects ps = projectsService.findById(psId);
		request.setAttribute("ps", ps);
		request.setAttribute("user", user);
		return mav;
	}

	// 项目审核更改反射
	@RequestMapping("productReviewDetail_1")
	public ModelAndView productReviewDetail_1(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView mav = new ModelAndView("/admin/project_review/product-review-edit.jsp");
		int psId = Integer.parseInt(request.getParameter("psId"));
		Projects ps = projectsService.findById(psId);
		request.setAttribute("ps", ps);
		return mav;
	}

	// 项目审核更改
	@RequestMapping("productReviewEdit")
	public String productReviewEdit(Projects vo, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// int psId = Integer.parseInt(request.getParameter("psId"));
		// int psType = Integer.parseInt(request.getParameter("psType"));
		// Date psStarttime =
		// DateUtils.StringtoDate(request.getParameter("psStarttime"));
		// Date psEndtime = DateUtils.StringtoDate(request.getParameter("psEndtime"));
		// int psAuditor = Integer.parseInt(request.getParameter("psAuditor"));
		// Projects vo = new Projects();
		// vo.setPsId(psId);
		// vo.setPsType(psType);
		// vo.setPsStarttime(psStarttime);
		// vo.setPsEndtime(psEndtime);
		// vo.setPsAuditor(psAuditor);
		System.out.println(vo);
		if (projectsService.doUpdateByReview(vo) == true) {
			return "redirect:/admin/productsReviewList.action";
		} else {
			return "/admin/project_review/product-review-edit.jsp";
		}
	}

	// 所有项目多条件查询
	@RequestMapping("projectsTerm")
	public ModelAndView projectsTerm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String psName = request.getParameter("psName");
		String psType = request.getParameter("psType");
		String pstName = request.getParameter("pstName");
		String usName = request.getParameter("usName");
		ModelAndView mav = new ModelAndView("/admin/products.jsp");
		int currentPage = Integer
				.parseInt(request.getParameter("currentPage") == null ? "1" : request.getParameter("currentPage"));
		int lineSize = Integer
				.parseInt(request.getParameter("lineSize") == null ? "1" : request.getParameter("lineSize"));
		// 条件查询
		Map<String, Object> map = new HashMap<>();
		map.put("psName", "%" + psName + "%");
		map.put("psType", "%" + psType + "%");
		map.put("pstName", "%" + pstName + "%");
		map.put("usName", "%" + usName + "%");
		map.put("lineSize", lineSize);
		map.put("start", (currentPage - 1) * lineSize);
		List<Projects> list = projectsService.findByTerm(map);
		System.out.println(list);
		mav.addObject("list", list);
		// 条件查询数量
		Map<String, Object> map1 = new HashMap<>();
		map1.put("psName", "%" + psName + "%");
		map1.put("psType", "%" + psType + "%");
		map1.put("pstName", "%" + pstName + "%");
		map1.put("usName", "%" + usName + "%");
		// -----------------
		request.setAttribute("psName", psName);
		request.setAttribute("psType", psType);
		request.setAttribute("pstName", pstName);
		request.setAttribute("usName", usName);
		// -------------------------------
		Long projectsCount = projectsService.getAllCountSplit(map1);
		mav.addObject("allCount", projectsCount);
		if (projectsCount < 1) {
			mav.addObject("allPages", (projectsCount + lineSize) / lineSize);
		} else {
			mav.addObject("allPages", (projectsCount + lineSize - 1) / lineSize);
		}
		mav.addObject("currentPage", currentPage);
		mav.addObject("lineSize", lineSize);
		mav.addObject("forWard", mav);
		// request.setAttribute("list", list);
		return mav;
	}

	// 项目审核多条件查询
	@RequestMapping("projectsReviewTerm")
	public ModelAndView projectsReviewTerm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/admin/project_review/products-review-list.jsp");
		int currentPage = Integer
				.parseInt(request.getParameter("currentPage") == null ? "1" : request.getParameter("currentPage"));
		int lineSize = Integer
				.parseInt(request.getParameter("lineSize") == null ? "1" : request.getParameter("lineSize"));
		// 条件查询
		Map<String, Object> map = new HashMap<>();
		String psName = request.getParameter("psName");
		String psType = "0";
		String pstName = request.getParameter("pstName");
		String usName = request.getParameter("usName");
		map.put("psName", "%" + psName + "%");
		map.put("psType", 0);
		map.put("pstName", "%" + pstName + "%");
		map.put("usName", "%" + usName + "%");
		map.put("lineSize", lineSize);
		map.put("start", (currentPage - 1) * lineSize);
		List<Projects> list = projectsService.findByTerm(map);
		System.out.println(list);
		mav.addObject("list", list);
		// 条件查询数量
		Map<String, Object> map1 = new HashMap<>();
		map1.put("psName", "%" + psName + "%");
		map1.put("psType", psType);
		map1.put("pstName", "%" + pstName + "%");
		map1.put("usName", "%" + usName + "%");
		// -----------------
		request.setAttribute("psName", psName);
		request.setAttribute("psType", psType);
		request.setAttribute("pstName", pstName);
		request.setAttribute("usName", usName);
		// -------------------------------
		Long projectsCount = projectsService.getAllCountSplit(map1);
		mav.addObject("allCount", projectsCount);
		if (projectsCount < 1) {
			mav.addObject("allPages", (projectsCount + lineSize) / lineSize);
		} else {
			mav.addObject("allPages", (projectsCount + lineSize - 1) / lineSize);
		}
		mav.addObject("currentPage", currentPage);
		mav.addObject("lineSize", lineSize);
		mav.addObject("forWard", mav);
		// request.setAttribute("list", list);
		return mav;
	}
	//项目分类添加
	// 项目审核多条件查询
		@RequestMapping("addClassity")
		public ModelAndView addClassity() throws Exception {
			ModelAndView mav= new ModelAndView("admin/classify/add_classity.jsp");
			return mav;
		}
	
	
	
	
	
	@RequestMapping("obj")
	public Object obj(String msg, HttpServletRequest request) {
		request.setAttribute("info", msg);// request.setAttribute(key,value);
		System.out.println("====接受的参数====" + msg);
		request.setAttribute("obj", msg);
		return "/pages/welcome.jsp";
		// return mav
	}

	@RequestMapping("delete")
	public ModelAndView remove(int mid) { // servlet传递过来的字符串
		System.out.println(mid * 3);
		return null;
	}

	@RequestMapping("update")
	public ModelAndView update(@RequestParam(defaultValue = "1") int mid) {
		System.out.println(mid * 3);
		return null;
	}

	@RequestMapping("get")
	public Object get(int mid, HttpServletRequest request, HttpServletResponse response) {
		try {
			response.getWriter().println("nihao");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
