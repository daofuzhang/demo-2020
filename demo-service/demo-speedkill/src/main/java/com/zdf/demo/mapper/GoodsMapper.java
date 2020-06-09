package com.zdf.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zdf.demo.entity.Goods;

@Mapper
public interface GoodsMapper {

	@Insert(value = { "insert into goods values(#{goodId},#{name},#{num})"})
	public void insert(Goods goods);
	
	@Update(value = { "update goods set num = num - 1 where goodId =#{goodId} " })
	public void reduceNum(String goodId) ;
	
	@Select(value = { "select *from goods where goodId =#{goodId} " })
	public Goods findById(String goodId);
	
	@Select(value = { "select *from goods " })
	public List<Goods> findAll();
	
}
