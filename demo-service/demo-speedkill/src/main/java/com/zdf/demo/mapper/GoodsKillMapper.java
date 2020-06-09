package com.zdf.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.zdf.demo.model.GoodsKillDTO;

@Mapper
public interface GoodsKillMapper {

	@Select(value = { "select * from goods inner join syskill on goods.goodid = syskill.goodsid where goodid=#{goodsId}" })
	@Results({ 
		@Result( property = "id" ,column = "id"),
		@Result( property = "goodId" ,column = "goodid")
	})
	public List<GoodsKillDTO> findKillGoodsById(String goodsId);
	
}
