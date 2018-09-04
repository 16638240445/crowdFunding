package com.zhiyou100.crowdFunding.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.crowdFunding.service.IProjectsService;
import com.zhiyou100.crowdFunding.service.IUserService;
import com.zhiyou100.crowdFunding.utils.EmailUtils;
import com.zhiyou100.crowdFunding.utils.GenerateLinkUtils;
import com.zhiyou100.crowdFunding.utils.IDCardUtil;
import com.zhiyou100.crowdFunding.utils.MyPasswordEncrypt;
import com.zhiyou100.crowdFunding.vo.Projects;
import com.zhiyou100.crowdFunding.vo.User;

@RequestMapping("/user/*")
@Controller
public class UserController {

	@Resource
	private IUserService userService;

	@Resource
	private IProjectsService projectsService;

	// ��ҳ��
	@RequestMapping("index")
	public ModelAndView index() throws Exception {
		ModelAndView mav = new ModelAndView("/p2-crowdfunding/index.jsp");
		return mav;
	}

	// ��¼ҳ��
	@RequestMapping("login")
	public ModelAndView login() throws Exception {
		ModelAndView mav = new ModelAndView("/p2-crowdfunding/login.jsp");
		return mav;
	}

	// ��¼
	@RequestMapping("userAdmin")
	public @ResponseBody Object admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		ModelAndView mav1 = new ModelAndView("p2-crowdfunding/index.jsp");
//		ModelAndView mav2 = new ModelAndView("/p2-crowdfunding/login.jsp");
		String username = request.getParameter("username");
		String password = MyPasswordEncrypt.encryptPassword(request.getParameter("password"));
		Map<String, Object> map = new HashMap<>();
		if (username.contains("@")) {
			map.put("usEmail", username);
		} else {
			map.put("usPhone", username);
		}
		map.put("usPassword", password);
		User user = userService.findByLogin(map);
		System.out.println(user);
		request.getSession().setAttribute("user", user);
//		if (user != null) {
//			return mav1;
//
//		} else {
//			return mav2;
//		}
		return user;
	}

	// ��������Ŀ�е�������Ŀ�б�
	@RequestMapping("/userProjects")
	public ModelAndView userProjects() throws Exception {
		ModelAndView mav = new ModelAndView("p2-crowdfunding/user_projects.jsp");
		return mav;
	}

	// ����ע��ҳ��
	@RequestMapping("/reg")
	public ModelAndView reg() throws Exception {
		ModelAndView mav = new ModelAndView("p2-crowdfunding/reg.jsp");
		return mav;
	}

	@RequestMapping("/toregist")
	public String toemail() {
		return "regist";
	}

	@RequestMapping("/regist")
	public void regist(User user, HttpSession httpSession, HttpServletResponse response, HttpServletRequest request)
			throws Exception {

		user.setUsRole(0);// ��ע��Ĭ����û�м���״̬
		// user.setActivated(false); // ��ע��Ĭ����û�м���״̬
		user.setUsCode(UUID.randomUUID().toString());
		user.setUsPassword(MyPasswordEncrypt.encryptPassword(user.getUsPassword()));
		// ע���û�
		if (userService.findByEmail(user.getUsEmail()) == null) {
			userService.add(user);
			// userService.saveUser(user);
		} else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("ע��ʧ�ܣ��������ѱ�ע��");
			throw new RuntimeException("ע��ʧ�ܣ��������ѱ�ע��");
		}
		// �鿴�Ƿ�ע��ɹ���Ϊʵ����User��id��ֵ
		User findUser = userService.findByEmail(user.getUsEmail());

		if (findUser != null) {
			user.setUsId(findUser.getUsId());
		} else {
			throw new RuntimeException("ע���û�ʧ��");
		}

		// ע��ɹ��󣬷����˻���������
		httpSession.setAttribute("user", user);
		EmailUtils.sendAccountActivateEmail(user);
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("�����ʼ��Ѿ����ͣ���ע�����Ѳ���");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/activate")
	public void activate(String id, String checkCode, HttpServletResponse response) throws Exception {

		int idInt = Integer.parseInt(id);

		// �����û�id�����û�
		User user = userService.findById(idInt);

		// ��֤����״̬����Ϊ1��������
		if (GenerateLinkUtils.verifyCheckcode(user, checkCode)) {

			// �޸�״̬
			int activated = 1;
			userService.doUpdateRole(idInt);
			user.setUsRole(1);
			// user.setActivated(true);
			try {
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write("��ϲ������ɹ���");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// �ܷ���뷢����Ŀҳ����ж�
	@RequestMapping("personalCenter")
	public ModelAndView personalCenter(HttpServletRequest request) throws Exception {
		ModelAndView mav1 = new ModelAndView("/p2-crowdfunding/user.jsp");
		ModelAndView mav2 = new ModelAndView("/p2-crowdfunding/login.jsp");
		User user = (User) request.getSession().getAttribute("user");
		System.out.println(user);
		// 1.�ж��û��Ƿ��¼
		if (user != null) { // 1-1.�����¼���Խ���
				return mav1;			
		} else { // 1-2.���û�е�¼�����¼ҳ��
			return mav2;
		}
	}
}
