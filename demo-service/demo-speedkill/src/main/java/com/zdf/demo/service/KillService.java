package com.zdf.demo.service;

import java.util.List;

import com.zdf.demo.model.GoodsKillDTO;

public interface KillService {
	
	public List<GoodsKillDTO> findKillGoodsById(String goodsId);

}
