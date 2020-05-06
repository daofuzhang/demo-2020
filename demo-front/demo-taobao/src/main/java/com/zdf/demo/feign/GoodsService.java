package com.zdf.demo.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.zdf.demo.entity.Goods;

@FeignClient(name = "demo-goods")
public interface GoodsService {

	@GetMapping("/goods/findAll")
	public List<Goods> findAll();
	
}

