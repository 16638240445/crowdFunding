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

	// 主页面
	@RequestMapping("index")
	public ModelAndView index() throws Exception {
		ModelAndView mav = new ModelAndView("/p2-crowdfunding/index.jsp");
		return mav;
	}

	// 登录页面
	@RequestMapping("login")
	public ModelAndView login() throws Exception {
		ModelAndView mav = new ModelAndView("/p2-crowdfunding/login.jsp");
		return mav;
	}

	// 登录
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

	// 发布的项目中的所有项目列表
	@RequestMapping("/userProjects")
	public ModelAndView userProjects() throws Exception {
		ModelAndView mav = new ModelAndView("p2-crowdfunding/user_projects.jsp");
		return mav;
	}

	// 进入注册页面
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

		user.setUsRole(0);// 刚注册默认是没有激活状态
		// user.setActivated(false); // 刚注册默认是没有激活状态
		user.setUsCode(UUID.randomUUID().toString());
		user.setUsPassword(MyPasswordEncrypt.encryptPassword(user.getUsPassword()));
		// 注册用户
		if (userService.findByEmail(user.getUsEmail()) == null) {
			userService.add(user);
			// userService.saveUser(user);
		} else {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("注册失败，该邮箱已被注册");
			throw new RuntimeException("注册失败，该邮箱已被注册");
		}
		// 查看是否注册成功，为实体类User的id赋值
		User findUser = userService.findByEmail(user.getUsEmail());

		if (findUser != null) {
			user.setUsId(findUser.getUsId());
		} else {
			throw new RuntimeException("注册用户失败");
		}

		// 注册成功后，发送账户激活链接
		httpSession.setAttribute("user", user);
		EmailUtils.sendAccountActivateEmail(user);
		try {
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("激活邮件已经发送，请注意提醒查收");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("/activate")
	public void activate(String id, String checkCode, HttpServletResponse response) throws Exception {

		int idInt = Integer.parseInt(id);

		// 根据用户id查找用户
		User user = userService.findById(idInt);

		// 验证无误，状态更改为1，即激活
		if (GenerateLinkUtils.verifyCheckcode(user, checkCode)) {

			// 修改状态
			int activated = 1;
			userService.doUpdateRole(idInt);
			user.setUsRole(1);
			// user.setActivated(true);
			try {
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().write("恭喜，激活成功！");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	// 能否进入发布项目页面的判断
	@RequestMapping("personalCenter")
	public ModelAndView personalCenter(HttpServletRequest request) throws Exception {
		ModelAndView mav1 = new ModelAndView("/p2-crowdfunding/user.jsp");
		ModelAndView mav2 = new ModelAndView("/p2-crowdfunding/login.jsp");
		User user = (User) request.getSession().getAttribute("user");
		System.out.println(user);
		// 1.判断用户是否登录
		if (user != null) { // 1-1.如果登录可以进入
				return mav1;			
		} else { // 1-2.如果没有登录进入登录页面
			return mav2;
		}
	}
}
