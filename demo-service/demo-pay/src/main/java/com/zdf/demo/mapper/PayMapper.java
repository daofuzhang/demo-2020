package com.zdf.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.zdf.demo.entity.Order;

@Mapper
public interface PayMapper {

	@Insert("insert into t_order values(#{id},#{orderid},#{ordername},#{goodsId},#{personId})")
	public void insert(Order order);
	
	@Select("select * from t_order where personId=#{pid}")
	public List<Order> findByPersonId(String pid);
	
	@Select("select * from t_order where orderid=#{oid}")
	public List<Order> findByOrderId(String oid);
	
	
}
