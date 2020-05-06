package com.zdf.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.zdf.demo.entity.Goods;

@Mapper
public interface GoodsMapper {

	@Insert(value = { "insert into t_goods values(#{id},#{name},#{price},#{num})" })
	public void insert(Goods goods);
	
	
	@Update(value = { "update t_goods set price=#{price} where id=#{id}" })
	public void updatePriceById(String id,float price);
	
	
	@Update(value = { "update t_goods set num=#{num} where id=#{id}" })
	public void updateNumById(String id,int num);
	
	
	@Select(value = { "select * from t_goods" })
	public List<Goods> findAll();
	
	
	@Select(value = { "select * from t_goods where id=#{id}" })
	public List<Goods> findById(String id);
}
