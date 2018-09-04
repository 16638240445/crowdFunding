package com.zhiyou100.crowdFunding.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhiyou100.crowdFunding.service.IQuestionallService;
import com.zhiyou100.crowdFunding.vo.Questionall;

@RequestMapping("/question/*")
@Controller
public class QuestionController {

	@Resource
	private IQuestionallService questionallService;

	@RequestMapping("questionall")
	public ModelAndView questionall() throws Exception {
		ModelAndView mav = new ModelAndView("p2-crowdfunding/cop.jsp");
		List<Questionall> list = questionallService.findAll();
		mav.addObject("list", list);
		System.out.println(list);
		return mav;
	}

	// @RequestMapping("questionotherDetail")
	// public ModelAndView questionotherDetail() throws Exception{
	// ModelAndView mav = new ModelAndView("/p2-crowdfunding/cop.jsp");
	// List<Questionall> list = questionallService.findAll();
	// mav.addObject("list", list);
	// System.out.println(list);
	// return mav;
	// }
}
