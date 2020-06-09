package com.zdf.demo.controller;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zdf.demo.entity.CustomerKilled;
import com.zdf.demo.entity.Goods;
import com.zdf.demo.entity.SysKill;
import com.zdf.demo.model.GoodsKillDTO;
import com.zdf.demo.model.Result;
import com.zdf.demo.service.CustomerKilledService;
import com.zdf.demo.service.GoodsService;
import com.zdf.demo.service.KillService;
import com.zdf.demo.service.SysKillService;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private GoodsService goodsService;
	@Autowired
	private CustomerKilledService customerKilledService;
	@Autowired
	private SysKillService sysKillService;
	@Autowired
	private KillService killService;
	
	@RequestMapping("/searchtest")
	public List<GoodsKillDTO> search(){
		return killService.findKillGoodsById("a50692a0d6904b728b834a6e1d2f8b30");
	}
	
	@RequestMapping("/errortest")
	public Result errortest() {
		int i=1/0;
		return new Result("S","");
	}
	
	@RequestMapping("/savegoods")
	public String goodsSave() {

		Goods goods=new Goods();
		goods.setGoodId(UUID.randomUUID().toString().replace("-", ""));
		goods.setName("Iphone11");
		goods.setNum(1000);
		goodsService.save(goods);
		return "S";
	}
	@RequestMapping("/savekill")
	public String killSave() {
		SysKill s=new SysKill();
		s.setCreatetime(new Date());
		s.setEndtime(new Date());
		s.setGoodsId("1");
		s.setId(UUID.randomUUID().toString().replace("-", ""));
		s.setStarttime(new Date());
		sysKillService.save(s);
		return "S";
	}
	@RequestMapping("/saveck")
	public String customerkillSave() {
		CustomerKilled c=new CustomerKilled();
		c.setCreatetime(new Date());
		c.setGoodId("1");
		c.setId(UUID.randomUUID().toString().replace("-", ""));
		c.setPhone("186XXXXXXXX");
		c.setState(1);
		customerKilledService.save(c);
		return "S";
	}
	
}
