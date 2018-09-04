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

	// �ܷ���뷢����Ŀҳ����ж�
	@RequestMapping("front/publishProjects")
	public ModelAndView publishProjects(HttpServletRequest request) throws Exception {
		ModelAndView mav1 = new ModelAndView("/p2-crowdfunding/new_info.jsp");
//		ModelAndView mav2 = new ModelAndView("/p2-crowdfunding/login.jsp");
//		ModelAndView mav3 = new ModelAndView("/p2-crowdfunding/user.jsp");
//		User user = (User) request.getSession().getAttribute("user");
//		System.out.println(user);
//		// 1.�ж��û��Ƿ��¼
//		if (user != null) { // 1-1.�����¼���Խ���
//			// 2.�ж��Ƿ�ʵ����֤
//			if (IDCardUtil.isIDCard(user.getUsIdcard())) {
//				return mav1;
//			} else {
//				return mav3;
//			}
//		} else { // 1-2.���û�е�¼�����¼ҳ��
//			return mav2;
//		}
		return mav1;
	}

	// ��д������Ϣҳ��
	@RequestMapping("front/newProduct")
	public ModelAndView newProduct(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("p2-crowdfunding/new_product.jsp");
		User user = (User) request.getSession().getAttribute("user");
		// request.getSession().setAttribute("user", user);
		System.out.println(user);
		return mav;
	}

	// ��д��Ŀ��Ϣҳ��
	@RequestMapping("front/newInfo")
	public ModelAndView newInfo(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("p2-crowdfunding/new_info.jsp");
		return mav;
	}

	// ��д�ر�֧���ߵ�ҳ��
	@RequestMapping("front/newBack")
	public ModelAndView newBack(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("p2-crowdfunding/new_back.jsp");
		// Projects projects = (Projects) request.getSession().getAttribute("projects");
		// System.out.println(projects);
		// request.getSession().setAttribute("projects", projects);
		return mav;
	}

	// ��д��Ŀ�����ҳ��
	@RequestMapping("front/newDetail")
	public ModelAndView newDetail(HttpServletRequest request) throws Exception {
		ModelAndView mav = new ModelAndView("p2-crowdfunding/new_detail.jsp");
		return mav;
	}

	// �ύ������Ϣ
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
		// out.println("����ݸ�ɹ�");
		// } else {
		// out.println("����ݸ�ʧ��");
		// }
		// out.flush();
		// out.close();
		// return null;
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "����ݸ�ɹ�!");
		return map;
	}

	// �ύ��Ŀ��Ϣ
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
		map.put("msg", "����ݸ�ɹ�");
		return map;
	}

	// �ύ��Ŀ������Ϣ
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
		// out.println("����ݸ�ɹ�");
		// } else {
		// out.println("����ݸ�ʧ��");
		// }
		// out.flush();
		// out.close();
		// return null;
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "����ݸ�ɹ�");
		return map;
	}

	// �ύ��Ŀ�ر���Ϣ
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
		// out.println("����ݸ�ɹ�");
		// } else {
		// out.println("����ݸ�ʧ��");
		// }
		// out.flush();
		// out.close();
		// return null;
		Map<String, Object> map = new HashMap<>();
		map.put("msg", "����ɹ�");
		return map;
	}

	// ��ȡ��Ŀ���������б�
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

	// ��ȡʡ�ݵ������б�
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

	// ��ȡʡ�����е��е������б�
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

	// ʵ��·��������
	@Override
	public String getFileUploadDir() {
		return "/upload/projects/";
	}

}
