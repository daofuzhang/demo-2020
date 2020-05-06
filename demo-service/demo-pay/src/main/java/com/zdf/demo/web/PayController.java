package com.zdf.demo.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.zdf.demo.entity.Order;
import com.zdf.demo.mapper.PayMapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/pay")
@Api("支付")
public class PayController {

	@Autowired
	private PayMapper payMapper;
	
	@ApiOperation(value = "添加订单")
	@PostMapping("/add")
	public String  insert(Order order) {
		payMapper.insert(order);
		return "S";
	}
	
	@ApiOperation(value = "通过用户id查询订单")
	@GetMapping("/findByPersonId")
	public List<Order> findByPersonId(String pid){
		return payMapper.findByPersonId(pid);
	}
	
	@ApiOperation(value="通过订单号查询订单")
	@GetMapping("/findByOrderId")
	public List<Order> findByOrderId(String oid){
		return payMapper.findByOrderId(oid);
	}
	
}
