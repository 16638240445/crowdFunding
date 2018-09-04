package com.zhiyou100.crowdFunding.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.*;
import org.springframework.web.servlet.HandlerInterceptor;

import com.zhiyou100.crowdFunding.vo.User;



public class ProjectsPublishInInterceptor implements HandlerInterceptor {
	private Logger log = LogManager.getLogger(ProjectsPublishInInterceptor.class.getName());

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		log.info("=========ProjectsPublishInInterceptor=====preHandle====");
//		String url = request.getRequestURI();
//		log.info("=========ProjectsPublishInInterceptor=========" + url);
//		String localUrl = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
//				+ request.getContextPath() + "/";
//		log.info("=========ProjectsPublishInInterceptor=========" + localUrl);
		// 1.�ж�session���Ƿ��е�ǰ���û�
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
//		log.info(user);
		log.info(user);
		boolean flag = false;
		// 1.�ж��û��Ƿ��¼
		if (user != null) { // 1-1.�����¼���Խ���
			flag = IDCardUtil.isIDCard(user.getUsIdcard());
			// 2.�ж��Ƿ�ʵ����֤
			if (flag) {
				log.info("=========ProjectsPublishInInterceptor=========��¼��ʵ����֤");
				// request.getRequestDispatcher("/WEB-INF/pages/p2-crowdfunding/new_info.jsp").forward(request,
				// response);
			} else {
				log.info("=========ProjectsPublishInInterceptor=========δͨ��ʵ����֤");
				request.getRequestDispatcher("/WEB-INF/pages/p2-crowdfunding/user.jsp").forward(request, response);
			}
		} else { // 1-2.���û�е�¼�����¼ҳ��
			request.getRequestDispatcher("/WEB-INF/pages/p2-crowdfunding/login.jsp").forward(request, response);
		}
//		log.info("====END===");
		return flag;
	}
}
