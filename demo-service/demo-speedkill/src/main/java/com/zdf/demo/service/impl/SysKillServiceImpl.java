package com.zdf.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdf.demo.entity.SysKill;
import com.zdf.demo.mapper.SysKillMapper;
import com.zdf.demo.service.SysKillService;

@Service
public class SysKillServiceImpl implements SysKillService {

	@Autowired
	private SysKillMapper sysKillMapper;
	
	@Override
	public void save(SysKill sysKill) {
		sysKillMapper.insert(sysKill);
		
	}

}
