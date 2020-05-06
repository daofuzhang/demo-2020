package com.zdf.demo.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zdf.demo.entity.Goods;
import com.zdf.demo.mapper.GoodsMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("商品增删改查接口")
@RequestMapping("/goods")
@RestController
public class GoodController {

	@Autowired
	private GoodsMapper goodsMapper;
	
	@ApiOperation(value = "添加")
	@PostMapping("/add")
	public String insert(Goods goods) {
		goodsMapper.insert(goods);
		return "S";
	}
	
	@ApiOperation(value = "修改价格")
	@GetMapping("/updatePriceById")
	public String updatePriceById(String id,float price) {
		goodsMapper.updatePriceById(id, price);
		return "S";
	}
	@ApiOperation(value = "修改数量")
	@GetMapping("/updateNumById")
	public String updateNumById(String id,int num) {
		goodsMapper.updateNumById(id, num);
		return "S";
	}
	
	@ApiOperation(value = "查询")
	@GetMapping("/findAll")
	public List<Goods> findAll(){
		return goodsMapper.findAll();
	}
	
	@ApiOperation(value = "通过Id查询")
	@GetMapping("/findById")
	public List<Goods> findById(String id){
		return goodsMapper.findById(id);
	}
	
}
