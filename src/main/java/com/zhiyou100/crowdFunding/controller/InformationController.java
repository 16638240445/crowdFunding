package com.zhiyou100.crowdFunding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/information/*")
@Controller
public class InformationController {

	// ������Ѷ��ҳ��
	@RequestMapping("lyList")
	public ModelAndView gyzcList() throws Exception {
		ModelAndView mav = new ModelAndView("p2-crowdfunding/ly-list.jsp");
		return mav;
	}
}
