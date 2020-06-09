package com.zdf.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zdf.demo.entity.CustomerKilled;
import com.zdf.demo.mapper.CustomerKilledMapper;
import com.zdf.demo.service.CustomerKilledService;

@Service
public class CustomerKilledServiceImpl implements CustomerKilledService {

	@Autowired
	private CustomerKilledMapper customerKilledMapper;
	
	@Override
	public void save(CustomerKilled customerKilled) {
		customerKilledMapper.insert(customerKilled);
	}

}
