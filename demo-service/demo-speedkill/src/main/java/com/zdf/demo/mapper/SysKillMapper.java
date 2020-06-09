package com.zdf.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import com.zdf.demo.entity.SysKill;

@Mapper
public interface SysKillMapper {

	@Insert(value = { "insert into syskill values(#{id},#{goodsId},#{starttime},#{endtime},#{createtime})" })
	public void insert(SysKill sysKill);
}
