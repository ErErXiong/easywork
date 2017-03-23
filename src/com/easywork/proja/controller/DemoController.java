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
	public String view() {
		// return "/demo/view";
		return "/proj-a-b/view";
	}

	// 打开子视图
	@RequestMapping("/tab/{view}")
	public String tab(@PathVariable("view") String view) {
		return "/proj-a-b/" + view;
	}

}