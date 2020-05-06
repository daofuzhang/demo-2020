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
@Api("֧��")
public class PayController {

	@Autowired
	private PayMapper payMapper;
	
	@ApiOperation(value = "��Ӷ���")
	@PostMapping("/add")
	public String  insert(Order order) {
		payMapper.insert(order);
		return "S";
	}
	
	@ApiOperation(value = "ͨ���û�id��ѯ����")
	@GetMapping("/findByPersonId")
	public List<Order> findByPersonId(String pid){
		return payMapper.findByPersonId(pid);
	}
	
	@ApiOperation(value="ͨ�������Ų�ѯ����")
	@GetMapping("/findByOrderId")
	public List<Order> findByOrderId(String oid){
		return payMapper.findByOrderId(oid);
	}
	
}
