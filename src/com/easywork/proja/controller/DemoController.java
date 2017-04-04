package com.easywork.proja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.easycore.utils.BaseController;

@Controller
@RequestMapping("/demo")
public class DemoController extends BaseController {
	@RequestMapping("/view")
	public String viewb() {
		// return "/demo/view";
		return "/proj-a-b/view";
	}
	@RequestMapping("/userzero")
	public String viewb1() {
		// return "/demo/view";
		return "/proj-a-f/zero";
	}

	// 打开子视图
	@RequestMapping("/tab/{view}")
	public String tab(@PathVariable("view") String view) {
		return "/proj-a-f/" + view;
	}
	
	
	//转跳 前台主页面
	@RequestMapping("/userview")
	public String viewf() {
		// return "/demo/view";
		return "/proj-a-f/index";
	}
	// 打开前台 意向 页面
	@RequestMapping("/intention")
	public String tabf1() {
		return "/proj-a-f/intention";
	}
	// 打开前台 意向 页面
	@RequestMapping("/bought")
	public String tabf2() {
		return "/proj-a-f/bought";
	}

}