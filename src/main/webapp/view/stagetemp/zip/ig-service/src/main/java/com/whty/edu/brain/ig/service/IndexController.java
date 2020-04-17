package com.whty.edu.brain.ig.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	/**
	 * @Title: index
	 * @Description: 主页入口
	 * @author: generation
	 * @date:   2020年04月17日 09:28:381
	 * @param 主页入口
	 */
	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
