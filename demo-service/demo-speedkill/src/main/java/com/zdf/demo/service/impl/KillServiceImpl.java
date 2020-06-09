package com.zdf.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdf.demo.mapper.GoodsKillMapper;
import com.zdf.demo.model.GoodsKillDTO;
import com.zdf.demo.service.KillService;

@Service
public class KillServiceImpl implements KillService {
	
	@Autowired
	private GoodsKillMapper goodsKillMapper;

	@Override
	public List<GoodsKillDTO> findKillGoodsById(String goodsId) {
		return goodsKillMapper.findKillGoodsById(goodsId);
	}

}
