package com.zhiyou100.crowdFunding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/crowdfunding/*")
@Controller
public class CrowdfundingController {
		
		//�����ڳ���ҳ��
		@RequestMapping("gyzcList")
		public ModelAndView gyzcList() throws Exception {
			ModelAndView mav = new ModelAndView("p2-crowdfunding/gyzc-list.jsp");
			return mav;
		}
	
}
