package com.zdf.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zdf.demo.entity.Goods;
import com.zdf.demo.feign.GoodsService;

@Controller
public class HomeController {
	
	@Autowired
	private  GoodsService goodsService;
	

	@RequestMapping("/home")
	public String home(Model model) {
		List<Goods> goods=goodsService.findAll();
		model.addAttribute("goods", goods);
		return "home";
	}
}
