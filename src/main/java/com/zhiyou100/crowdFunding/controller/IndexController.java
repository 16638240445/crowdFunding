package com.zhiyou100.crowdFunding.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping("/index/*")
@Controller
public class IndexController {
	
	@RequestMapping("index")
	public ModelAndView index() throws Exception{
		ModelAndView mav = new ModelAndView("/p2-crowdfunding/index.jsp");
		return mav;
	}
}
