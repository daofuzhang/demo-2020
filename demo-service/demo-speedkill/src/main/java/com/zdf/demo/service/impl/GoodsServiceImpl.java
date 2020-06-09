package com.zdf.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdf.demo.entity.Goods;
import com.zdf.demo.mapper.GoodsMapper;
import com.zdf.demo.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;
	
	@Override
	public void save(Goods goods) {
		goodsMapper.insert(goods);
	}

}
