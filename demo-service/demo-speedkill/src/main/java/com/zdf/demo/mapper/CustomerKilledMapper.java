package com.zdf.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.zdf.demo.entity.CustomerKilled;

@Mapper
public interface CustomerKilledMapper {

	@Insert(value = { "insert into customerkilled values(#{id},#{goodId},#{phone},#{state},#{createtime})" })
	public void insert(CustomerKilled customerKilled);
	
	@Select(value = { "select * from CustomerKilled where phone=#{phone}" })
	public List<CustomerKilled> findByPhone(String phone);
	
}
