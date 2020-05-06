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

@Api("��Ʒ��ɾ�Ĳ�ӿ�")
@RequestMapping("/goods")
@RestController
public class GoodController {

	@Autowired
	private GoodsMapper goodsMapper;
	
	@ApiOperation(value = "���")
	@PostMapping("/add")
	public String insert(Goods goods) {
		goodsMapper.insert(goods);
		return "S";
	}
	
	@ApiOperation(value = "�޸ļ۸�")
	@GetMapping("/updatePriceById")
	public String updatePriceById(String id,float price) {
		goodsMapper.updatePriceById(id, price);
		return "S";
	}
	@ApiOperation(value = "�޸�����")
	@GetMapping("/updateNumById")
	public String updateNumById(String id,int num) {
		goodsMapper.updateNumById(id, num);
		return "S";
	}
	
	@ApiOperation(value = "��ѯ")
	@GetMapping("/findAll")
	public List<Goods> findAll(){
		return goodsMapper.findAll();
	}
	
	@ApiOperation(value = "ͨ��Id��ѯ")
	@GetMapping("/findById")
	public List<Goods> findById(String id){
		return goodsMapper.findById(id);
	}
	
}
